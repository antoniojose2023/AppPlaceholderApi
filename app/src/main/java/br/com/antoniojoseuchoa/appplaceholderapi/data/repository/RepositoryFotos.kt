package br.com.antoniojoseuchoa.appplaceholderapi.data.repository

import br.com.antoniojoseuchoa.appplaceholderapi.data.model.Foto

interface RepositoryFotos {
    suspend fun getFotos(): List<Foto>
}