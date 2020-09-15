package com.prototype.enc.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.util.Base64;

public class GenSignature {
    private static final Logger LOGGER = LoggerFactory.getLogger(RSACryptography.class);

    private static PrivateKey privateKey;
    private static PublicKey publicKey;
    /**
     *   encode for even key
     */
    public static String encodeKey(Key key) {
        byte[] keyBytes = key.getEncoded();
        String encodedKeyStr = Base64.getEncoder().encodeToString(keyBytes);
        return encodedKeyStr;
    }
    /**
     *   main generation of keyPair
     */
    public static void generateKeyPair(int keySize, String algorithm)
                                                throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        //SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
        SecureRandom random = SecureRandom.getInstanceStrong();
        keyPairGenerator.initialize(keySize, random);
        KeyPair keyPair =  keyPairGenerator.genKeyPair();
        privateKey = keyPair.getPrivate();
        String privKeyStr = encodeKey(privateKey);
        LOGGER.info("Private Key:"+ privKeyStr);
        publicKey = keyPair.getPublic();
        String pubKeyStr = encodeKey(publicKey);
        LOGGER.info("Public Key:"+ pubKeyStr);
        writeOutPublicAndPrivateKey();
    }
    private static void writeOutPublicAndPrivateKey() {
        try {
            writeToFile(Constant.PUBLIC_KEY_STORE, publicKey.getEncoded());
            writeToFile(Constant.PRIVATE_KEY_STORE, privateKey.getEncoded());
        } catch (IOException e) {
            LOGGER.debug("Having exception " +
                    "" + e.getMessage());
        }
    }
    private static void writeToFile(String path, byte[] key) throws IOException {
        File f = new File(path);
        f.getParentFile().mkdirs();
        try (FileOutputStream fos = new FileOutputStream(f)) {
            fos.write(key);
            fos.flush();
        }
    }
}
