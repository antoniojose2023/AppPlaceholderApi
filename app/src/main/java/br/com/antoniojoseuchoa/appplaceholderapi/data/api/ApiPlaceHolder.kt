package br.com.antoniojoseuchoa.appplaceholderapi.data.api

import br.com.antoniojoseuchoa.appplaceholderapi.data.model.Foto
import retrofit2.Response
import retrofit2.http.GET

interface ApiPlaceHolder {

    @GET("photos")
    suspend fun getAllPhotos(): Response<List<Foto>>
}