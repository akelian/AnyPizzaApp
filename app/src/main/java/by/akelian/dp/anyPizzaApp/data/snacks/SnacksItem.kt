package by.akelian.dp.anyPizzaApp.data.snacks


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class SnacksItem(
    @SerializedName("Name")
    val name: String,
    @SerializedName("Price")
    val price: Double,
    @SerializedName("Image")
    val image: String,
    @SerializedName("Description")
    val description: String
)