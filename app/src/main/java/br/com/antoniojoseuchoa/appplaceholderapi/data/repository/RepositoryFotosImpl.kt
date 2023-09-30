package br.com.antoniojoseuchoa.appplaceholderapi.data.repository

import br.com.antoniojoseuchoa.appplaceholderapi.data.api.ApiPlaceHolder
import br.com.antoniojoseuchoa.appplaceholderapi.data.model.Foto
import retrofit2.Response
import javax.inject.Inject

class RepositoryFotosImpl @Inject constructor(private val apiPlaceHolder: ApiPlaceHolder): RepositoryFotos {
    override suspend fun getFotos(): List<Foto> {
         var response: Response<List<Foto>>? = null

         response = apiPlaceHolder.getAllPhotos()
         if(response.isSuccessful){
             val list = response.body()
             list?.let { fotos ->
                 return fotos
             }
         }

         return emptyList()
    }
}