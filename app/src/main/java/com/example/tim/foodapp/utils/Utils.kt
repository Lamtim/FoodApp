package com.example.tim.foodapp.utils

import okhttp3.OkHttpClient
import okhttp3.CipherSuite
import okhttp3.TlsVersion
import okhttp3.ConnectionSpec
import android.os.Build
import okhttp3.logging.HttpLoggingInterceptor
import java.util.*
import java.util.concurrent.TimeUnit


class Utils {

    companion object {

        fun HttpClientBuilder(): OkHttpClient {
            val httpClient: OkHttpClient
            if (Build.VERSION.SDK_INT == 24) {
                val spec = ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                        .tlsVersions(TlsVersion.TLS_1_2)
                        .cipherSuites(CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256)
                        .build()

                httpClient = OkHttpClient.Builder()
                        .connectTimeout(5000, TimeUnit.MILLISECONDS)
                        .readTimeout(30000, TimeUnit.MILLISECONDS)
                        .writeTimeout(30000, TimeUnit.MILLISECONDS)
                        .connectionSpecs(Collections.singletonList(spec))
                        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build()
            } else {
                httpClient = OkHttpClient.Builder()
                        .connectTimeout(5000, TimeUnit.MILLISECONDS)
                        .readTimeout(30000, TimeUnit.MILLISECONDS)
                        .writeTimeout(30000, TimeUnit.MILLISECONDS)
                        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build()
            }
            return httpClient
        }
    }
}