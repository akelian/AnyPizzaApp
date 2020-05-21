package by.akelian.dp.anyPizzaApp.ui.menu.snacks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.akelian.dp.anyPizzaApp.R
import by.akelian.dp.anyPizzaApp.data.foodData.SimilarFoodData
import by.akelian.dp.anyPizzaApp.retrofit.snacks.SnackAPIFactory
import by.akelian.dp.anyPizzaApp.ui.menu.MenuAdapter
import kotlinx.android.synthetic.main.fragment_snacks_menu.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SnacksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_snacks_menu, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            val response = SnackAPIFactory.getRetrofitSnack().getAllSnacks().await()
            if (response.isSuccessful) {
                val snacks = response.body()
                if (snacks !== null) {
                    withContext(Dispatchers.Main) {

                        snacksMenuRecycler.adapter = context?.applicationContext?.let {
                            MenuAdapter(
                                snacks as ArrayList<SimilarFoodData>,
                                R.layout.with_description_menu_item
                            )
                        }
                    }
                }
            }
        }
        snacksMenuRecycler.layoutManager = LinearLayoutManager(context)
    }
}
