package br.com.danieldlj.festaapp.ui.allParty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.data.AllShoesDataBase
import kotlinx.android.synthetic.main.fragment_all_party.*

class AllPartyFragment : Fragment() {

    private lateinit var allPartyViewModel: AllPartyViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        allPartyViewModel = ViewModelProviders.of(this).get(AllPartyViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_all_party, container, false)
        //val textView: TextView = root.findViewById(R.id.text_all_party)
        val recyclerView: RecyclerView = root.findViewById(R.id.rv_parties)
        allPartyViewModel.text.observe(this, Observer {
            //textView.text = it
        })


        recyclerView.setHasFixedSize( false )

        val layoutManager = GridLayoutManager(
            activity,
            1,
            RecyclerView.VERTICAL,
            false
        )
        recyclerView.layoutManager = layoutManager

        val adapter = AllPartyListAdapter( AllShoesDataBase.getItems() )
        recyclerView.adapter = adapter

        return root
    }

}