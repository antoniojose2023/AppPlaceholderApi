package br.com.antoniojoseuchoa.appplaceholderapi.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.antoniojoseuchoa.appplaceholderapi.data.model.Foto
import br.com.antoniojoseuchoa.appplaceholderapi.domain.models.FotoDomain
import br.com.antoniojoseuchoa.appplaceholderapi.domain.repository.RepositoryFotos
import br.com.antoniojoseuchoa.appplaceholderapi.domain.usecase.UseCasePhoto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelPhotos @Inject constructor(private val useCasePhoto: UseCasePhoto): ViewModel() {

    private var _fotos = MutableLiveData<List<FotoDomain>>()
    val fotos: LiveData<List<FotoDomain>> = _fotos

//    init {
//        getAllPhotos()
//    }

    fun getAllPhotos(){
        viewModelScope.launch {
            val photos = useCasePhoto()
            _fotos.postValue( photos )
        }
    }

}
