package com.sb.suites.bss.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 *
 * @author danno
 */
//****************************************************************
//***** NO IMPLEMENTAR ESTOS METODOS, SON SOLO PARA USO INTERNO******
//****************************************************************
public class SuperBoletosEncryptUtils {
 
    public static String MD5String(String textToHash) throws Exception
    {
        return asHex(MD5Bytes(textToHash));
        
    }
    public static byte[] MD5Bytes(String textToHash) throws Exception {
     
        byte[] hashedBuffer=textToHash.getBytes("UTF-8");
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        hashedBuffer = md5.digest(hashedBuffer);
        hashedBuffer = Arrays.copyOf(hashedBuffer, 16); // use only first 128 bit
        return hashedBuffer;
    }
    
  //****************BASE64************************************//
  /**
   * Codifica a base64 con strings
   **/
  public  static String encode64(String s) throws UnsupportedEncodingException {
    return encode64(s.getBytes("UTF-8"));
  }
  
   /**
   *  Decodifica base64 string y regresa buffer de bytes
   */
  public  static byte[] decode64(String str) throws UnsupportedEncodingException
  {
    if (str == null)  return  null;
    byte data[] = decode64(str.getBytes("UTF-8"));
    
    return data;
  }
  
  /**
   *  Codifica a base 64 recibiendo binario y regresando string
   */
  public  static String encode64(byte[] d)
  {
    if (d == null) return null;
    byte data[] = new byte[d.length+2];
    System.arraycopy(d, 0, data, 0, d.length);
    byte dest[] = new byte[(data.length/3)*4];

    // 3-byte to 4-byte conversion
    for (int sidx = 0, didx=0; sidx < d.length; sidx += 3, didx += 4)
    {
      dest[didx]   = (byte) ((data[sidx] >>> 2) & 077);
      dest[didx+1] = (byte) ((data[sidx+1] >>> 4) & 017 |
                  (data[sidx] << 4) & 077);
      dest[didx+2] = (byte) ((data[sidx+2] >>> 6) & 003 |
                  (data[sidx+1] << 2) & 077);
      dest[didx+3] = (byte) (data[sidx+2] & 077);
    }

    // 0-63 to ascii printable conversion
    for (int idx = 0; idx <dest.length; idx++)
    {
      if (dest[idx] < 26)     dest[idx] = (byte)(dest[idx] + 'A');
      else if (dest[idx] < 52)  dest[idx] = (byte)(dest[idx] + 'a' - 26);
      else if (dest[idx] < 62)  dest[idx] = (byte)(dest[idx] + '0' - 52);
      else if (dest[idx] < 63)  dest[idx] = (byte)'^';
      else            dest[idx] = (byte)'~';
    }

    // add padding
    for (int idx = dest.length-1; idx > (d.length*4)/3; idx--)
    {
      dest[idx] = (byte)'=';
    }
    return new String(dest);
  }


  /**
   *  Decodifica a base64 usando binarios
   */
  public  static byte[] decode64(byte[] data)
  {
    int tail = data.length;
    while (data[tail-1] == '=')  tail--;
    byte dest[] = new byte[tail - data.length/4];

    // ascii printable to 0-63 conversion
    for (int idx = 0; idx <data.length; idx++)
    {
      if (data[idx] == '=')    data[idx] = 0;
      else if (data[idx] == '~') data[idx] = 63;
      else if (data[idx] == '^') data[idx] = 62;
      else if (data[idx] >= '0'  &&  data[idx] <= '9')
        data[idx] = (byte)(data[idx] - ('0' - 52));
      else if (data[idx] >= 'a'  &&  data[idx] <= 'z')
        data[idx] = (byte)(data[idx] - ('a' - 26));
      else if (data[idx] >= 'A'  &&  data[idx] <= 'Z')
        data[idx] = (byte)(data[idx] - 'A');
    }

    // 4-byte to 3-byte conversion
    int sidx, didx;
    for (sidx = 0, didx=0; didx < dest.length-2; sidx += 4, didx += 3)
    {
      dest[didx]   = (byte) ( ((data[sidx] << 2) & 255) |
              ((data[sidx+1] >>> 4) & 3) );
      dest[didx+1] = (byte) ( ((data[sidx+1] << 4) & 255) |
              ((data[sidx+2] >>> 2) & 017) );
      dest[didx+2] = (byte) ( ((data[sidx+2] << 6) & 255) |
              (data[sidx+3] & 077) );
    }
    if (didx < dest.length)
    {
      dest[didx]   = (byte) ( ((data[sidx] << 2) & 255) |
              ((data[sidx+1] >>> 4) & 3) );
    }
    if (++didx < dest.length)
    {
      dest[didx]   = (byte) ( ((data[sidx+1] << 4) & 255) |
              ((data[sidx+2] >>> 2) & 017) );
    }
    return dest;
  }
  
  /**
   * Metodo para sacar la representacion hexadecimal en tipo String de un buffer de bytes
   * 
   */
   public static String asHex (byte buf[]) {
      StringBuilder strbuf = new StringBuilder(buf.length * 2);
      int i;

      for (i = 0; i < buf.length; i++) {
       if (((int) buf[i] & 0xff) < 0x10)
	    strbuf.append("0");

       strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
      }

      return strbuf.toString().toLowerCase();
     }

}
