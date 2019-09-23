package br.com.danieldlj.festaapp.ui.settings

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import br.com.danieldlj.festaapp.R
import com.makeramen.roundedimageview.RoundedImageView
import com.nguyenhoanglam.imagepicker.model.Config
import com.nguyenhoanglam.imagepicker.model.Config.RC_PICK_IMAGES
import com.nguyenhoanglam.imagepicker.model.Image
import com.nguyenhoanglam.imagepicker.ui.imagepicker.ImagePicker

class SettingsFragment : Fragment() {

    private lateinit var settingsViewModel: SettingsViewModel
    private lateinit var riv_profile: RoundedImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        settingsViewModel =
            ViewModelProviders.of(this).get(SettingsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_settings, container, false)
        val context: Context = context!!

        riv_profile = root.findViewById(R.id.riv_profile)
        riv_profile.setOnClickListener(View.OnClickListener {
            callGallery(context);
        })
        return root
    }

    fun callGallery(context: Context){

        val colorPrimary = "#" + Integer.toHexString(ContextCompat.getColor(context, R.color.colorPrimary))
        val colorPrimaryDark = "#" + Integer.toHexString(ContextCompat.getColor(context, R.color.colorPrimaryDark))
        val colorText = "#" + Integer.toHexString(ContextCompat.getColor(context, R.color.colorText))
        val colorWhite = "#" + Integer.toHexString(ContextCompat.getColor(context, R.color.colorWhite))

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
            .setRequestCode(RC_PICK_IMAGES)
            .setKeepScreenOn( true ) //Mantém a tela acionada enquanto a galeria estiver aberta.
            .start()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent? ) {

        if( requestCode == RC_PICK_IMAGES && resultCode == Activity.RESULT_OK && data != null ){

            val images = data.getParcelableArrayListExtra<Image>(Config.EXTRA_IMAGES)

            if( images.isNotEmpty() ){
                riv_profile.setImageURI(Uri.parse( images.first().path ))
            }
        }

        /*
         * A invocação a super.onActivityResult() tem que
         * vir após a verificação / obtenção da imagem.
         * */
        super.onActivityResult( requestCode, resultCode, data )
    }
}