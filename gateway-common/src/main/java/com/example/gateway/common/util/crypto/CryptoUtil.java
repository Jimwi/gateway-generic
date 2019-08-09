package com.example.gateway.common.util.crypto;


import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;

/**
 * @author JiWen
 * @time 2019/8/9
 * @since 1.0.0
 */
public abstract class CryptoUtil {
    static {
        //加载BouncyCastle加密工具
        Security.addProvider(new BouncyCastleProvider());
    }
}
