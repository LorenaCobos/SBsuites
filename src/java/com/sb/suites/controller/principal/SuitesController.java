package com.sb.suites.controller.principal;
import org.springframework.core.env.Environment;
import com.sb.formato.dao.SuitesDAO;
import com.sb.suites.cmm.ExceptionCmm;
import com.sb.suite.controller.BaseController;
import com.sb.suites.bss.catalogos.CatalogosBss;
import com.sb.suites.bss.eventos.EventosBss;
import com.sb.suites.bss.suites.SuitesBss;
import com.sb.suites.bss.usuarios.UsuariosBss;
import com.sb.suites.bss.utils.Aes;
import com.sb.suites.dwr.utils.AesDwr;
import com.sb.suites.entidades.eventos.EventoSeleccionadoEntidad;
import com.sb.suites.entidades.eventos.UploadedFile;
import com.sb.suites.entidades.eventos.invtadosEntidad;
import com.sb.suites.entidades.suite.SuiteEntidad;
import com.sb.suites.entidades.usuarios.CatalogoEntidad;
import com.sb.suites.entidades.usuarios.FuncionalidadOperacion;
import com.sb.suites.entidades.usuarios.UsuariosEntidad;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author fabiam molar
 */
@Controller
public class SuitesController extends BaseController implements Serializable {

    CatalogosBss catalogo = new CatalogosBss();
    SuitesBss suite = new SuitesBss();
    SuitesDAO suiteDao = new SuitesDAO();
    UsuariosBss usuarioBss = new UsuariosBss();
    UploadedFile ufile = new UploadedFile();
    EventosBss eventos = new EventosBss();
    @Autowired
	private Environment environment;

    @Value("${key_repositorio}")
    public String REPOSITORIO_ESTACIONAMIENTO;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpSession session, HttpServletResponse response, HttpServletRequest req) throws ExceptionCmm, Exception {
        String ciudadUrl = "";
        if (req.getParameter("ciudad") != null) {
            ciudadUrl = req.getParameter("ciudad").toUpperCase();
            Pattern pattern = Pattern.compile("MX|ACMX|DF|MEXICO");
            session.setAttribute("opcion", pattern.matcher(ciudadUrl).find() ? 1 : 2);
        } else if (session.getAttribute("opcion") != null) {

        } else {
//            session.setAttribute("opcion", 0);
            return loginSeleccion(session, response, req);
        }
       
        session.setMaxInactiveInterval(Integer.parseInt(environment.getProperty("sessionTimeOut", "600")));
        ModelAndView modeloVista = new ModelAndView("login");
        String contexto = obtenerContexto("http", req.getServerName(), String.valueOf(req.getServerPort()));
        modeloVista.addObject("contexto", contexto);
        return modeloVista;
        
    }

    @RequestMapping(value = "/loginSel", method = RequestMethod.GET)
    public ModelAndView loginSeleccion(HttpSession session, HttpServletResponse response, HttpServletRequest req) throws ExceptionCmm, Exception {
        ModelAndView modeloVista = new ModelAndView("loginSel");
        session.setMaxInactiveInterval(Integer.parseInt(environment.getProperty("sessionTimeOut", "600")));
        if(session.getAttribute("usuarioEntidad") == null)
        {
            return Login_(req);
        }
        else
        {
            String ciudadUrl = "";
            String contexto = obtenerContexto("http", req.getServerName(), String.valueOf(req.getServerPort()));
            modeloVista.addObject("contexto", contexto);
            return modeloVista;
        }
    }

//    @RequestMapping(value = "/loginSel", method = RequestMethod.GET)
//    public ModelAndView loginSeleccion(HttpSession session, HttpServletResponse response, HttpServletRequest req) throws ExceptionCmm, Exception {
//        ModelAndView modeloVista = new ModelAndView("loginSel");
//        String ciudadUrl = "";
//        String contexto = obtenerContexto("http", req.getServerName(), String.valueOf(req.getServerPort()));
//        modeloVista.addObject("contexto", contexto);
//        return modeloVista;
//    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session, HttpServletResponse response) throws ExceptionCmm, Exception {
        ModelAndView modeloVista = new ModelAndView("logout");
        return modeloVista;
    }

    @RequestMapping(value = "/s/suites", method = RequestMethod.GET)
    public ModelAndView suites(HttpSession session, HttpServletResponse response, HttpServletRequest req) throws ExceptionCmm, Exception {
        session.setMaxInactiveInterval(Integer.parseInt(environment.getProperty("sessionTimeOut", "600")));
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad"); 
        if(session.getAttribute("usuarioEntidad") == null)
        {
            return Login_(req);
        }
        else
        {
            //session.getAttribute("usuarioEntidad");
            String contexto = obtenerContexto("http", req.getServerName(), String.valueOf(req.getServerPort()));
            ModelAndView modeloVista = new ModelAndView("suites");
            modeloVista.addObject("menu", getMenuModulosUsuario(req, session));
            modeloVista.addObject("user", getUser(req, session));
            modeloVista.addObject("contexto", contexto);
            modeloVista.addObject("estatus", catalogo.getEstatus(req.getLocale().getLanguage().equals("es") ? 1 : 2));
            modeloVista.addObject("recintos", catalogo.getRecintos(usuario.getUsuarioId()));
            modeloVista.addObject("funcionalidades", session.getAttribute("funcionalidades") == null ? new ArrayList<FuncionalidadOperacion>() : (ArrayList<FuncionalidadOperacion>) session.getAttribute("funcionalidades"));
             return modeloVista;
        }
    }

    @RequestMapping(value = "/s/administracion", method = RequestMethod.GET)
    public ModelAndView administracion(HttpSession session, HttpServletResponse response, HttpServletRequest req) throws ExceptionCmm, Exception {
        session.setMaxInactiveInterval(Integer.parseInt(environment.getProperty("sessionTimeOut", "600")));
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
        if(session.getAttribute("usuarioEntidad") == null)
        {
            return Login_(req);
        }
        else
        {
            ModelAndView modeloVista = new ModelAndView("eventosAdmin");
            String contexto = obtenerContexto("http", req.getServerName(), String.valueOf(req.getServerPort()));
            modeloVista.addObject("contexto", contexto);
            modeloVista.addObject("menu", getMenuModulosUsuario(req, session));
            modeloVista.addObject("user", getUser(req, session));
            modeloVista.addObject("recintos", catalogo.getRecintos(usuario.getUsuarioId()));
            modeloVista.addObject("estatus", catalogo.getEstatus(req.getLocale().getLanguage().equals("es") ? 1 : 2));
            modeloVista.addObject("funcionalidades", session.getAttribute("funcionalidades") == null ? new ArrayList<FuncionalidadOperacion>() : (ArrayList<FuncionalidadOperacion>) session.getAttribute("funcionalidades"));
            return modeloVista;
        }
    }

  @RequestMapping(value = "/s/detalleEventoAdmin", method = RequestMethod.POST)
    public ModelAndView detalleEventoAdmin(HttpSession session, HttpServletResponse response, HttpServletRequest req) throws ExceptionCmm, Exception {
        ModelAndView modeloVista = new ModelAndView("detalleEventoAdmin");
        session.setMaxInactiveInterval(Integer.parseInt(environment.getProperty("sessionTimeOut", "600")));
        if(session.getAttribute("usuarioEntidad") == null)
        {
           return Login_(req);
        }
        else
        {
            String contexto = obtenerContexto("http", req.getServerName(), String.valueOf(req.getServerPort()));
            modeloVista.addObject("contexto", contexto);
            modeloVista.addObject("menu", getMenuModulosUsuario(req, session));
            modeloVista.addObject("user", getUser(req, session));
            modeloVista.addObject("funcionalidades", session.getAttribute("funcionalidades") == null ? new ArrayList<FuncionalidadOperacion>() : (ArrayList<FuncionalidadOperacion>) session.getAttribute("funcionalidades"));
            return modeloVista;
        }
    }

    @RequestMapping(value = "/s/AyudaBoletos", method = RequestMethod.GET)
    public ModelAndView AyudaBoletos(HttpSession session, HttpServletResponse response, HttpServletRequest req) throws ExceptionCmm, Exception {
        ModelAndView modeloVista = new ModelAndView("AyudaBoletos");
        session.setMaxInactiveInterval(Integer.parseInt(environment.getProperty("sessionTimeOut", "600")));
        if(session.getAttribute("usuarioEntidad") == null)
        {
           return Login_(req);
        }
        else
        {
            String contexto = obtenerContexto("http", req.getServerName(), String.valueOf(req.getServerPort()));
            modeloVista.addObject("contexto", contexto);
            modeloVista.addObject("menu", getMenuModulosUsuario(req, session));
            modeloVista.addObject("user", getUser(req, session));
            modeloVista.addObject("funcionalidades", session.getAttribute("funcionalidades") == null ? new ArrayList<FuncionalidadOperacion>() : (ArrayList<FuncionalidadOperacion>) session.getAttribute("funcionalidades"));
            return modeloVista;
        }
    }

    @RequestMapping(value = "/s/eventos", method = RequestMethod.GET)
    public ModelAndView eventos(HttpSession session, HttpServletResponse response, HttpServletRequest req) throws ExceptionCmm, Exception {
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
       session.setMaxInactiveInterval(Integer.parseInt(environment.getProperty("sessionTimeOut", "600")));
        if(session.getAttribute("usuarioEntidad") == null)
        {
           return Login_(req);
        }
        else
        {
            ModelAndView modeloVista = new ModelAndView("eventos");
            String contexto = obtenerContexto("http", req.getServerName(), String.valueOf(req.getServerPort()));
            modeloVista.addObject("contexto", contexto);
            modeloVista.addObject("menu", getMenuModulosUsuario(req, session));
            modeloVista.addObject("user", getUser(req, session));
            ArrayList<CatalogoEntidad> recintos = catalogo.getRecintos(usuario.getUsuarioId());
            modeloVista.addObject("recintos", recintos);
            if (recintos != null && recintos.size() == 1) {
                modeloVista.addObject("suites", catalogo.getSuitesUsuario(recintos.get(0).getId(), 0, usuario.getUsuarioId()));
            } else if (recintos != null && recintos.size() >= 2) {
                modeloVista.addObject("suites", new ArrayList<CatalogoEntidad>());
            }

            modeloVista.addObject("estatus", catalogo.getEstatus(req.getLocale().getLanguage().equals("es") ? 1 : 2));
            modeloVista.addObject("funcionalidades", session.getAttribute("funcionalidades") == null ? new ArrayList<FuncionalidadOperacion>() : (ArrayList<FuncionalidadOperacion>) session.getAttribute("funcionalidades"));
            return modeloVista;
        }
    }

    @RequestMapping(value = "/s/detalleEvento", method = RequestMethod.POST)
    public ModelAndView detalleEvento(@ModelAttribute("command") EventoSeleccionadoEntidad eventoSeleccionado, HttpSession session, HttpServletResponse response, HttpServletRequest req) throws ExceptionCmm, Exception {
       session.setMaxInactiveInterval(Integer.parseInt(environment.getProperty("sessionTimeOut", "600")));
        if(session.getAttribute("usuarioEntidad") == null)
        {
           return Login_(req);
        }
        else
        {
            ModelAndView modeloVista = new ModelAndView("detalleEvento");
            String contexto = obtenerContexto("http", req.getServerName(), String.valueOf(req.getServerPort()));
            modeloVista.addObject("contexto", contexto);
            modeloVista.addObject("menu", getMenuModulosUsuario(req, session));
            modeloVista.addObject("user", getUser(req, session));
            modeloVista.addObject("evento", eventoSeleccionado);
            modeloVista.addObject("contexto", contexto);
            modeloVista.addObject("funcionalidades", session.getAttribute("funcionalidades") == null ? new ArrayList<FuncionalidadOperacion>() : (ArrayList<FuncionalidadOperacion>) session.getAttribute("funcionalidades"));
            return modeloVista;
        }
    }
    
    
    @RequestMapping(value = "/s/usuarios", method = RequestMethod.GET)
    public ModelAndView usuarios(HttpSession session, HttpServletResponse response, HttpServletRequest req) throws ExceptionCmm, Exception {
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
        session.setMaxInactiveInterval(Integer.parseInt(environment.getProperty("sessionTimeOut", "600")));
        if(session.getAttribute("usuarioEntidad") == null)
        {
           return Login_(req);
        }
        else
        {
            ModelAndView modeloVista = new ModelAndView("usuarios");
            String contexto = obtenerContexto("http", req.getServerName(), String.valueOf(req.getServerPort()));
            modeloVista.addObject("contexto", contexto);
            modeloVista.addObject("menu", getMenuModulosUsuario(req, session));
            modeloVista.addObject("user", getUser(req, session));
            modeloVista.addObject("estatus", catalogo.getEstatus(req.getLocale().getLanguage().equals("es") ? 1 : 2));
            modeloVista.addObject("tipos", catalogo.getTipos(usuario.getUsuarioId(), req.getLocale().getLanguage().equals("es") ? 1 : 2));
            modeloVista.addObject("recintos", catalogo.getRecintos(usuario.getUsuarioId()));
            modeloVista.addObject("suites", catalogo.getSuitesUsuario(0, usuario.getUsuarioId()));
            modeloVista.addObject("funcionalidades", session.getAttribute("funcionalidades") == null ? new ArrayList<FuncionalidadOperacion>() : (ArrayList<FuncionalidadOperacion>) session.getAttribute("funcionalidades"));
            return modeloVista;
        }
    }

    @RequestMapping(value = "/invitaciones", method = RequestMethod.GET)
    public ModelAndView invitaciones(HttpSession session, HttpServletResponse response, HttpServletRequest req) throws ExceptionCmm, Exception {
        ModelAndView modeloVista = new ModelAndView("login");
        
        String contexto = obtenerContexto("http", req.getServerName(), String.valueOf(req.getServerPort()));
        modeloVista.addObject("contexto", contexto);
        modeloVista.addObject("menu", getMenuModulosUsuario(req, session));
        modeloVista.addObject("user", getUser(req, session));
        return modeloVista;
    }

    @RequestMapping(value = "/s/detalleSuite", method = RequestMethod.POST)
    public ModelAndView detalleSuite(@ModelAttribute("command") EventoSeleccionadoEntidad eventoSeleccionado, HttpSession session, HttpServletResponse response, HttpServletRequest req) throws ExceptionCmm, Exception {
       session.setMaxInactiveInterval(Integer.parseInt(environment.getProperty("sessionTimeOut", "600")));
        ModelAndView modeloVista = new ModelAndView("detalleSuite");
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
        if(session.getAttribute("usuarioEntidad") == null)
        {
           return Login_(req);
        }
        else
        {
            modeloVista.addObject("menu", getMenuModulosUsuario(req, session));
            modeloVista.addObject("user", getUser(req, session));
            SuiteEntidad suiteInfo = suite.getSuite(eventoSeleccionado.getSuiteId(), (req.getLocale().getLanguage().equals("es") ? "1" : "2"));
            modeloVista.addObject("estatus", catalogo.getEstatus(req.getLocale().getLanguage().equals("es") ? 1 : 2));
            modeloVista.addObject("cantidadEvento", catalogo.getNumeroEventos(req.getLocale().getLanguage().equals("es") ? 1 : 2));
            modeloVista.addObject("tipoEvento", catalogo.getTiposEvento(req.getLocale().getLanguage().equals("es") ? 1 : 2));
            modeloVista.addObject("suite", suiteInfo);
            modeloVista.addObject("suites", catalogo.getSuitesDisponibles(usuario.getUsuarioId(), eventoSeleccionado.getRecintoId(), suiteInfo.getSeccionUbicacionId()));
            String contexto = obtenerContexto("http", req.getServerName(), String.valueOf(req.getServerPort()));
            modeloVista.addObject("contexto", contexto);
            modeloVista.addObject("seleccion", eventoSeleccionado);
            modeloVista.addObject("funcionalidades", session.getAttribute("funcionalidades") == null ? new ArrayList<FuncionalidadOperacion>() : (ArrayList<FuncionalidadOperacion>) session.getAttribute("funcionalidades"));
            return modeloVista;
        }
    }

    @RequestMapping(value = "/invitacion", method = RequestMethod.GET)
    public ModelAndView invitacion(HttpSession session, HttpServletResponse response, HttpServletRequest req) throws ExceptionCmm, Exception {
       
            ModelAndView modeloVista = new ModelAndView("invitacion");
            modeloVista.addObject("evento", suiteDao.obtenerInfoInvitacion(0, Integer.parseInt(Aes.decrypt((String) req.getParameter("id")))));
            return modeloVista;
   
    }

    @RequestMapping(value = "/s/detalleUsuario", method = RequestMethod.POST)
    public ModelAndView detalleUsuarios(HttpSession session, HttpServletResponse response, HttpServletRequest req) throws ExceptionCmm, Exception {
        ModelAndView modeloVista = new ModelAndView("detalleUsuarios");
        session.setMaxInactiveInterval(Integer.parseInt(environment.getProperty("sessionTimeOut", "600")));
        UsuariosEntidad usuario = session.getAttribute("usuarioEntidad") == null ? new UsuariosEntidad() : (UsuariosEntidad) session.getAttribute("usuarioEntidad");
        if(session.getAttribute("usuarioEntidad") == null)
        {
           return Login_(req);
        }
        else
        {
            modeloVista.addObject("menu", getMenuModulosUsuario(req, session));
            modeloVista.addObject("user", getUser(req, session));
            modeloVista.addObject("estatus", catalogo.getEstatus(req.getLocale().getLanguage().equals("es") ? 1 : 2));
            modeloVista.addObject("tipos", catalogo.getTipos(usuario.getUsuarioId(), req.getLocale().getLanguage().equals("es") ? 1 : 2));
            modeloVista.addObject("usuario", usuarioBss.getUsuario(Integer.parseInt(AesDwr.decrypt(req.getParameter("usuario"))), req.getLocale().getLanguage().equals("es") ? "1" : "2"));
            modeloVista.addObject("suites", catalogo.getSuitesUsuario(usuario.getUsuarioId(), Integer.parseInt(AesDwr.decrypt(req.getParameter("usuario")))));
            String contexto = obtenerContexto("http", req.getServerName(), String.valueOf(req.getServerPort()));
            modeloVista.addObject("contexto", contexto);
            modeloVista.addObject("funcionalidades", session.getAttribute("funcionalidades") == null ? new ArrayList<FuncionalidadOperacion>() : (ArrayList<FuncionalidadOperacion>) session.getAttribute("funcionalidades"));
            return modeloVista;
        }
    }

    @RequestMapping(value = "/invitados", method = RequestMethod.GET)
    public @ResponseBody
    invtadosEntidad getShopInJSON1() {

        invtadosEntidad shop = new invtadosEntidad();
        shop.setInvitadosString(new String[]{"ricardo", "uriel"});

        return shop;

    }

    @RequestMapping(value = "/invitados", method = RequestMethod.POST)
    public @ResponseBody
    invtadosEntidad getShopInJSON() {

        invtadosEntidad shop = new invtadosEntidad();
        shop.setInvitadosString(new String[]{"mkyong1", "mkyong2"});

        return shop;

    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public void get(HttpServletResponse response, HttpSession session) throws ExceptionCmm {
        try {
            response.setContentType(ufile.type);
            response.setContentLength(ufile.length);
            FileCopyUtils.copy(ufile.bytes, response.getOutputStream());
            
            CatalogoEntidad repositorio = catalogo.getPathRepositorio(Integer.parseInt(REPOSITORIO_ESTACIONAMIENTO)); 
            String nombreArchivo = "Evento_"+ufile.id+ufile.name.substring(ufile.name.lastIndexOf("."), ufile.name.length()).toLowerCase() ;
            FileCopyUtils.copy(ufile.bytes, new FileOutputStream(new File(repositorio.getTextId()+nombreArchivo)));
            session.setAttribute("REPOSITORIO_ESTACIONAMIENTO", REPOSITORIO_ESTACIONAMIENTO);
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    String upload(MultipartHttpServletRequest request, HttpServletResponse response,HttpSession session) throws ExceptionCmm {

     //0. notice, we have used MultipartHttpServletRequest
        //1. get the files from the request object
        Iterator<String> itr = request.getFileNames();

        MultipartFile mpf = request.getFile(itr.next());
     
        System.out.println(mpf.getOriginalFilename() + " uploaded!");
        
        try {
            //just temporary save file info into ufile
            ufile.length = mpf.getBytes().length;
            ufile.bytes = mpf.getBytes();
            ufile.type = mpf.getContentType();
            ufile.name = mpf.getOriginalFilename();
            ufile.id   = request.getParameter("id");
            
            CatalogoEntidad repositorio = catalogo.getPathRepositorio(Integer.parseInt(REPOSITORIO_ESTACIONAMIENTO)); 
            String nombreArchivo = "Evento_"+ufile.id+ufile.name.substring(ufile.name.lastIndexOf("."), ufile.name.length()).toLowerCase() ;
            FileCopyUtils.copy(ufile.bytes, new FileOutputStream(new File(repositorio.getTextId()+nombreArchivo)));
            session.setAttribute("REPOSITORIO_ESTACIONAMIENTO", REPOSITORIO_ESTACIONAMIENTO);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

     //2. send it back to the client as <img> that calls get method
        //we are using getTimeInMillis to avoid server cached image 
        return "../get.do";

    }
    
    public ModelAndView Login_(HttpServletRequest req)
    {
        ModelAndView modeloVista = new ModelAndView("login");
        String contexto = obtenerContexto("http", req.getServerName(), String.valueOf(req.getServerPort()));
        modeloVista.addObject("contexto", contexto);
        return modeloVista;
    }

}
