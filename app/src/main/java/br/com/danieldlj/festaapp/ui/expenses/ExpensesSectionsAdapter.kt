package br.com.danieldlj.festaapp.ui.expenses

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.ui.expenses.Drink.DrinkExpensesFragment
import br.com.danieldlj.festaapp.ui.expenses.Fixed.FixedExpensesFragment


/**
 * Um FragmentPagerAdapter que retorna um fragmento correspondendo
 * a uma das sections/tabs/pages.
 *
 * Mesmo que o método getItem() indique que mais de uma instância
 * do mesmo fragmento será criada, na verdade objetos
 * FragmentPagerAdapter mantêm os fragmentos em memória para que
 * eles possam ser utilizados novamente, isso enquanto houver
 * caminho de volta a eles (transição entre Tabs, por exemplo).
 */
class ExpensesSectionsAdapter(
    private val context: Context,
    fm: FragmentManager,
    private val drinkExpensesFragment: DrinkExpensesFragment,
    private val fixedExpensesFragment: FixedExpensesFragment
) : FragmentPagerAdapter( fm ) {

    companion object{
        const val TOTAL_PAGES = 2
        const val FIRST_PAGE_POS = 0
        const val SECOND_PAGE_POS = 1
    }

    /*
     * getItem() é invocado para devolver uma instância do
     * fragmento correspondendo a posição (seção/página)
     * informada.
     * */
    override fun getItem( position: Int ): Fragment = when( position ){
        FIRST_PAGE_POS -> drinkExpensesFragment
        else -> fixedExpensesFragment
    }

    override fun getPageTitle( position: Int )
            = context.getString(
        when( position ){
            FIRST_PAGE_POS -> R.string.drink_expenses_fragment_tab_list
            else -> R.string.fixed_expenses_fragment_tab_list
        }
    )

    override fun getCount() =
        TOTAL_PAGES
}