#ifndef __LIB_MOCK_SVM_LOAD_H
#define __LIB_MOCK_SVM_LOAD_H

#include <graal_isolate.h>


#if defined(__cplusplus)
extern "C" {
#endif

int create_isolate_with_params(int, char**, graal_isolate_t**, graal_isolatethread_t**);

int java_loadservice_invoke(graal_isolate_t*, enc_data_t*, enc_data_t*, callbacks_t*);

int java_unloadservice_invoke(graal_isolate_t*, enc_data_t*, enc_data_t*, callbacks_t*);

int java_enclave_invoke(graal_isolate_t*, enc_data_t*, enc_data_t*, callbacks_t*);

#if defined(__cplusplus)
}
#endif
#endif
