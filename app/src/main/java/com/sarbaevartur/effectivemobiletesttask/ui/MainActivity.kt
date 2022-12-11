package com.sarbaevartur.effectivemobiletesttask.ui

import android.content.Context
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.sarbaevartur.domain.models.BestDeal
import com.sarbaevartur.domain.models.Category
import com.sarbaevartur.domain.models.HotSale
import com.sarbaevartur.effectivemobiletesttask.R
import com.sarbaevartur.effectivemobiletesttask.viewmodel.MainViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private val vm by viewModel<MainViewModel>()
    lateinit var btmNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btmNavView = findViewById(R.id.bottom_navigation)
        btmNavView.setOnClickListener() {
//            when (it.getItemId()){
                Log.d(TAG, it.toString())
        }

        val categoryRecyclerView: RecyclerView = findViewById(R.id.rv_category)
        val categoryAdapter = RecyclerAdapter(context = applicationContext)
        categoryRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryRecyclerView.adapter = categoryAdapter
        vm.categories.observe(this, Observer {
            it?.let {
                categoryAdapter.refreshCategories(it)
            }
        })

        val hotSalesRecyclerView: RecyclerView = findViewById(R.id.rv_hotsale)
        val hotSaleAdpater =  HotSaleRecyclerAdapter(context = applicationContext)
        hotSalesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        hotSalesRecyclerView.adapter = hotSaleAdpater
        vm.hotSales.observe(this, Observer {
            it?.let {
                hotSaleAdpater.refreshHotSales(it)
            }
        })

        val bestDealsRecyclerView: RecyclerView = findViewById(R.id.rv_best_sales)
        val bestDealsAdpater =  BestDealsRecyclerAdapter(context = applicationContext)
        bestDealsRecyclerView.layoutManager = GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false)
        bestDealsRecyclerView.adapter = bestDealsAdpater
        vm.bestDeals.observe(this, Observer {
            it?.let {
                bestDealsAdpater.refreshHotSales(it)
            }
        })
    }
}

class RecyclerAdapter(val context: Context): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    private var categories: List<Category> = listOf()

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val mbCategoryImage: MaterialButton = itemView.findViewById(R.id.mb_category_image)
        val tvCategoryName: TextView = itemView.findViewById(R.id.tv_category_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_category_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position == 0) {
            holder.mbCategoryImage.setBackgroundColor(context.getColor(R.color.orange))
            holder.mbCategoryImage.setIconTintResource(R.color.white)
            holder.tvCategoryName.setTextColor(context.getColor(R.color.orange))
        }
        holder.mbCategoryImage.icon = categories[position].image
        holder.tvCategoryName.text = categories[position].categoryName
    }

    override fun getItemCount() = categories.size

    fun changeSelectedCategory(prevPosition: Int, currPosition: Int){

    }

    fun refreshCategories(categories: List<Category>) {
        this.categories = categories
        notifyDataSetChanged()
    }
}

class HotSaleRecyclerAdapter(private val context: Context): RecyclerView.Adapter<HotSaleRecyclerAdapter.HotSaleViewHolder>(){

    private var hotSales: List<HotSale> = listOf()

    class HotSaleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivHotSale: ImageView = itemView.findViewById(R.id.iv_hot_sale)
        val ivHotSaleIsNew: ImageView = itemView.findViewById(R.id.iv_hot_sale_is_new)
        val tvHotSaleTitle: TextView = itemView.findViewById(R.id.tv_hot_sale_title)
        val tvHotSaleSubtitle: TextView = itemView.findViewById(R.id.tv_hot_sale_subtitle)
        val btnHotSale: Button = itemView.findViewById(R.id.btn_hot_sale)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSaleViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_hot_sale_item, parent, false)
        return HotSaleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HotSaleViewHolder, position: Int) {
        Picasso.with(context).load(hotSales[position].picture).into(holder.ivHotSale)
        when(hotSales[position].is_new){
            true -> holder.ivHotSaleIsNew.visibility = View.VISIBLE
            false -> holder.ivHotSaleIsNew.visibility = View.INVISIBLE
        }
        holder.tvHotSaleTitle.text = hotSales[position].title
        holder.tvHotSaleSubtitle.text = hotSales[position].subtitle
        when(hotSales[position].is_buy){
            true -> holder.btnHotSale.visibility = View.VISIBLE
            false -> holder.btnHotSale.visibility = View.INVISIBLE
        }
    }

    override fun getItemCount() = hotSales.size

    fun refreshHotSales(hotSales: List<HotSale>) {
        this.hotSales = hotSales
        notifyDataSetChanged()
    }
}

class BestDealsRecyclerAdapter(private val context: Context): RecyclerView.Adapter<BestDealsRecyclerAdapter.BestDealViewHolder>(){

    private var bestDeals: List<BestDeal> = listOf()

    class BestDealViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivBestDeal: ImageView = itemView.findViewById(R.id.iv_best_deal)
        val ivIsFavorite: MaterialButton = itemView.findViewById(R.id.iv_best_deal_is_favorite)
        val tvPrice: TextView = itemView.findViewById(R.id.tv_price_without_discount)
        val tvDiscountPrice: TextView = itemView.findViewById(R.id.tv_discount_price)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_best_deal_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestDealViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_best_seller_item, parent, false)
        return BestDealViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BestDealViewHolder, position: Int) {
        Picasso.with(context).load(bestDeals[position].picture).into(holder.ivBestDeal)
        when(bestDeals[position].is_favourites){
            true -> holder.ivIsFavorite.setIconResource(R.drawable.ic_favorite)
            false -> holder.ivIsFavorite.setIconResource(R.drawable.ic_not_favorite)
        }
        holder.ivIsFavorite.foregroundGravity = Gravity.END
        holder.tvPrice.text = "$" + bestDeals[position].price_without_discount.toString()
        holder.tvDiscountPrice.text = "$" + bestDeals[position].discount_price
        holder.tvDiscountPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        holder.tvTitle.text = bestDeals[position].title
    }

    override fun getItemCount() = bestDeals.size

    fun refreshHotSales(bestDeals: List<BestDeal>) {
        this.bestDeals = bestDeals
        notifyDataSetChanged()
    }
}