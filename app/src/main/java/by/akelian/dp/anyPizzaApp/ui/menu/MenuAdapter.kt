package by.akelian.dp.anyPizzaApp.ui.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import by.akelian.dp.anyPizzaApp.data.pizza.PizzaItem
import by.akelian.dp.anyPizzaApp.ui.menu.pizzas.PizzasFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.with_description_menu_item.view.*


class MenuAdapter(
    private val list: List<PizzaItem>,
    private val item: Int,
    val context: PizzasFragment,
    val supportFragmentManager: FragmentManager,
    val fragmentView: FrameLayout
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(item, parent, false)
        return MenuViewHolder(itemView)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val myView = holder.itemView

        Picasso.get().load(list[position].image).into(myView.withDescriptionItemImage)
        myView.withDescriptionItemName.text = list[position].name
        myView.withDescriptionItemPrice.text = list[position].price.toString()
        myView.withDescriptionItemDescription.text = list[position].description

        supportFragmentManager.beginTransaction().replace(fragmentView.id, PizzasFragment())
            .commit()
    }
}