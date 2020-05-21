package by.akelian.dp.anyPizzaApp.retrofit.drinks


import by.akelian.dp.anyPizzaApp.data.foodData.SimpleFoodData
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface DrinksAPI {
    @GET("Drinks")
    fun getAllDrinks(): Deferred<Response<SimpleFoodData>>
}