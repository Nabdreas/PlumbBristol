package com.biggerthannull.plumbbristol.data.di

import com.biggerthannull.plumbbristol.data.datasource.BathroomsDataSource
import com.biggerthannull.plumbbristol.data.datasource.BathroomsDataSourceImpl
import com.biggerthannull.plumbbristol.data.datasource.LocalBathroomsDataSource
import com.biggerthannull.plumbbristol.data.datasource.LocalBathroomsDataSourceImpl
import com.biggerthannull.plumbbristol.data.datasource.TeamDataSource
import com.biggerthannull.plumbbristol.data.datasource.TeamDataSourceImpl
import com.biggerthannull.plumbbristol.data.repository.BathroomsRepositoryImpl
import com.biggerthannull.plumbbristol.data.repository.BookmarksRepositoryImpl
import com.biggerthannull.plumbbristol.data.repository.TeamRepositoryImpl
import com.biggerthannull.plumbbristol.domain.repository.BathroomsRepository
import com.biggerthannull.plumbbristol.domain.repository.BookmarksRepository
import com.biggerthannull.plumbbristol.domain.repository.TeamRepository
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
    fun bindTeamRepository(impl: TeamRepositoryImpl): TeamRepository

    @Binds
    fun bindBookmarksRepository(impl: BookmarksRepositoryImpl): BookmarksRepository

    @Binds
    fun bindBathroomsDataSource(impl: BathroomsDataSourceImpl): BathroomsDataSource

    @Binds
    fun bindTeamDataSource(impl: TeamDataSourceImpl): TeamDataSource

    @Binds
    fun bindsLocalBathroomsDataSource(impl: LocalBathroomsDataSourceImpl): LocalBathroomsDataSource
}