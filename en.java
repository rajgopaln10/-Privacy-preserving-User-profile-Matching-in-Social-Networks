/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile;

/**
 *
 * @author EGC
 */
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;



import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

public class en {
    public static String algo="AES";
    public byte[] keyvalue;
   // private byte[] keyValue;
    
    public en(byte key[])
    {
        keyvalue=key;
        
    }

   // AESAlgorithm(byte[] keyvalue) {

        
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 //   }
    public Key generateKey() throws Exception
    {
        Key key=new SecretKeySpec(keyvalue,algo);
        return key;
    }
    
    public String encrypt(String msg)throws Exception
    {
       Key key=generateKey();
       Cipher c=Cipher.getInstance(algo);
       c.init(Cipher.ENCRYPT_MODE,key);
       byte[] encVal=c.doFinal(msg.getBytes());
       String encryptedValue=new BASE64Encoder().encode(encVal);
       return encryptedValue;
       
       
    }
    
    public String decrypt (String msg)throws Exception
    {
    
    Key key=generateKey();
       Cipher c=Cipher.getInstance(algo);
       c.init(Cipher.DECRYPT_MODE,key);
        byte[] decordedValue=new BASE64Decoder().decodeBuffer(msg);
        byte[] decValue=c.doFinal(decordedValue);
       String decryptedValue=new String(decValue);
       return decryptedValue;
       
    
    
    
    }
    
}
