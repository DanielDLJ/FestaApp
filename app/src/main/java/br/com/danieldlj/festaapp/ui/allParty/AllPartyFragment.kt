package br.com.danieldlj.festaapp.ui.allParty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.danieldlj.festaapp.R

class AllPartyFragment : Fragment() {

    private lateinit var allPartyViewModel: AllPartyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        allPartyViewModel =
            ViewModelProviders.of(this).get(AllPartyViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_all_party, container, false)
        val textView: TextView = root.findViewById(R.id.text_all_party)
        allPartyViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}