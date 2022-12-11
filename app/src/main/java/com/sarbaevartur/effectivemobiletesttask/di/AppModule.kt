package com.sarbaevartur.effectivemobiletesttask.di

import com.sarbaevartur.effectivemobiletesttask.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel>(){
        MainViewModel(
            getCategoriesUseCase = get(),
            getHotSalesUseCase = get(),
            getBestDealsUseCase = get(),
            getProductDetailUseCase = get())
    }
}