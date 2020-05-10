package by.akelian.dp.anyPizzaApp.retrofit.pizza


import by.akelian.dp.anyPizzaApp.data.pizza.Pizza
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface PizzaAPI {
    @GET("Pizza")
    fun getAllPizzza(): Deferred<retrofit2.Response<Pizza>>
}