package edu.lejacon.lejaconservice.host;

import java.util.Iterator;
import java.io.IOException;
import java.nio.file.*;
import edu.lejacon.lejaconservice.common.HashService;
// import edu.lejacon.enclave.Enclave;
// import edu.lejacon.enclave.EnclaveFactory;

import org.apache.teaclave.javasdk.host.Enclave;
import org.apache.teaclave.javasdk.host.EnclaveFactory;
import org.apache.teaclave.javasdk.host.EnclaveType;

public class App {
    private static String readUsingFiles(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) throws Exception {
        String fpath = args[1];
        String alg = args[0];
        String message = readUsingFiles(fpath);
        System.out.println("fpath: " + fpath);
        System.out.println("alg: " + alg);
        
        // Enclave enclave = EnclaveFactory.create(EnclaveType.MOCK_IN_JVM);
        EnclaveType enclaveType = EnclaveType.MOCK_IN_JVM;
        Enclave enclave = EnclaveFactory.create(enclaveType);

        Iterator<HashService> services = enclave.load(HashService.class);
        
        while (services.hasNext()) {
            HashService service = services.next();
            System.out.println("request service: " + alg);
            String result = service.getHashValue(alg, message);
            System.out.println(result);
        }
        enclave.destroy();
    }
}