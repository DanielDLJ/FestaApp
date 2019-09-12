package br.com.danieldlj.festaapp.ui.invite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.danieldlj.festaapp.R

class InviteFragment : Fragment() {

    private lateinit var inviteViewModel: InviteViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inviteViewModel =
            ViewModelProviders.of(this).get(InviteViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_invite, container, false)
        val textView: TextView = root.findViewById(R.id.text_invite)
        inviteViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}