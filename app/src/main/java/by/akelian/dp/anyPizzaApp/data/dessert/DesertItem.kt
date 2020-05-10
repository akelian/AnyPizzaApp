package by.akelian.dp.anyPizzaApp.data.dessert


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class DesertItem(
    @SerializedName("Name")
    val name: String,
    @SerializedName("Price")
    val price: Double,
    @SerializedName("Image")
    val image: String,
    @SerializedName("Description")
    val description: String
)