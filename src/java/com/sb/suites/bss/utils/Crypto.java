/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sb.suites.bss.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author fabiam molar
 */
public class Crypto 
{
    private static MessageDigest messageDigest = null;


    static {
        try {
            messageDigest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException exception) {
        }
    }

    public static String encriptar(String cadena) {

        byte[] cadenaByte = cadena.getBytes();
        messageDigest.update(cadenaByte, 0, cadenaByte.length);
        byte[] cadenaEncriptadaByte = messageDigest.digest();
        return toHexString(cadenaEncriptadaByte);
    }

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
