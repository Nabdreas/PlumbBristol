package com.biggerthannull.plumbbristol.data.di

import com.biggerthannull.plumbbristol.data.datasource.BathroomsDataSource
import com.biggerthannull.plumbbristol.data.datasource.BathroomsDataSourceImpl
import com.biggerthannull.plumbbristol.data.repository.BathroomsRepositoryImpl
import com.biggerthannull.plumbbristol.domain.repository.BathroomsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindBathroomsRepository(impl: BathroomsRepositoryImpl): BathroomsRepository

    @Binds
    fun bindBathroomsDataSource(impl: BathroomsDataSourceImpl): BathroomsDataSource
}