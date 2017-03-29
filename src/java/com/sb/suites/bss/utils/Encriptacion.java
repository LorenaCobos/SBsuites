package com.sb.suites.bss.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *      Descripcion :encriptacion a traves del algortimo SHA1
 *      @author Fabian molar
 */
public class Encriptacion {

    private static MessageDigest messageDigest = null;


    static {
        try {
            messageDigest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException exception) {
        }
    }

    /**
     *     Descripcion : Metodo encargado de encriptar un cadena especifica
     *
     *     Historico   : 29-ene-2009 - Jorge J Leon A - creacion de metodo
     *
     *     @param cadena Cadena a encriptada
     *     @return cadena encriptada
     */
    public static String encriptar(String cadena) {

        byte[] cadenaByte = cadena.getBytes();
        messageDigest.update(cadenaByte, 0, cadenaByte.length);
        byte[] cadenaEncriptadaByte = messageDigest.digest();
        return toHexString(cadenaEncriptadaByte);
    }

    /**
     *     Descripcion : Metodo encargado de tranformar un arreglo de bytes a una cadena con formato hexadecimal
     *
     *     Historico   : 29-ene-2009 - Jorge J Leon A - creacion de metodo
     *
     *     @param buf arreglo con elementos e tipo byte
     *     @return cadena en formato hexadecimal
     */
    private static String toHexString(byte[] buf) {
        char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuffer strBuf = new StringBuffer(buf.length * 2);
        for (int i = 0; i < buf.length; i++) {
            strBuf.append(hexChar[(buf[i] & 0xf0) >>> 4]); // fill left wit
            // zero bits
            //strBuf.append(':');
            strBuf.append(hexChar[buf[i] & 0x0f]);
        }

        return strBuf.toString();
    }
}
