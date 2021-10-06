package com.winapp.retailboss.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.winapp.retailboss.Helpers.Utils
import com.winapp.retailboss.Models.SaleModel
import com.winapp.retailboss.R

class SalesAdapter(private val ctx: Context, saleArrayList: ArrayList<SaleModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mOnItemClickListener: OnItemClickListener? = null
    var saleArrayList: ArrayList<SaleModel> = ArrayList()


    init {
        this.saleArrayList = saleArrayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sales_layout, parent, false)
        return OriginalViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.e("onBindViewHolder", "onBindViewHolder : $position")
        if (holder is OriginalViewHolder){
            var saleOrderItem = saleArrayList[position]
            holder.productIdTextView.text = saleOrderItem.StockQty?:""
            holder.productNameTextView.text = saleOrderItem.ProductName?:""
            holder.categoryNameTextView.text = saleOrderItem.CategoryName?:""
            holder.profitTextView.text = "$ " + saleOrderItem.Profit?.let { Utils.roundOfTotalAmount(it) }
            holder.stockTextView.text = "$ " + saleOrderItem.Sold?.let { Utils.roundOfTotalAmount(it) }
            holder.purchaseTextView.text = "$ " + saleOrderItem.Bought?.let { Utils.roundOfTotalAmount(it) }
        }
    }

    override fun getItemCount(): Int {
        return saleArrayList.size
    }

    inner class OriginalViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        var productNameTextView:TextView = v.findViewById(R.id.textView26)
        var categoryNameTextView:TextView = v.findViewById(R.id.textView28)
        var productIdTextView:TextView = v.findViewById(R.id.textView32)
        var stockTextView:TextView = v.findViewById(R.id.textView34)
        var profitTextView:TextView = v.findViewById(R.id.textView36)
        var purchaseTextView:TextView = v.findViewById(R.id.textView30)

    }

    interface OnItemClickListener {
//        fun onItemClick(view: View, obj: CategoryModel, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.mOnItemClickListener = mItemClickListener
    }

}