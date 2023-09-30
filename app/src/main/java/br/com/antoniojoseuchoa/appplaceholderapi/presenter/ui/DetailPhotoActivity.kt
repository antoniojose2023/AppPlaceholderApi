package br.com.antoniojoseuchoa.appplaceholderapi.presenter.ui

import android.os.Build
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Contacts.Photo
import androidx.annotation.RequiresApi
import br.com.antoniojoseuchoa.appplaceholderapi.R
import br.com.antoniojoseuchoa.appplaceholderapi.data.model.Foto
import br.com.antoniojoseuchoa.appplaceholderapi.databinding.ActivityDetailPhotoBinding
import com.squareup.picasso.Picasso

class DetailPhotoActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDetailPhotoBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)




    }

    @RequiresApi(VERSION_CODES.TIRAMISU)
    override fun onStart() {
        popularDadosTela()
        super.onStart()
    }


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    fun popularDadosTela(){

        val bundle = intent.extras

        if(bundle != null){
            val foto = if(VERSION.SDK_INT >= VERSION_CODES.TIRAMISU){
                bundle?.getParcelable("photo", Foto::class.java)
            }else{
                bundle.getParcelable("photo")
            }

            binding.apply {
                Picasso.get().load(foto?.url).into( ivPhoto )
                tvTitle.text = foto?.title
            }
        }

    }
}