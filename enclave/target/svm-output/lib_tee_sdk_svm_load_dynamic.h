#ifndef __LIB_TEE_SDK_SVM_LOAD_H
#define __LIB_TEE_SDK_SVM_LOAD_H

#include <graal_isolate_dynamic.h>


#if defined(__cplusplus)
extern "C" {
#endif

typedef int (*create_isolate_with_params_fn_t)(int, char**, graal_isolate_t**, graal_isolatethread_t**);

typedef int (*java_loadservice_invoke_fn_t)(graal_isolate_t*, enc_data_t*, enc_data_t*, callbacks_t*);

typedef int (*java_unloadservice_invoke_fn_t)(graal_isolate_t*, enc_data_t*, enc_data_t*, callbacks_t*);

typedef int (*java_enclave_invoke_fn_t)(graal_isolate_t*, enc_data_t*, enc_data_t*, callbacks_t*);

#if defined(__cplusplus)
}
#endif
#endif
