package br.com.danieldlj.festaapp.ui.list_rep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.danieldlj.festaapp.R


class ListRepFragment : Fragment() {

    private lateinit var listRepViewModel: ListRepViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        listRepViewModel = ViewModelProviders.of(this).get(ListRepViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_list_rep, container, false)
        val textView: TextView = root.findViewById(R.id.text_list_rep)
        listRepViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}