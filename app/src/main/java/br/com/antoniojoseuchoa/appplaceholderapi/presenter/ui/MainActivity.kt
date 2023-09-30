package br.com.antoniojoseuchoa.appplaceholderapi.presenter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.antoniojoseuchoa.appplaceholderapi.databinding.ActivityMainBinding
import br.com.antoniojoseuchoa.appplaceholderapi.presenter.AdapterPhotos
import br.com.antoniojoseuchoa.appplaceholderapi.presenter.viewmodel.ViewModelPhotos
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModelPhotos: ViewModelPhotos by viewModels()
   // private lateinit var viewModelPhotos: ViewModelPhotos
    private val adapterPhotos by lazy { AdapterPhotos()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //viewModelPhotos = ViewModelProvider(this)[ViewModelPhotos::class.java]
        configRecyclerView()

    }

    override fun onStart() {
        viewModelPhotos.getAllPhotos()
        configRecyclerView()
        super.onStart()
    }


    fun configRecyclerView(){
        viewModelPhotos.fotos.observe(this){fotos ->
            if(fotos != null){
                 adapterPhotos.setListPhotos( fotos )
                 binding.apply {
                     rvPhotos.adapter = adapterPhotos
                     rvPhotos.layoutManager = LinearLayoutManager(applicationContext)
                 }
            }

        }

    }
}