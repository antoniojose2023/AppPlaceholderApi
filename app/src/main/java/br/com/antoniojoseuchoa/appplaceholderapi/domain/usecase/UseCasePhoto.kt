package br.com.antoniojoseuchoa.appplaceholderapi.domain.usecase

import br.com.antoniojoseuchoa.appplaceholderapi.domain.models.FotoDomain
import br.com.antoniojoseuchoa.appplaceholderapi.domain.repository.RepositoryFotos
import javax.inject.Inject

class UseCasePhoto @Inject constructor(private val repositoryFotos: RepositoryFotos) {
    suspend operator fun invoke(): List<FotoDomain>{
          return repositoryFotos.getFotos()
    }

}