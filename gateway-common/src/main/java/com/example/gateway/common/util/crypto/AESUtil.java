package com.example.gateway.common.util.crypto;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Key;

/**
 * Created by JiWen on 2019/7/2 at home.
 */
public class AESUtil {

    public static final String AES_TYPE = "AES/ECB/PKCS5Padding";
    private static final String ALGORITHM = "AES"; //算法

    public static String encrypt(String data, String keyStr) throws Exception {
        Key key = new SecretKeySpec(keyStr.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_TYPE);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypt = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.encodeBase64String(encrypt);
    }

    public static String decrypt(String data, String keyStr) throws Exception {
        Key key = new SecretKeySpec(keyStr.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_TYPE);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypt = cipher.doFinal(Base64.decodeBase64(data));
        return new String(decrypt, StandardCharsets.UTF_8).trim();
    }

    public static void main(String[] args) throws Exception {
        String key = "tydhdiajsnxjsisj";
        String data = "Hello World";
        System.out.println(data);
        String m = encrypt(data, key);
        System.out.println(m);
        System.out.println(decrypt(m, key));
    }
}
