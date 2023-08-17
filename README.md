# lejacon-service

To change from simulation to hardware mode please modify `EnclaveType enclaveType = EnclaveType.MOCK_IN_JVM;` in `host/src/main/java/edu/lejacon/lejaconservice/host/App.java` or `host/src/main/java/edu/lejacon/lejaconservice/host/APPDigest.java`

To run AppDigest without enclave:
java -cp host/target/host-1.0-SNAPSHOT-jar-with-dependencies.jar:enclave/target/enclave-1.0-SNAPSHOT-jar-with-dependencies.jar edu.lejacon.lejaconservice.enclave.APPDigest ./rand256K.txt`

To run AppDigest within enclave:
OCCLUM_RELEASE_ENCLAVE=true java -cp host/target/host-1.0-SNAPSHOT-jar-with-dependencies.jar:enclave/target/enclave-1.0-SNAPSHOT-jar-with-dependencies.jar edu.lejacon.lejaconservice.host.APPDigest ./rand256K.txt 
