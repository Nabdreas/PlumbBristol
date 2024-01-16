package com.biggerthannull.plumbbristol.domain.repository

import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomOverview

interface BathroomsRepository {
    fun getBathrooms(): List<BathroomOverview>

    fun getBathroom(): BathroomDetails
}