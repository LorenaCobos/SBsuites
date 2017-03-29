/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sb.suites.bss.utils;

/**
 *
 * @author Ricardo
 */
public class UtilsAes {
    
    private static UtilsAes instancia;
    private int intentosWebSevice = 0;
    private int intentosWebSeviceGlobal = 0;

    public static UtilsAes getInstancia() {
        return instancia;
    }

    public static void setInstancia(UtilsAes instancia) {
        UtilsAes.instancia = instancia;
    }

    public int getIntentosWebSeviceGlobal() {
        return intentosWebSeviceGlobal;
    }

    public void setIntentosWebSeviceGlobal(int intentosWebSeviceGlobal) {
        this.intentosWebSeviceGlobal = intentosWebSeviceGlobal;
    }
    
    /**
     * 
     * @return 
     */
    public static UtilsAes getInstance() {
        if (instancia == null) {
            instancia = new UtilsAes();
        }
        return instancia;
    }
    
    /**
     * 
     * @return 
     */
    public int getIntentosWebSevice() {
        return intentosWebSevice;
    }

    /**
     * @param intentosWebSevice the intentosWebSevice to set
     */
    public void setIntentosWebSevice(int intentosWebSevice) {
        this.intentosWebSevice = intentosWebSevice;
    }
    
    
    public static String replaceAccents(String s) {
        String amp = "&";
        String acute = "acute;";
        s = s.replaceAll("[èéêë]",amp+"e"+acute);
        s = s.replaceAll("[ûù]",amp+"u"+acute);
        s = s.replaceAll("[ïî]",amp+"i"+acute);
        s = s.replaceAll("[àâ]",amp+"a"+acute);
        s = s.replaceAll("Ô",amp+"o"+acute);
        s = s.replaceAll("[ÈÉÊË]",amp+"E"+acute);
        s = s.replaceAll("[ÛÙ]",amp+"U"+acute);
        s = s.replaceAll("[ÏÎ]",amp+"I"+acute);
        s = s.replaceAll("[ÀÂ]",amp+"A"+acute);
        s = s.replaceAll("Ô",amp+"O"+acute);
    return s;
    }
    
    public static String encodeHTML(String s){
        StringBuilder out = new StringBuilder();
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
//            if(c > 127 || c=='"' || c=='<' || c=='>')
            if(c > 127 || c=='<' || c=='>')
            {
                out.append("&#").append((int)c).append(";");
            }
            else
            {
                out.append(c);
            }
        }
        return out.toString();
    }

}
