package edu.lejacon.lejaconservice.common;
import org.apache.teaclave.javasdk.common.annotations.EnclaveService;

@EnclaveService
public interface HashService {
    String getHashValue(String alg, String message);
    String sayHelloWorld();
}