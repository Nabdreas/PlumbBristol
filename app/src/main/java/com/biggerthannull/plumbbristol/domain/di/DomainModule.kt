package com.biggerthannull.plumbbristol.domain.di

import com.biggerthannull.plumbbristol.domain.usecase.GetBathroomDetailsUseCase
import com.biggerthannull.plumbbristol.domain.usecase.GetBathroomDetailsUseCaseImpl
import com.biggerthannull.plumbbristol.domain.usecase.GetBathroomsUseCase
import com.biggerthannull.plumbbristol.domain.usecase.GetBathroomsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
interface DomainModule {
    @Binds
    fun bindGetBathroomsUseCase(impl: GetBathroomsUseCaseImpl): GetBathroomsUseCase

    @Binds
    fun bindGetBathroomDetailsUseCase(impl: GetBathroomDetailsUseCaseImpl): GetBathroomDetailsUseCase
}