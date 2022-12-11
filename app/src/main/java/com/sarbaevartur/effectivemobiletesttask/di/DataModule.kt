package com.sarbaevartur.effectivemobiletesttask.di

import com.sarbaevartur.data.data.StoreRepositoryImpl
import com.sarbaevartur.domain.repository.StoreRepository
import org.koin.dsl.module
import com.sarbaevartur.data.data.storage.StoreLocalStorage
import com.sarbaevartur.data.data.storage.StoreNetStorage

val dataModule = module {

    single<StoreLocalStorage>{
        StoreLocalStorage(context = get())
    }

    single<StoreNetStorage>{
        StoreNetStorage(context = get())
    }

    single<StoreRepository> {
        StoreRepositoryImpl(localStorage = get(), netStorage = get())
    }
}