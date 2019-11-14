package br.com.danieldlj.festaapp.ui.expenses.Fixed

import android.os.Bundle
import android.view.View
import br.com.danieldlj.festaapp.MainActivity
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.domain.FixedExpenses
import kotlinx.android.synthetic.main.fragment_new_expenses_fixed.*

class FormUpdateFixedExpensesFragment : FormNewFixedExpensesFragment() {


    override fun getLayoutResourceID() = R.layout.fragment_update_expenses_fixed

    override fun backEndFakeDelay() {
        backEndFakeDelay(false, getString( R.string.invalid ))
    }

    override fun isMainButtonSending( status: Boolean ){
        bt_nu_fixed.text =
            if( status )
                getString( R.string.update_fixed_going )
            else
                getString( R.string.update_fixed )
    }

    override fun onActivityCreated(savedInstanceState: Bundle? ){
        super.onActivityCreated( savedInstanceState )

        updateFlFormToFullFreeScreen()
        bt_nu_fixed.text = getString( R.string.update_fixed )

        bt_nu_fixed.setOnClickListener{
            mainAction()
        }
        bt_cancel_fixed.setOnClickListener(View.OnClickListener {
            (activity as MainActivity).onBackPressed()
            }
        )


        fillForm()
    }
    private fun fillForm(){
        val fixed = arguments!!.getParcelable<FixedExpenses>(FixedExpenses.KEY)

        et_drink_name.setText( fixed.item )
        et_fixed_price.setText(fixed.price.toString())


    }


}
