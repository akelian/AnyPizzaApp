package by.akelian.dp.anyPizzaApp.data.drinks


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class DrinksItem(
    @SerializedName("Name")
    val name: String,
    @SerializedName("Price")
    val price: Double,
    @SerializedName("Image")
    val image: String

)