package com.biggerthannull.plumbbristol.domain.usecase.models

sealed class BathroomDetailsResult {
    data object Failed: BathroomDetailsResult()
    class Success(val data: BathroomDetails): BathroomDetailsResult()
}