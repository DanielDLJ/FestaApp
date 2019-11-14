package br.com.danieldlj.festaapp.ui.expenses.Drink

import android.os.Bundle
import android.view.View
import br.com.danieldlj.festaapp.MainActivity
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.domain.DrinkExpenses
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_new_expenses_drink.*

class FormUpdateDrinkExpensesFragment : FormNewDrinkExpensesFragment() {


    override fun getLayoutResourceID() = R.layout.fragment_update_expenses_drink

    override fun backEndFakeDelay() {
        backEndFakeDelay(false, getString( R.string.invalid ))
    }

    override fun isMainButtonSending( status: Boolean ){
        bt_nu_drink.text =
            if( status )
                getString( R.string.update_drink_going )
            else
                getString( R.string.update_drink )
    }

    override fun onActivityCreated(savedInstanceState: Bundle? ){
        super.onActivityCreated( savedInstanceState )

        updateFlFormToFullFreeScreen()
        bt_nu_drink.text = getString( R.string.update_drink )

        bt_nu_drink.setOnClickListener{
            mainAction()
        }
        bt_cancel_drink.setOnClickListener(View.OnClickListener {
            (activity as MainActivity).onBackPressed()
            }
        )


        fillForm()
    }
    private fun fillForm(){
        val drink = arguments!!.getParcelable<DrinkExpenses>(DrinkExpenses.KEY)

        Picasso.get()
            .load( drink?.image )
            .into( riv_image )
        et_drink_name.setText( drink.item )
        et_drink_qtdByPerson.setText(drink.qtdByPerson.toString())
        txt_drink_qtdProvided.text = ( drink.qtdProvided.toString() )
        et_drink_priceLiter.setText( drink.priceLiter.toString())
        txt_drink_total.text = ( drink.total.toString() )
        et_drink_provider.setText( drink.provider)
        et_drink_cups.setText( drink.cups.toString() )
        txt_drink_allBar.text = ( drink.allBar.toString() )


    }


}
