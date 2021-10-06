package com.winapp.retailboss.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.winapp.retailboss.Models.DashBoardSummary
import com.winapp.retailboss.R

class OverAllProfitAdapter(private val ctx: Context, dashBoardSummary:ArrayList<DashBoardSummary>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mOnItemClickListener: OnItemClickListener? = null
    var dashBoardSummary:ArrayList<DashBoardSummary> = ArrayList()

    init {
        this.dashBoardSummary = dashBoardSummary
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.over_all_profit_layoout, parent, false)
        return OriginalViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.e("onBindViewHolder", "onBindViewHolder : $position")
        if (holder is OriginalViewHolder){
            var dashBoardSummaryObject = dashBoardSummary[position]
            holder.sellAmountTextVIew.text =  "$ ${dashBoardSummaryObject.Bought}"
            holder.soldAmountTextView.text =  "$ ${dashBoardSummaryObject.Sold}"
            holder.sellItemTextView.text = "Sell Items : ${dashBoardSummaryObject.TotalSalesCount}"
            holder.profitAmountTextView.text = "$ ${dashBoardSummaryObject?.Profit}"

        }
    }

    override fun getItemCount(): Int {
        return dashBoardSummary.size
    }

    inner class OriginalViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        internal var sellItemTextView: TextView = v.findViewById(R.id.textView12)
        internal var sellAmountTextVIew: TextView = v.findViewById(R.id.textView15)
        internal var profitAmountTextView: TextView = v.findViewById(R.id.textView16)
        internal var soldAmountTextView: TextView = v.findViewById(R.id.textView14)
    }

    interface OnItemClickListener {
//        fun onItemClick(view: View, obj: CategoryModel, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.mOnItemClickListener = mItemClickListener
    }

}