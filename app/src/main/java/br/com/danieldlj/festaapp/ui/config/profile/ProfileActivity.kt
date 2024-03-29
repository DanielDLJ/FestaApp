package br.com.danieldlj.festaapp.ui.config.profile

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import br.com.danieldlj.festaapp.FormActivity
import br.com.danieldlj.festaapp.R
import br.com.danieldlj.festaapp.domain.User
import br.com.danieldlj.festaapp.uitl.validate
import com.blankj.utilcode.util.ColorUtils
import com.blankj.utilcode.util.KeyboardUtils
import com.blankj.utilcode.util.ScreenUtils
import com.nguyenhoanglam.imagepicker.model.Config
import com.nguyenhoanglam.imagepicker.model.Image
import com.nguyenhoanglam.imagepicker.ui.imagepicker.ImagePicker
import kotlinx.android.synthetic.main.content_config_profile.*


class ProfileActivity : FormActivity(), KeyboardUtils.OnSoftInputChangedListener {

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )

        et_name.validate(
            {
                it.length > 1
            },
            getString( R.string.invalid_name )
        )
        et_name.setOnEditorActionListener( this )

        /*
         * Name é um dos dados de banco de dados, e campo de
         * formulário, que nunca poderá estar vazio.
         * */
        val user = intent.getParcelableExtra<User>( User.KEY )
        et_name.setText( user.name )
        riv_profile.setImageResource(user?.image ?: R.drawable.profile_hint)

        KeyboardUtils.registerSoftInputChangedListener(this, this)
    }

    override fun onDestroy() {
        KeyboardUtils.unregisterSoftInputChangedListener( this )
        super.onDestroy()
    }

    override fun getLayoutResourceID() = R.layout.content_config_profile

    override fun backEndFakeDelay(){
        backEndFakeDelay(false, getString( R.string.invalid_config_profile ))
    }

    override fun blockFields( status: Boolean ){
        riv_profile.isEnabled = !status
        et_name.isEnabled = !status
        bt_send_profile.isEnabled = !status
    }

    override fun isMainButtonSending( status: Boolean ){
        bt_send_profile.text =
            if( status )
                getString( R.string.config_profile_going )
            else
                getString( R.string.config_profile )
    }

    override fun onSoftInputChanged( height: Int ) {
        if( isAbleToCallChangeTargetViewConstraints() ){
            changeTargetViewConstraints(
                KeyboardUtils.isSoftInputVisible( this )
            )
        }
    }

    private fun isAbleToCallChangeTargetViewConstraints() = true

    private fun changeTargetViewConstraints(isKeyBoardOpened: Boolean){

        val photoProfileId = riv_profile.id
        val parent = riv_profile.parent as ConstraintLayout
        val constraintSet = ConstraintSet()
        val size = (108 * ScreenUtils.getScreenDensity()).toInt()

        /*
         * Definindo a largura e a altura da View em
         * mudança de constraints, caso contrário ela
         * fica com largura e altura em 0dp.
         * */
        constraintSet.constrainWidth(photoProfileId, size)
        constraintSet.constrainHeight(photoProfileId, size)

        /*
         * Centralizando a View horizontalmente no
         * ConstraintLayout.
         * */
        constraintSet.centerHorizontally(photoProfileId, ConstraintLayout.LayoutParams.PARENT_ID)

        if( isConstraintToSiblingView( isKeyBoardOpened ) ){
            setConstraintsRelativeToSiblingView( constraintSet, photoProfileId )
        }
        else{
            constraintSet.connect(photoProfileId, ConstraintLayout.LayoutParams.TOP, ConstraintLayout.LayoutParams.PARENT_ID, ConstraintLayout.LayoutParams.TOP)
        }

        constraintSet.applyTo( parent )
    }

    private fun isConstraintToSiblingView(isKeyBoardOpened: Boolean): Boolean {

        return isKeyBoardOpened || ScreenUtils.isLandscape()
    }

    private fun setConstraintsRelativeToSiblingView(constraintSet: ConstraintSet, targetViewId: Int) {
        constraintSet.connect(targetViewId, ConstraintLayout.LayoutParams.BOTTOM, tv_name.id, ConstraintLayout.LayoutParams.TOP,
            (30 * ScreenUtils.getScreenDensity()).toInt())
    }

    fun callGallery( view: View){
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