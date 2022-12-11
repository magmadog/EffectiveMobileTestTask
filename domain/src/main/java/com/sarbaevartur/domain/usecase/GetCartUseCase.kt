package com.sarbaevartur.domain.usecase

import com.sarbaevartur.domain.models.Cart
import com.sarbaevartur.domain.repository.StoreRepository
import kotlinx.coroutines.flow.Flow

class GetCartUseCase(private val storeRepository: StoreRepository) {

    suspend fun execute(): Flow<Cart>{
        return storeRepository.getCart()
    }
}