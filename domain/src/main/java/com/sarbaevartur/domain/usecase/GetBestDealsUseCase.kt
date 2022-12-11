package com.sarbaevartur.domain.usecase

import com.sarbaevartur.domain.models.BestDeal
import com.sarbaevartur.domain.repository.StoreRepository
import kotlinx.coroutines.flow.Flow

class GetBestDealsUseCase(private val storeRepository: StoreRepository) {

    suspend fun execute(): Flow<List<BestDeal>> {
        return storeRepository.getBestDeals()
    }
}