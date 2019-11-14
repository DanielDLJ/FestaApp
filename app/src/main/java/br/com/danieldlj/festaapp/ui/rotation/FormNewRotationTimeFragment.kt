package br.com.danieldlj.festaapp.ui.rotation

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.danieldlj.festaapp.FormFragment
import br.com.danieldlj.festaapp.MainActivity
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.domain.Rotation
import kotlinx.android.synthetic.main.fragment_new_rotation_time.*
import kotlinx.android.synthetic.main.fragment_rotation.*
import java.text.SimpleDateFormat
import java.util.*

class FormNewRotationTimeFragment : FormFragment() {


    override fun getLayoutResourceID() = R.layout.fragment_new_rotation_time

    override fun backEndFakeDelay() {
        backEndFakeDelay(false, getString( R.string.invalid ))
    }

    override fun blockFields(status: Boolean) {
        txt_hour.isEnabled = !status
    }

    override fun isMainButtonSending( status: Boolean ){
        bt_nu_rotation_time.text =
            if( status )
                getString( R.string.update_rotation_time_going )
            else
                getString( R.string.update_rotation_time )
    }

    @SuppressLint("SimpleDateFormat")
    override fun onActivityCreated(savedInstanceState: Bundle? ){
        super.onActivityCreated( savedInstanceState )

        updateFlFormToFullFreeScreen()

        txt_hour.setOnClickListener{
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                txt_hour.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog((activity as MainActivity), timeSetListener, cal.get(Calendar.HOUR_OF_DAY), 0, true).show()
        }

        bt_nu_rotation_time.setOnClickListener{
            mainAction()
        }

        initItems()
    }
    private fun initItems(){
        val rotation = arguments!!.getParcelable<Rotation>(Rotation.KEY)
        val position = arguments!!.getInt(Rotation.POSITION)
        txt_hour.text = rotation?.rotationList?.get(position)?.timeStart
    }

}