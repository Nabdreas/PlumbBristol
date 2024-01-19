package com.biggerthannull.plumbbristol.data.datasource

import com.biggerthannull.plumbbristol.data.datasource.model.DiscoveredBathroomsDTO
import javax.inject.Inject

class DiscoverDataSourceImpl @Inject constructor() : DiscoverDataSource {
    override suspend fun discoverBathrooms(): Result<List<DiscoveredBathroomsDTO>> {
        val dto = DiscoveredBathroomsDTO(
            imageUrl = "https://www.keystonebathrooms.co.uk/wp-content/uploads/2020/08/bathroom-design-installation-Bristol-Bath.jpg"
        )
        val dto1 = DiscoveredBathroomsDTO(
            imageUrl = "https://kitchensplusbathrooms.co.uk/wp-content/uploads/2023/05/USED-KB_11.22-31-resized.webp"
        )
        val dto2 = DiscoveredBathroomsDTO(
            imageUrl = "https://kallumsbathrooms.co.uk/wp-content/uploads/2022/10/London-Bathroom-Design-Service-Slider.jpg"
        )
        return Result.success(listOf(dto, dto1, dto2))
    }
}