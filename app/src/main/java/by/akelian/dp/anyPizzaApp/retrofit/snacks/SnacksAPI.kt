package by.akelian.dp.anyPizzaApp.retrofit.snacks


import by.akelian.dp.anyPizzaApp.data.foodData.ExtendedFoodData
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface SnacksAPI {
    @GET("Snacks")
    fun getAllSnacks(): Deferred<Response<ExtendedFoodData>>
}