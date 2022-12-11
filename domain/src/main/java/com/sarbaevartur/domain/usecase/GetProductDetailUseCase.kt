package com.sarbaevartur.domain.usecase

import com.sarbaevartur.domain.models.Product
import com.sarbaevartur.domain.repository.StoreRepository
import kotlinx.coroutines.flow.Flow

class GetProductDetailUseCase(private val storeRepository: StoreRepository) {

    suspend fun execute(link: String = ""): Flow<Product> {
        return storeRepository.getProductDetail(link)
    }
}