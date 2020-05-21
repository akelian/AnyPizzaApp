package by.akelian.dp.anyPizzaApp.data.foodData


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class SimpleFoodDataItem(
    @SerializedName("Name")
    override val name: String,
    @SerializedName("Price")
    override val price: Double,
    @SerializedName("Image")
    override val image: String,
    override val description: String = ""
) : SimilarFoodData