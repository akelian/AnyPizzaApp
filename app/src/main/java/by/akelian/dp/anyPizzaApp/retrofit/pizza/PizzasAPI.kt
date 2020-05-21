package by.akelian.dp.anyPizzaApp.retrofit.pizza


import by.akelian.dp.anyPizzaApp.data.foodData.ExtendedFoodData
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface PizzasAPI {
    @GET("Pizza")
    fun getAllPizzza(): Deferred<Response<ExtendedFoodData>>
}