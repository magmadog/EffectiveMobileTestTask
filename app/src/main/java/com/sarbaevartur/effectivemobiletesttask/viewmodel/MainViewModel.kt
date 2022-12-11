package com.sarbaevartur.effectivemobiletesttask.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.sarbaevartur.domain.models.BestDeal
import com.sarbaevartur.domain.models.Category
import com.sarbaevartur.domain.models.HotSale
import com.sarbaevartur.domain.usecase.GetBestDealsUseCase
import com.sarbaevartur.domain.usecase.GetCategoriesUseCase
import com.sarbaevartur.domain.usecase.GetHotSalesUseCase
import com.sarbaevartur.domain.usecase.GetProductDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

private const val TAG = "AppViewModel"

class MainViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getHotSalesUseCase: GetHotSalesUseCase,
    private val getBestDealsUseCase: GetBestDealsUseCase,
    private val getProductDetailUseCase: GetProductDetailUseCase): ViewModel() {

    val categories: MutableLiveData<List<Category>> = MutableLiveData()
    val hotSales: MutableLiveData<List<HotSale>> = MutableLiveData()
    val bestDeals: MutableLiveData<List<BestDeal>> = MutableLiveData()


    fun getCategories() {
        viewModelScope.launch{
            val data = getCategoriesUseCase.execute()
            data.collect{ category ->
                categories.value = category
            }
        }
    }

    fun getHotSales() {
        viewModelScope.launch{
            val data = getHotSalesUseCase.execute()
            data.collect{ hotSale ->
                hotSales.value = hotSale
            }
        }
    }

    fun getBestDeals() {
        viewModelScope.launch{
            val data = getBestDealsUseCase.execute()
            data.collect{ bestDeal ->
                bestDeals.value = bestDeal
            }
        }
    }

    init {
        getCategories()
        getHotSales()
        getBestDeals()
    }
}