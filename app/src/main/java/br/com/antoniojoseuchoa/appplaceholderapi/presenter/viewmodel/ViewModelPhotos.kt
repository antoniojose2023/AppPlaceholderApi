package br.com.antoniojoseuchoa.appplaceholderapi.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.antoniojoseuchoa.appplaceholderapi.data.model.Foto
import br.com.antoniojoseuchoa.appplaceholderapi.data.repository.RepositoryFotos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelPhotos @Inject constructor(private val repositoryFotos: RepositoryFotos): ViewModel() {

    private var _fotos = MutableLiveData<List<Foto>>()
    val fotos: LiveData<List<Foto>> = _fotos

//    init {
//        getAllPhotos()
//    }

    fun getAllPhotos(){
        viewModelScope.launch {
            val photos = repositoryFotos.getFotos()
            _fotos.postValue( photos )
        }
    }

}
