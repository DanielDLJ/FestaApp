package br.com.danieldlj.festaapp.ui.expenses.Drink

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.danieldlj.festaapp.MainActivity
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.api.ApiClient
import br.com.danieldlj.festaapp.data.DrinkExpensesDataBase
import br.com.danieldlj.festaapp.domain.DrinkExpenses
import br.com.danieldlj.festaapp.ui.expenses.PriceAlterInterface
import kotlinx.android.synthetic.main.fragment_expenses_drink.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DrinkExpensesFragment : Fragment(), PriceAlterInterface {

    fun title() = R.string.drink_expenses_fragment_tab_list

    val drinkExpenses = ArrayList<DrinkExpenses>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater
            .inflate(R.layout.fragment_expenses_drink, container, false)
    }

    override fun onActivityCreated( savedInstanceState: Bundle? ) {
        super.onActivityCreated( savedInstanceState )

        fab_add_drink.setOnClickListener{
            addDrinkExpenses()
        }

        initItems()
    }

    private fun initItems(){

        val adapter = context?.let { DrinkExpensesAdapter(this, DrinkExpensesDataBase.getItems(), this) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        //getData()
    }

    override fun alterPrice(total: Float) {
    }

    fun getData() {
        println("list")
        val call: Call<List<DrinkExpenses>> = ApiClient.getClient.getAllDrinkExpenses((activity as MainActivity).user.party)
        call.enqueue(object : Callback<List<DrinkExpenses>> {
            override fun onResponse(call: Call<List<DrinkExpenses>>?, response: Response<List<DrinkExpenses>>?) {
                drinkExpenses.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<DrinkExpenses>>?, t: Throwable?) {
                println("onFailure")
            }
        })
    }


    private fun addDrinkExpenses(){

        val updateFrag = FormNewDrinkExpensesFragment()

        val transaction = this
            .fragmentManager!!
            .beginTransaction()

        /*
         * O acesso ao FrameLayout root volta a ocorrer para que
         * seja possível o replace de fragmentos dentro da mesma
         * janela
         * */
        transaction.replace(R.id.fl_root_drink, updateFrag)

        /*
         * Com o setTransition() e addToBackStack() nós estamos,
         * respectivamente permitindo uma transição entre fragmentos
         * e os colocando em uma pilha de fragmentos para que seja
         * possível voltar ao fragmento anteriormente apresentado
         * na mesma janela.
         * */
        transaction
            .setTransition( FragmentTransaction.TRANSIT_FRAGMENT_OPEN )
            .addToBackStack( null )
            .commit()
    }
}