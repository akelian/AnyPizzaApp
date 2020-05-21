package by.akelian.dp.anyPizzaApp.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.akelian.dp.anyPizzaApp.R
import by.akelian.dp.anyPizzaApp.ui.menu.desserts.DessertsFragment
import by.akelian.dp.anyPizzaApp.ui.menu.drinks.DrinksFragment
import by.akelian.dp.anyPizzaApp.ui.menu.pizzas.PizzasFragment
import by.akelian.dp.anyPizzaApp.ui.menu.snacks.SnacksFragment
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment(), View.OnClickListener {
    private val pizzasFragment = PizzasFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.beginTransaction().replace(R.id.menuFrameLayout, pizzasFragment)
            .commit()

        pizzaMenuButton.setOnClickListener(this)
        snacksMenuButton.setOnClickListener(this)
        dessertsMenuButton.setOnClickListener(this)
        drinksMenuButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            pizzaMenuButton.id -> childFragmentManager.beginTransaction()
                .replace(R.id.menuFrameLayout, pizzasFragment)
                .commit()
            snacksMenuButton.id -> childFragmentManager.beginTransaction()
                .replace(R.id.menuFrameLayout, SnacksFragment())
                .commit()
            dessertsMenuButton.id -> childFragmentManager.beginTransaction()
                .replace(R.id.menuFrameLayout, DessertsFragment())
                .commit()
            drinksMenuButton.id -> childFragmentManager.beginTransaction()
                .replace(R.id.menuFrameLayout, DrinksFragment())
                .commit()
        }
    }
}
