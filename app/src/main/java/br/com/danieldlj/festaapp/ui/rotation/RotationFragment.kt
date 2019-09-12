package br.com.danieldlj.festaapp.ui.rotation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.danieldlj.festaapp.R

class RotationFragment : Fragment() {

    private lateinit var rotationViewModel: RotationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rotationViewModel =
            ViewModelProviders.of(this).get(RotationViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_rotation, container, false)
        val textView: TextView = root.findViewById(R.id.text_rotation)
        rotationViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}