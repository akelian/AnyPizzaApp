package by.akelian.dp.anyPizzaApp.ui.menu.drinks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.akelian.dp.anyPizzaApp.R
import by.akelian.dp.anyPizzaApp.data.foodData.SimilarFoodData
import by.akelian.dp.anyPizzaApp.retrofit.drinks.DrinksAPIFactory
import by.akelian.dp.anyPizzaApp.ui.menu.MenuAdapter
import kotlinx.android.synthetic.main.fragment_drinks_menu.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DrinksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_drinks_menu, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            val response = DrinksAPIFactory.getRetrofitDrinks().getAllDrinks().await()
            if (response.isSuccessful) {
                val desserts = response.body()
                if (desserts !== null) {
                    withContext(Dispatchers.Main) {
                        drinksMenuRecycler.adapter = context?.applicationContext?.let {
                            MenuAdapter(
                                desserts as ArrayList<SimilarFoodData>,
                                R.layout.without_description_menu_item
                            )
                        }
                    }
                }
            }
        }
        drinksMenuRecycler.layoutManager = LinearLayoutManager(context)
    }
}
