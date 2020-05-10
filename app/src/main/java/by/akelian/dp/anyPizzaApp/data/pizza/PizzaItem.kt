package by.akelian.dp.anyPizzaApp.data.pizza


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class PizzaItem(
    @SerializedName("Name")
    val name: String,
    @SerializedName("Price")
    val price: Double,
    @SerializedName("Image")
    val image: String,
    @SerializedName("Description")
    val description: String
)