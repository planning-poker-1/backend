package org.jeugenedev.planning.utils.crypto;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

@Component
public class CryptoUtils {
    private MessageDigest md5;

    public CryptoUtils() throws NoSuchAlgorithmException {
        this.md5 = MessageDigest.getInstance("MD5");
    }

    public String md5(String source) throws NoSuchAlgorithmException {
        byte[] hash = this.md5.digest(source.getBytes(StandardCharsets.UTF_8));
        return HexFormat.of().formatHex(hash);
    }
}
