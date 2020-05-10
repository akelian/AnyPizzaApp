package by.akelian.dp.anyPizzaApp.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.akelian.dp.anyPizzaApp.R

class MenuFragment : Fragment() {

//    private lateinit var menuViewModel: MenuViewModel
//
//    override fun onCreateView(
//            inflater: LayoutInflater,
//            container: ViewGroup?,
//            savedInstanceState: Bundle?
//    ): View? {
//
//        menuViewModel =
//                ViewModelProviders.of(this).get(MenuViewModel::class.java)
//        val root = inflater.inflate(R.layout.fragment_menu, container, false)
//        val textView: TextView = root.findViewById(R.id.text_menu)
//        menuViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
//        return root
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }


}
