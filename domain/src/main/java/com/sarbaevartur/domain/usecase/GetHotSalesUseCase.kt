package com.sarbaevartur.domain.usecase

import com.sarbaevartur.domain.models.HotSale
import com.sarbaevartur.domain.repository.StoreRepository
import kotlinx.coroutines.flow.Flow

class GetHotSalesUseCase(private val storeRepository: StoreRepository) {

    suspend fun execute(): Flow<List<HotSale>> {
        return  storeRepository.getHotSales()
    }
}