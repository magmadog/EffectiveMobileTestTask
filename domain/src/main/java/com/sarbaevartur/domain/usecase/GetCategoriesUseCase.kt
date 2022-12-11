package com.sarbaevartur.domain.usecase

import com.sarbaevartur.domain.models.Category
import com.sarbaevartur.domain.repository.StoreRepository
import kotlinx.coroutines.flow.Flow

class GetCategoriesUseCase(private val storeRepository: StoreRepository) {

    suspend fun execute(): Flow<List<Category>> {
        return storeRepository.getCategories()
    }
}