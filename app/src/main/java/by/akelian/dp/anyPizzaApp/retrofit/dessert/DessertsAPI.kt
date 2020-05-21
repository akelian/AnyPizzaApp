package by.akelian.dp.anyPizzaApp.retrofit.dessert


import by.akelian.dp.anyPizzaApp.data.foodData.ExtendedFoodData
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface DessertsAPI {
    @GET("Dessert")
    fun getAllDesserts(): Deferred<Response<ExtendedFoodData>>
}