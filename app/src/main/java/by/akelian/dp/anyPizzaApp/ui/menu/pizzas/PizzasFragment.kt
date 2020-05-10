package by.akelian.dp.anyPizzaApp.ui.menu.pizzas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.akelian.dp.anyPizzaApp.R
import by.akelian.dp.anyPizzaApp.retrofit.pizza.PizzaAPIFactory
import by.akelian.dp.anyPizzaApp.ui.menu.MenuAdapter
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_pizzas_menu.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PizzasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_pizzas_menu, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            val response = PizzaAPIFactory.getRetrofitPizza().getAllPizzza().await()
            val pizzas = response.body()
            if (pizzas !== null) {
                withContext(Dispatchers.Main) {

                    pizzasMenuRecycler.adapter = MenuAdapter(
                        pizzas,
                        R.layout.with_description_menu_item,
                        this@PizzasFragment,
                        menuFrameLayout
                    )
                    pizzasMenuRecycler.layoutManager = LinearLayoutManager(this@PizzasFragment)
                }
            }
        }

    }
}
