package br.com.antoniojoseuchoa.appplaceholderapi.di

import br.com.antoniojoseuchoa.appplaceholderapi.data.api.ApiPlaceHolder
import br.com.antoniojoseuchoa.appplaceholderapi.data.repository.RepositoryFotos
import br.com.antoniojoseuchoa.appplaceholderapi.data.repository.RepositoryFotosImpl
import br.com.antoniojoseuchoa.appplaceholderapi.util.Utils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    fun providerRetrofit(): Retrofit{
          return Retrofit.Builder()
              .baseUrl(Utils.BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .build()
    }

    @Provides
    fun providerApiPlaceHolder(retrofit: Retrofit): ApiPlaceHolder{
        return retrofit.create(ApiPlaceHolder::class.java)
    }

    @Provides
    fun providesRepositoryPhotos(apiPlaceHolder: ApiPlaceHolder): RepositoryFotos{
        return RepositoryFotosImpl(apiPlaceHolder)
    }

}