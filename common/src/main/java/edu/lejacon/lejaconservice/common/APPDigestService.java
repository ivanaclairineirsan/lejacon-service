package edu.lejacon.lejaconservice.common;
import org.apache.teaclave.javasdk.common.annotations.EnclaveService;

@EnclaveService
public interface APPDigestService {
    void run(String fpath);
}