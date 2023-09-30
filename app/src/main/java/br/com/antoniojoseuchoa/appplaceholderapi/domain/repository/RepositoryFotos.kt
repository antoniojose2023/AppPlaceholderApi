package br.com.antoniojoseuchoa.appplaceholderapi.domain.repository

import br.com.antoniojoseuchoa.appplaceholderapi.data.model.Foto
import br.com.antoniojoseuchoa.appplaceholderapi.domain.models.FotoDomain

interface RepositoryFotos {
    suspend fun getFotos(): List<FotoDomain>
}