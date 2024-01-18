package com.biggerthannull.plumbbristol.ui.views.viewmodels.events

import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails

interface DetailsUserEvents {
    fun bookmarkBathroom(data: BathroomDetails)
}