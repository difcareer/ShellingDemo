#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_andr0day_shellingdemo_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hahaha";

    pthread_kill(0,0);

    return env->NewStringUTF(hello.c_str());
}
