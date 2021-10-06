package com.winapp.retailboss.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.winapp.retailboss.Activites.CategoryActivity
import com.winapp.retailboss.Models.DashBoardSummary
import com.winapp.retailboss.R

class OverViewAdapter(private val ctx: Context,dashBoardSummary: ArrayList<DashBoardSummary>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mOnItemClickListener: OnItemClickListener? = null
    var dashBoardSummary:ArrayList<DashBoardSummary> = ArrayList()

    init {
        this.dashBoardSummary = dashBoardSummary
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_layout_one, parent, false)
        return OriginalViewHolder(view)
    }

    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables", "ResourceType")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.e("onBindViewHolder", "onBindViewHolder : $position")
        if (holder is OriginalViewHolder){
//            val dashBoardSummaryObject = dashBoardSummary[position]
            when (position) {

                0 -> {
                    holder.cardLayout.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#2AA893"))
                    holder.categoryValueTextView.text = "${dashBoardSummary[0].Category?:""}"
                    holder.subCategoryValueTextView.text = "${dashBoardSummary[0].SubCategory?:""}"
                    holder.cardLayout.setOnClickListener {
                        ctx.startActivity(Intent(ctx, CategoryActivity::class.java))
                    }
                }

                1 -> {
                    holder.cardLayout.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#5C4DB1"))
                    holder.categoryTextView.text = "Products"
                    holder.categoryValueTextView.text = "$ 257.35"
                    holder.categoryValueTextView.visibility = View.INVISIBLE
                    holder.subCategoryTextView.text = "Total Product"
                    holder.subCategoryValueTextView.text = ""
                }

                2 -> {
                    holder.cardLayout.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#32C3D4"))
                    holder.categoryTextView.text = "Total Cash In"
                    holder.arrowBackButton.visibility = View.INVISIBLE
                    holder.subCategoryValueTextView.visibility = View.GONE
                    holder.subCategoryTextView.visibility = View.INVISIBLE
                    holder.storeImageView.visibility = View.GONE
                    holder.categoryValueTextView.gravity = Gravity.CENTER
                    holder.categoryTextView.gravity = Gravity.CENTER

                    holder.categoryValueTextView.text = "$ ${dashBoardSummary[0].CashIn?:""}"
                }

                3 -> {

                    holder.cardLayout.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#E9972A"))
                    holder.arrowBackButton.visibility = View.INVISIBLE
                    holder.subCategoryValueTextView.visibility = View.GONE
                    holder.subCategoryTextView.visibility = View.INVISIBLE
                    holder.storeImageView.visibility = View.GONE
                    holder.categoryValueTextView.gravity = Gravity.CENTER
                    holder.categoryTextView.gravity = Gravity.CENTER
                    holder.categoryTextView.text = "Total Cash Out"
                    holder.categoryValueTextView.text = "$ ${dashBoardSummary[0].CashOut?:""}"
                }

                else -> {
                    holder.cardLayout.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#2AA893"))
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return 4
    }

    inner class OriginalViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        internal var cardLayout:CardView = v.findViewById(R.id.cardView)
        internal var subCategoryTextView:TextView = v.findViewById(R.id.textView6)
        internal var storeImageView:ImageView = v.findViewById(R.id.imageView3)
        internal var subCategoryValueTextView:TextView = v.findViewById(R.id.textView9)
        internal var categoryTextView:TextView = v.findViewById(R.id.textView3)
        internal var categoryValueTextView:TextView = v.findViewById(R.id.textView5)
        internal var arrowBackButton:ImageButton = v.findViewById(R.id.imageButton)

    }

    interface OnItemClickListener {
//        fun onItemClick(view: View, obj: CategoryModel, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.mOnItemClickListener = mItemClickListener
    }

}