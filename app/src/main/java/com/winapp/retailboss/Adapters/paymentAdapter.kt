package com.winapp.retailboss.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.winapp.retailboss.R

class PaymentAdapter(private val ctx: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mOnItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.payment_layout, parent, false)
        return OriginalViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.e("onBindViewHolder", "onBindViewHolder : $position")
    }

    override fun getItemCount(): Int {
        return 5
    }

    inner class OriginalViewHolder(v: View) : RecyclerView.ViewHolder(v) {

//        internal var cardLayout: CardView = v.findViewById(R.id.cardView)

    }

    interface OnItemClickListener {
//        fun onItemClick(view: View, obj: CategoryModel, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.mOnItemClickListener = mItemClickListener
    }

}