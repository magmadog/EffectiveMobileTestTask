package com.sarbaevartur.data.data.storage

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import com.sarbaevartur.data.data.storage.models.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

private const val TAG = "LocalStorage"

class StoreLocalStorage(private val context: Context): StoreStorage {
    override suspend fun getCategories(): Flow<List<CategoryStorage>> {
        var categories = mutableListOf<CategoryStorage>()
        val catList = listOf<Pair<String, String?>>(
            Pair("Phones", "ic_phone"),
            Pair("Computer", "ic_computer"),
            Pair("Health", "ic_favourite"),
            Pair("Books", "ic_book"),
            Pair("Test", null))
        for (cat in catList){
            categories.add(CategoryStorage(cat.first, loadImage(cat.second)?.drawable))
        }

        return flow { emit(categories) }
    }

    override suspend fun getHotSales(): Flow<HotSaleStorage> {
        TODO("Not yet implemented")
    }

    override suspend fun getBestDeals(): Flow<BestDealsStorage> {
        TODO("Not yet implemented")
    }

    override suspend fun getProductDetail(link: String): Flow<ProductStorage> {
        TODO("Not yet implemented")
    }

    override suspend fun getCart(): Flow<CartStorage> {
        TODO("Not yet implemented")
    }

    override fun loadImage(image: String?): LoadedImage? {
        if (image.isNullOrBlank()) return LoadedImage()

        return try {
            val imageId: Int = context.resources.getIdentifier(image, "drawable", context.packageName)
            val drawable: Drawable? = imageId.let { context.getDrawable(it) }
            LoadedImage(drawable = drawable)
        } catch (ex: IOException) {
            Log.d(TAG, "Error, drawable can't be load: $ex")
            null
        }
    }
}