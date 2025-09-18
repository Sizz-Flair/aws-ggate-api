package com.sms.ggateapi.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

public class AES256Util {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final int KEY_SIZE = 32; // 256비트 = 32바이트
    private static final int IV_SIZE = 16;  // AES 블록 크기 = 16바이트

    private final String iv;
    private final Key keySpec;

    public AES256Util(String key) {
        if (key == null || key.isEmpty()) {
            key = "DDmyEeSkS31cIkcK"; // 기본 키
        }

        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);

        // 키 길이가 부족하면 32바이트로 패딩
        byte[] keyPadded = new byte[KEY_SIZE];
        System.arraycopy(keyBytes, 0, keyPadded, 0, Math.min(keyBytes.length, KEY_SIZE));

        this.iv = key.substring(0, Math.min(key.length(), IV_SIZE));
        this.keySpec = new SecretKeySpec(keyPadded, "AES");
    }

    /** 암호화 */
    public String encrypt(String plainText) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8)));
            byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new IllegalStateException("AES 암호화 실패", e);
        }
    }

    /** 복호화 */
    public String decrypt(String cipherText) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8)));
            byte[] decoded = Base64.getDecoder().decode(cipherText);
            return new String(cipher.doFinal(decoded), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new IllegalStateException("AES 복호화 실패", e);
        }
    }
}
