package by.akelian.dp.anyPizzaApp.ui.menu.desserts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.akelian.dp.anyPizzaApp.R
import by.akelian.dp.anyPizzaApp.data.foodData.SimilarFoodData
import by.akelian.dp.anyPizzaApp.retrofit.dessert.DessertsAPIFactory
import by.akelian.dp.anyPizzaApp.ui.menu.MenuAdapter
import kotlinx.android.synthetic.main.fragment_desserts_menu.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DessertsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_desserts_menu, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            val response = DessertsAPIFactory.getRetrofitDesserts().getAllDesserts().await()
            if (response.isSuccessful) {
                val desserts = response.body()
                if (desserts !== null) {
                    withContext(Dispatchers.Main) {
                        dessertsMenuRecycler.adapter = context?.applicationContext?.let {
                            MenuAdapter(
                                desserts as ArrayList<SimilarFoodData>,
                                R.layout.with_description_menu_item
                            )
                        }
                    }
                }
            }
        }
        dessertsMenuRecycler.layoutManager = LinearLayoutManager(context)
    }
}
