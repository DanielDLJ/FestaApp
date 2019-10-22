package br.com.danieldlj.festaapp.ui.list_rep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.danieldlj.festaapp.MainActivity
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.data.ListRepDataBase
import kotlinx.android.synthetic.main.fragment_list_rep.*


class ListRepFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater
            .inflate(R.layout.fragment_list_rep, container, false)
    }

    override fun onActivityCreated( savedInstanceState: Bundle? ) {
        super.onActivityCreated( savedInstanceState )

        initItems()
    }

    private fun initItems(){

        val adapter = context?.let { RepublicAdapter(it, ListRepDataBase.getItems()) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).updateToolbarTitleInFragment( R.string.title_frag_list_rep )
    }
}