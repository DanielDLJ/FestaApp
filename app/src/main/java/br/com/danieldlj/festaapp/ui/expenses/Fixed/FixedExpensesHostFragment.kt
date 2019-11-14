package br.com.danieldlj.festaapp.ui.expenses.Fixed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.danieldlj.festaapp.FormFragment
import br.com.danieldlj.festaapp.MainActivity
import br.com.danieldlj.festaapp.R


/*
 * Fragmento com responsabilidade de ser o fragmento
 * host de mais de um fragmento e assim permitir a
 * fácil alternância de fragmentos
 * */
class FixedExpensesHostFragment : FormFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        // É preciso inflar o layout que vai conter os fragmentos.
        val view = inflater.inflate(R.layout.fragment_expenses_fixed_host, container, false)

        /*
         * Somente na primeira abertura é que a regra de
         * fragmento inicial, do bloco condicional a seguir,
         * deve ser seguida.
         * */
        if( savedInstanceState == null ){
            val transaction = activity!!
                .supportFragmentManager!!
                .beginTransaction()

            /*
             * Então, aqui no fragmento root (container),
             * iniciamos com o primeiro fragmento via
             * FragmentTransaction e sem trabalho com pilha
             * de fragmentos.
             * */
            transaction
                .replace(R.id.fl_root_fixed, FixedExpensesFragment())
                .commit()
        }
        return view
    }

    override fun getLayoutResourceID() = 0

    override fun backEndFakeDelay() {}

    override fun blockFields(status: Boolean) {}

    override fun isMainButtonSending(status: Boolean) {}

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).updateToolbarTitleInFragment( R.string.title_frag_expenses_fragment )
    }
}