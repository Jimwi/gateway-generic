package com.example.gateway.common.util.crypto;


import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by JiWen on 2019/7/2 at home.
 */

public class MD5Util {

    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    public static String sign(String data, String key) {
        if (data == null) data = "";
        if (key == null) key = "";
        return DigestUtils.md5Hex((data + key).getBytes(DEFAULT_CHARSET));
    }

    public static boolean verify(String data, String sign, String key) {
        if (data == null) data = "";
        if (key == null) key = "";
        return Objects.equals(sign, DigestUtils.md5Hex((data + key).getBytes(DEFAULT_CHARSET)));
    }

}

