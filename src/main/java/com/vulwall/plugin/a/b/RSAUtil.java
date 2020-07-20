package com.vulwall.plugin.a.b;

import org.apache.commons.codec.binary.*;
import sun.misc.*;

import javax.crypto.*;
import java.security.*;
import java.security.spec.*;


public class RSAUtil {

    private static final String ALGORITHM = "RSA";


    public static String ce(String source) {
        try {
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(c.pu));
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
            PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] b = source.getBytes();
            byte[] b1 = cipher.doFinal(b);
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(b1);
        } catch (Exception e) {

        }
        return "";
    }


    public static String cd(String source){
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decodeBase64(c.pr));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyf.generatePrivate(priPKCS8);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] b = cipher.doFinal(decoder.decodeBuffer(source));
            return new String(b);
        } catch (Exception e) {

        }
        return "11";
    }
}
