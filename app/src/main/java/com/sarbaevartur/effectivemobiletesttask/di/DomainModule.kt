package com.sarbaevartur.effectivemobiletesttask.di

import com.sarbaevartur.domain.usecase.GetBestDealsUseCase
import com.sarbaevartur.domain.usecase.GetCategoriesUseCase
import com.sarbaevartur.domain.usecase.GetHotSalesUseCase
import com.sarbaevartur.domain.usecase.GetProductDetailUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetCategoriesUseCase> {
        GetCategoriesUseCase(storeRepository = get())
    }

    factory<GetHotSalesUseCase> {
        GetHotSalesUseCase(storeRepository = get())
    }

    factory<GetBestDealsUseCase> {
        GetBestDealsUseCase(storeRepository = get())
    }

    factory<GetProductDetailUseCase> {
        GetProductDetailUseCase(storeRepository = get())
    }
}