package by.akelian.dp.anyPizzaApp.ui.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.akelian.dp.anyPizzaApp.R
import by.akelian.dp.anyPizzaApp.data.foodData.SimilarFoodData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.with_description_menu_item.view.*
import kotlinx.android.synthetic.main.without_description_menu_item.view.*


class MenuAdapter(
    private val list: ArrayList<SimilarFoodData>,
    private val item: Int
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(item, parent, false)
        return MenuViewHolder(itemView)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val myView = holder.itemView
        if (item == R.layout.with_description_menu_item) {
            Picasso.get().load(list[position].image).into(myView.withDescriptionItemImage)
            myView.withDescriptionItemName.text = list[position].name
            myView.withDescriptionItemPrice.text = list[position].price.toString()
            myView.withDescriptionItemDescription.text = list[position].description
        } else {
            Picasso.get().load(list[position].image).into(myView.withoutDescriptionItemImage)
            myView.withoutDescriptionItemName.text = list[position].name
            myView.withoutDescriptionItemPrice.text = list[position].price.toString()
        }
    }
}