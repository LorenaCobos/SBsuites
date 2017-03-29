/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sb.suites.entidades;

/**
 *
 * @author fabiam molar
 */
import java.lang.reflect.Field;

public class BaseEntidad 
{
    private int resultado = 0;
    private String mensajeResultado = "";
    
    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public String getMensajeResultado() {
        return mensajeResultado;
    }

    public void setMensajeResultado(String mensajeResultado) {
        this.mensajeResultado = mensajeResultado;
    }



    @Override
    public String toString(){

        StringBuilder sbAuxiliar = new StringBuilder();
        Class objClass = this.getClass();
        Field[] arrFields = objClass.getDeclaredFields();
        sbAuxiliar.append("{ ");
        for(int i=0,a=arrFields.length;i<a;i++)
        {
            try{
                arrFields[i].setAccessible(true);
                sbAuxiliar.append(arrFields[i].getName());
                sbAuxiliar.append("=");
                Object Obj = arrFields[i].get(this);
                sbAuxiliar.append(Obj);
                sbAuxiliar.append("|");
            }
            catch(Exception e){
            }
        }
        if(arrFields.length>0)
        {
            sbAuxiliar.deleteCharAt(arrFields.length -1);
        }
        sbAuxiliar.append(" }");

        return sbAuxiliar.toString();
    }
}
