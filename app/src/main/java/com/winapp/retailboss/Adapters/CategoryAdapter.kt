package com.winapp.retailboss.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.winapp.retailboss.Helpers.Utils
import com.winapp.retailboss.Models.CategoryModel
import com.winapp.retailboss.R

class CategoryAdapter(private val ctx: Context, categoryArrayList: ArrayList<CategoryModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mOnItemClickListener: OnItemClickListener? = null
    var categoryArrayList:ArrayList<CategoryModel> = ArrayList()

    init {
        this.categoryArrayList = categoryArrayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_layout, parent, false)
        return OriginalViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.e("onBindViewHolder", "onBindViewHolder : $position")
        if (holder is OriginalViewHolder){
            var categoryObject = categoryArrayList[position]
            holder.categoryCodeTextView.text = categoryObject.CategoryCode?:""
            holder.categoryNameTextView.text = categoryObject.CategoryName?:""
            holder.profitAmountTextView.text = categoryObject.Profit?.toDouble()?.let { Utils.roundOffDecimal(it).toString() }
            holder.purchaseValueTextView.text = categoryObject.Bought?.toDouble()?.let { Utils.roundOffDecimal(it).toString() }
            holder.salesAmountTextView.text = categoryObject.Sold?.toDouble()?.let { Utils.roundOffDecimal(it).toString() }

        }
    }

    override fun getItemCount(): Int {
        return categoryArrayList.size   
    }

    inner class OriginalViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        internal var categoryCodeTextView: TextView = v.findViewById(R.id.categoryCodeTextView)
        internal var categoryNameTextView: TextView = v.findViewById(R.id.category_name_text_view)
        internal var purchaseValueTextView: TextView = v.findViewById(R.id.purchase_value_text_view)
        internal var salesAmountTextView: TextView = v.findViewById(R.id.salesAmountTextView)
        internal var profitAmountTextView: TextView = v.findViewById(R.id.profitAmountTextView)

    }

    interface OnItemClickListener {
//        fun onItemClick(view: View, obj: CategoryModel, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.mOnItemClickListener = mItemClickListener
    }

}