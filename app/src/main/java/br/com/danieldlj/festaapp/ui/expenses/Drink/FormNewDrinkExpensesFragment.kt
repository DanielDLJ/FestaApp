package br.com.danieldlj.festaapp.ui.expenses.Drink

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import br.com.danieldlj.festaapp.FormFragment
import br.com.danieldlj.festaapp.MainActivity
import br.com.danieldlj.festaapp.R
import com.blankj.utilcode.util.ColorUtils
import com.nguyenhoanglam.imagepicker.model.Config
import com.nguyenhoanglam.imagepicker.model.Image
import com.nguyenhoanglam.imagepicker.ui.imagepicker.ImagePicker
import kotlinx.android.synthetic.main.fragment_new_expenses_drink.*

open class FormNewDrinkExpensesFragment : FormFragment() {


    override fun getLayoutResourceID() = R.layout.fragment_new_expenses_drink

    override fun backEndFakeDelay() {
        backEndFakeDelay(false, getString( R.string.invalid ))
    }

    override fun blockFields(status: Boolean) {
        riv_image.isEnabled = !status
        et_drink_name.isEnabled = !status
        et_drink_qtdByPerson.isEnabled = !status
        txt_drink_qtdProvided.isEnabled = !status
        et_drink_priceLiter.isEnabled = !status
        txt_drink_total.isEnabled = !status
        et_drink_provider.isEnabled = !status
        et_drink_cups.isEnabled = !status
        txt_drink_allBar.isEnabled = !status
        bt_cancel_drink.isEnabled = !status
        bt_nu_drink.isEnabled = !status
    }

    override fun isMainButtonSending( status: Boolean ){
        bt_nu_drink.text =
            if( status )
                getString( R.string.update_drink_going )
            else
                getString( R.string.update_drink )
    }

    override fun onActivityCreated(savedInstanceState: Bundle? ){
        super.onActivityCreated( savedInstanceState )

        updateFlFormToFullFreeScreen()


        bt_nu_drink.setOnClickListener{
            mainAction()
        }
        bt_cancel_drink.setOnClickListener(View.OnClickListener {
                (activity as MainActivity).onBackPressed()
            }
        )

        riv_image.setOnClickListener{
            callGallery()
        }

        initItems()
    }
    private fun initItems(){
    }


    fun callGallery(){
        val colorPrimary = ColorUtils.int2ArgbString(ColorUtils.getColor(R.color.colorPrimary))
        val colorPrimaryDark = ColorUtils.int2ArgbString(ColorUtils.getColor(R.color.colorPrimaryDark))
        val colorText = ColorUtils.int2ArgbString(ColorUtils.getColor(R.color.colorText))
        val colorWhite = ColorUtils.int2ArgbString(Color.WHITE)
        Log.e("Teste","colorPrimary = "+colorPrimary)
        Log.e("Teste","colorPrimaryDark = "+colorPrimaryDark)
        Log.e("Teste","colorText = "+colorText)
        Log.e("Teste","colorWhite = "+colorWhite)
        ImagePicker
            .with( this ) //Inicializa a ImagePicker API com um context (Activity ou Fragment)
            .setToolbarColor( colorPrimary )
            .setStatusBarColor( colorPrimaryDark )
            .setToolbarTextColor( colorText )
            .setToolbarIconColor( colorText )
            .setProgressBarColor( colorPrimaryDark )
            .setBackgroundColor( colorWhite )
            .setMultipleMode( false )
            .setFolderMode( true )
            .setShowCamera( true )
            .setFolderTitle( getString(R.string.imagepicker_gallery_activity) ) //Nome da tela de galeria da ImagePicker API (funciona quando FolderMode = true).
            .setLimitMessage( getString(R.string.imagepicker_selection_limit) )
            .setSavePath( getString(R.string.imagepicker_cam_photos_activity) ) //Folder das imagens de câmera, tiradas a partir da ImagePicker API.
            .setRequestCode(Config.RC_PICK_IMAGES)
            .setKeepScreenOn( true ) //Mantém a tela acionada enquanto a galeria estiver aberta.
            .start()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent? ) {

        if( requestCode == Config.RC_PICK_IMAGES && resultCode == Activity.RESULT_OK && data != null ){

            val images = data.getParcelableArrayListExtra<Image>(Config.EXTRA_IMAGES)

            if( images.isNotEmpty() ){
                riv_image.setImageURI(Uri.parse( images.first().path ))
            }
        }

        /*
         * A invocação a super.onActivityResult() tem que
         * vir após a verificação / obtenção da imagem.
         * */
        super.onActivityResult( requestCode, resultCode, data )
    }

}