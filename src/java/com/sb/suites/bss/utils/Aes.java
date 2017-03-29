package com.sb.suites.bss.utils;

/**
 * @author luis
 */
public class Aes {

    private final static String pwd = "XmdukHGRv45cDF";/*llave original*/
//    private final static String pwd = "XmdukHGRv45cDFa";

    /**
     * 
     * @param plaintext
     * @param enc
     * @return 
     */

    
    public static String encrypt(String plaintext) {
        return encrypt(plaintext, pwd);
    }
    /**
     * 
     * @param ciphertext
     * @param enc
     * @return
     * @throws Exception 
     */

    
    public static String decrypt(String plaintext) throws Exception{
        return decrypt(plaintext,pwd);
    }

    private static String decrypt(String ciphertext, String password) throws Exception {
        return UtilsAes.replaceAccents(SuperBoletosCryptiOS.AES128DecryptText(ciphertext, password));
    }
   

    private static String encrypt(String plaintext, String password) {
        try {
            return SuperBoletosCryptiOS.AES128EncryptText(plaintext, password);
        } catch (Exception ex) {
            return "";
        }
    }
    

    public static String md5(String texto) {
        try {
            return SuperBoletosCryptiOS.MD5String(texto);
        } catch (Exception ex) {
            return "";
        }
    }
}
