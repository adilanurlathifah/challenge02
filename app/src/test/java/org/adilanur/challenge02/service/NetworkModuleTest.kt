package org.adilanur.challenge02.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import retrofit2.Retrofit

class NetworkModuleTest {
    @Test
    fun provideOkHttpClient() {
        val mockOkHttpClient = mock(OkHttpClient::class.java)
        NetworkModule.init(mockOkHttpClient)

        val okHttpClient = NetworkModule.provideOkHttpClient()
        val hasLoggingInterceptor = okHttpClient.interceptors.any { it is HttpLoggingInterceptor }
        assert(hasLoggingInterceptor)
    }
    @Test
    fun provideRetrofit() {
        val mockOkHttpClient = mock(OkHttpClient::class.java)
        NetworkModule.init(mockOkHttpClient)

        val instance = NetworkModule.provideRetrofit()
        assert(instance.baseUrl().toString() == NetworkModule.BASE_URL)
    }
}
