package br.com.antoniojoseuchoa.appplaceholderapi.data.model


import br.com.antoniojoseuchoa.appplaceholderapi.domain.models.FotoDomain

data class Foto(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)

fun Foto.toFotoDomain(): FotoDomain{
    return FotoDomain(
        albumId = this.albumId,
        id = this.id,
        thumbnailUrl = this.thumbnailUrl,
        title = this.title,
        url = this.url
    )
}