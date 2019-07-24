package com.xubao.test.simpleTest.zookeeperTest.simple;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class ZooUtil {


    private static final String SHA1 = "SHA1";
    private static final String COLON = ":";

    public static String generateDigest(final String idPassword) throws NoSuchAlgorithmException {
        final String parts[] = idPassword.split(COLON, 2);
        final byte digest[] = MessageDigest.getInstance(SHA1).digest(idPassword.getBytes());//将整个一起加密
        System.out.println();
        return parts[0] + COLON + base64Encode(digest);
    }

    private static String base64Encode(final byte byteDigest[]) {

        return new String(Base64.getEncoder().encode(byteDigest));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String s = generateDigest("admin:admin");
        System.out.println(s);
    }
}
