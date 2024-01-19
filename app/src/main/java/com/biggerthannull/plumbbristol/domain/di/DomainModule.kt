package com.biggerthannull.plumbbristol.domain.di

import com.biggerthannull.plumbbristol.domain.usecase.AddBathroomToBookmarksUseCase
import com.biggerthannull.plumbbristol.domain.usecase.AddBathroomToBookmarksUseCaseImpl
import com.biggerthannull.plumbbristol.domain.usecase.GetBathroomDetailsUseCase
import com.biggerthannull.plumbbristol.domain.usecase.GetBathroomDetailsUseCaseImpl
import com.biggerthannull.plumbbristol.domain.usecase.GetBathroomsUseCase
import com.biggerthannull.plumbbristol.domain.usecase.GetBathroomsUseCaseImpl
import com.biggerthannull.plumbbristol.domain.usecase.GetInspirationalImagesUseCase
import com.biggerthannull.plumbbristol.domain.usecase.GetInspirationalImagesUseCaseImpl
import com.biggerthannull.plumbbristol.domain.usecase.GetTeamUseCase
import com.biggerthannull.plumbbristol.domain.usecase.GetTeamUseCaseImpl
import com.biggerthannull.plumbbristol.domain.usecase.ObserveBookmarkedBathroomsUseCase
import com.biggerthannull.plumbbristol.domain.usecase.ObserveBookmarkedBathroomsUseCaseImpl
import com.biggerthannull.plumbbristol.domain.usecase.RemoveBathroomFromBookmarksUseCase
import com.biggerthannull.plumbbristol.domain.usecase.RemoveBathroomFromBookmarksUseCaseImpl
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

    @Binds
    fun bindGetTeamUseCase(impl: GetTeamUseCaseImpl): GetTeamUseCase

    @Binds
    fun bindAddBathroomToBookmarksUseCase(impl: AddBathroomToBookmarksUseCaseImpl): AddBathroomToBookmarksUseCase

    @Binds
    fun bindObserveBookmarkedBathroomsUseCase(impl: ObserveBookmarkedBathroomsUseCaseImpl): ObserveBookmarkedBathroomsUseCase

    @Binds
    fun bindRemoveBathroomFromBookmarksUseCase(impl: RemoveBathroomFromBookmarksUseCaseImpl): RemoveBathroomFromBookmarksUseCase

    @Binds
    fun bindGetInspirationalImagesUseCase(impl: GetInspirationalImagesUseCaseImpl): GetInspirationalImagesUseCase
}