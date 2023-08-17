package edu.lejacon.lejaconservice.enclave;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
// org.apache.teaclave.javasdk.thirdpartylibs

import edu.lejacon.lejaconservice.common.HashService;

import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;

import com.google.auto.service.AutoService;

@AutoService(HashService.class)
public class HashServiceImpl implements HashService {
    private final Provider PROVIDER;

    public HashServiceImpl() {
        Provider provider = Security.getProvider("BC");
        PROVIDER = provider != null ? provider : new BouncyCastleProvider();
        Security.addProvider(PROVIDER);
    }

    @Override
    public String sayHelloWorld() {
        return "Hello World";
    }

    @Override
    public String getHashValue(String alg, String message) {
        String result;
        if (message == null) return "Null message!";
        byte[] msgBytes = message.getBytes();
        try {
            MessageDigest md = MessageDigest.getInstance(alg, "BC");
            System.out.println(alg + " provider: " + md.getProvider());
            result = doHash(md, msgBytes);
        } catch (Exception e) {
            System.out.println(e);
            result = "Unsupported hash algorithms!";
        }
        return result;
    }

    private String doHash(MessageDigest md, byte[] msgBytes) {
        md.update(msgBytes);
        return bytesToHex(md.digest());
    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}