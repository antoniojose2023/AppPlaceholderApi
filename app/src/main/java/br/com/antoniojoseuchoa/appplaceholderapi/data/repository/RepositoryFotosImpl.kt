package br.com.antoniojoseuchoa.appplaceholderapi.data.repository

import br.com.antoniojoseuchoa.appplaceholderapi.data.api.ApiPlaceHolder
import br.com.antoniojoseuchoa.appplaceholderapi.data.model.Foto
import br.com.antoniojoseuchoa.appplaceholderapi.data.model.toFotoDomain
import br.com.antoniojoseuchoa.appplaceholderapi.domain.models.FotoDomain
import br.com.antoniojoseuchoa.appplaceholderapi.domain.repository.RepositoryFotos
import retrofit2.Response
import javax.inject.Inject

class RepositoryFotosImpl @Inject constructor(private val apiPlaceHolder: ApiPlaceHolder):
    RepositoryFotos {
    override suspend fun getFotos(): List<FotoDomain> {
         var response: Response<List<Foto>>? = null

         response = apiPlaceHolder.getAllPhotos()
         if(response.isSuccessful){
             val list = response.body()
             if(list != null){

                 val listFotoDomain = list.map {
                     it.toFotoDomain()
                 }
                 return listFotoDomain
             }
         }

         return emptyList()
    }
}