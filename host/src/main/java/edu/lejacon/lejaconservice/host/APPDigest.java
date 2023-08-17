package edu.lejacon.lejaconservice.host;

import java.util.Iterator;
import java.io.IOException;
import java.nio.file.*;
import edu.lejacon.lejaconservice.common.APPDigestService;

import org.apache.teaclave.javasdk.host.Enclave;
import org.apache.teaclave.javasdk.host.EnclaveFactory;
import org.apache.teaclave.javasdk.host.EnclaveType;

public class APPDigest {
    public static void main(String[] args) throws Exception {
        String fpath = args[0];
        // String alg = args[0];
        // String message = readUsingFiles(fpath);
        System.out.println("fpath: " + fpath);
        // System.out.println("alg: " + alg);
        
        // Enclave enclave = EnclaveFactory.create(EnclaveType.MOCK_IN_JVM);
        EnclaveType enclaveType = EnclaveType.MOCK_IN_JVM;
        Enclave enclave = EnclaveFactory.create(enclaveType);

        Iterator<APPDigestService> services = enclave.load(APPDigestService.class);
        
        while (services.hasNext()) {
            APPDigestService service = services.next();
            // System.out.println("request service: " + alg);
            service.run(fpath);
            // System.out.println(result);
        }
        enclave.destroy();
    }
}