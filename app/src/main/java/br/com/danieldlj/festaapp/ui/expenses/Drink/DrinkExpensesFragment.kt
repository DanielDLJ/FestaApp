package br.com.danieldlj.festaapp.ui.expenses.Drink

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.data.DrinkExpensesDataBase
import br.com.danieldlj.festaapp.data.ListRepDataBase
import br.com.danieldlj.festaapp.ui.expenses.PriceAlterInterface
import br.com.danieldlj.festaapp.ui.list_rep.RepublicAdapter
import kotlinx.android.synthetic.main.fragment_list_rep.*


class DrinkExpensesFragment : Fragment(), PriceAlterInterface {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater
            .inflate(R.layout.fragment_expenses_drink, container, false)
    }

    override fun onActivityCreated( savedInstanceState: Bundle? ) {
        super.onActivityCreated( savedInstanceState )

        initItems()
    }

    private fun initItems(){

        val adapter = context?.let { DrinkExpensesAdapter(it, DrinkExpensesDataBase.getItems(), this) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun alterPrice(total: Float) {
    }
}