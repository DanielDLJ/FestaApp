package br.com.danieldlj.festaapp.ui.expenses.Fixed

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.data.FixedExpensesDataBase
import br.com.danieldlj.festaapp.ui.expenses.PriceAlterInterface
import kotlinx.android.synthetic.main.fragment_expenses_fixed.*
import kotlinx.android.synthetic.main.fragment_list_rep.recyclerView


class FixedExpensesFragment : Fragment(), PriceAlterInterface {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater
            .inflate(R.layout.fragment_expenses_fixed, container, false)
    }

    override fun onActivityCreated( savedInstanceState: Bundle? ) {
        super.onActivityCreated( savedInstanceState )

        initItems()
    }

    private fun initItems(){

        val adapter = context?.let {
            FixedExpensesAdapter(
                it,
                FixedExpensesDataBase.getItems(),
                this
            )
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        val string:String = R.string.total.toString() + 0
        tv_total_price.text = string
    }

    override fun alterPrice(total: Float) {
        var string = getString(R.string.total) + " "
        if(total < 0){
            string += total
            tv_total_price.text = string
            tv_total_price.setTextColor(Color.parseColor("#FF0000"))
        }else{
            string += total
            tv_total_price.text = string
        }


    }
}

