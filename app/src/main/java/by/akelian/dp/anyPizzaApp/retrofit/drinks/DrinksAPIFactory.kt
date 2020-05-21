package by.akelian.dp.anyPizzaApp.retrofit.drinks

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


const val BASE_URL =
    "https://api.backendless.com/A4682141-DFF2-A960-FFD6-169424584800/469E2E84-1983-44EF-8FEF-81F90E38301F/data/"


object DrinksAPIFactory {

    private fun getOkHTTPClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }


    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return loggingInterceptor
    }

    fun getRetrofitDrinks(): DrinksAPI {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(getOkHTTPClient(getLoggingInterceptor()))
            .build()

        return retrofit.create()
    }
}