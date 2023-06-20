//package com.example.battlegroundstats.presentation.di
//
//import com.example.battlegroundstats.data.repository.RepositoryRemoteImpl
//import com.example.battlegroundstats.data.sources.remote.mapper.RemotePlayerMapper
//import com.example.battlegroundstats.domain.repository.PubgRemoteRepository
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//
//@Module
//@InstallIn(SingletonComponent::class)
//object RemoteModule {
//
//    @Provides
//    fun providePubgRemoteRepository(mapper: RemotePlayerMapper): PubgRemoteRepository {
//        return RepositoryRemoteImpl(mapper)
//    }
//
//    @Provides
//    fun provideRemotePlayerMapper(): RemotePlayerMapper {
//        return RemotePlayerMapper()
//    }
//
//}