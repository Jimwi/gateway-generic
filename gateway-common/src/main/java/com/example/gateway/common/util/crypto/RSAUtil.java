package com.example.gateway.common.util.crypto;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by JiWen on 2019/7/2 at home.
 * <p>
 * 目前公钥只支持X509格式，私钥只支持PKCS8格式。可以用 RSAUtil.generateKeyPair(2048)生密钥。
 * <p>
 * jdk提供的默认加解密算法的实现，见
 * https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html
 * <p>
 * jdk加解密用法，见
 * https://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html
 */
public class RSAUtil {

    private static String SIGN_TYPE = "SHA256withRSA";
    private static String ALGORITHM = "RSA";

    public static String encrypt(String data, String publicKeyStr) {
        try {
            KeySpec keySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyStr));
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
            PublicKey publicKey = keyFactory.generatePublic(keySpec);
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encrypt = c.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return Base64.encodeBase64String(encrypt);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(String data, String privateKeyStr) {
        try {
            KeySpec keySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyStr));
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decrypt = c.doFinal(Base64.decodeBase64(data));
            return new String(decrypt, StandardCharsets.UTF_8);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }

    }

    public static String sign(String data, String privateKeyStr) {
        try {
            KeySpec keySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyStr));
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
            Signature signature = Signature.getInstance(SIGN_TYPE);
            signature.initSign(privateKey);
            signature.update(data.getBytes(StandardCharsets.UTF_8));
            return Base64.encodeBase64String(signature.sign());
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean verify(String data, String sign, String publicKeyStr) {
        try {
            KeySpec keySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyStr));
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
            PublicKey publicKey = keyFactory.generatePublic(keySpec);
            Signature signature = Signature.getInstance(SIGN_TYPE);
            signature.initVerify(publicKey);
            signature.update(data.getBytes(StandardCharsets.UTF_8));
            return signature.verify(Base64.decodeBase64(sign));
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[] generateKeyPair(Integer length) {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM);
            generator.initialize(length);
            KeyPair keyPair = generator.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();
            return new String[]
                    {Base64.encodeBase64String(privateKey.getEncoded()),
                            Base64.encodeBase64String(publicKey.getEncoded())};
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

}
