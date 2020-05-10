package by.akelian.dp.anyPizzaApp.retrofit.pizza

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create


const val BASE_URL =
    "https://api.backendless.com/A4682141-DFF2-A960-FFD6-169424584800/469E2E84-1983-44EF-8FEF-81F90E38301F/data/"


object PizzaAPIFactory {

    fun getOkHTTPClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }


    fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return loggingInterceptor
    }

    fun getRetrofitPizza(): PizzaAPI {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(getOkHTTPClient(getLoggingInterceptor()))
            .build()

        return retrofit.create()
    }
}