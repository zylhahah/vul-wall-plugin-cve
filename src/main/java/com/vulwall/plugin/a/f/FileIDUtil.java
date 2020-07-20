package com.vulwall.plugin.a.f;

import org.apache.commons.codec.binary.*;
import java.io.*;
import java.security.*;

public class FileIDUtil {

    public static String createId(File file) {
        try {
            FileInputStream inputStream = new FileInputStream( file );
            DigestInputStream digestInputStream = new DigestInputStream( inputStream ,
                    getMessageDigest() );
            byte[] arrayOfByte = new byte[1024];
            while ( digestInputStream.read( arrayOfByte ) != -1 ) {
            }
            MessageDigest messageDigest = digestInputStream.getMessageDigest();
            return Hex.encodeHexString( messageDigest.digest() );
        }
        catch ( Exception e ) {

        }
        return "" ;
    }

    public static String a(File file) {
        FileInputStream fileInputStream = null;
        try {
            MessageDigest MD5 = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[8192];
            int length;
            while ((length = fileInputStream.read(buffer)) != -1) {
                MD5.update(buffer, 0, length);
            }
            return new String(Hex.encodeHex(MD5.digest()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (fileInputStream != null){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    static MessageDigest getMessageDigest() throws NoSuchAlgorithmException
    {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        return messageDigest;
    }
}
