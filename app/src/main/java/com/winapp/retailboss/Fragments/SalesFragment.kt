package com.winapp.retailboss.Fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.gson.JsonObject
import com.skydoves.powermenu.MenuAnimation
import com.skydoves.powermenu.OnMenuItemClickListener
import com.skydoves.powermenu.PowerMenu
import com.skydoves.powermenu.PowerMenuItem
import com.winapp.retailboss.Adapters.SalesAdapter
import com.winapp.retailboss.Helpers.Utils
import com.winapp.retailboss.Models.DashBoardSummary
import com.winapp.retailboss.Models.SaleModel
import com.winapp.retailboss.R
import com.winapp.retailboss.Rest.ApiClient
import com.winapp.retailboss.Rest.ApiInterface
import com.winapp.retailboss.Rest.COMPANY_CODE
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class SalesFragment : Fragment() {

    private lateinit var viewOfLayout:View
    private lateinit var saleOrderRecylerView: RecyclerView
    private lateinit var datePickerImageView: ImageView
    private lateinit var noDataTextView: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var filterMenuButtom: Button
    lateinit var saleOrderAdapter:SalesAdapter
    var salesArrayList: ArrayList<SaleModel> = ArrayList()
    lateinit var powerMenu: PowerMenu
    var fromDate  = ""
    var toDate = ""
    lateinit var totalProductTextView: TextView
    lateinit var saleProductTextView: TextView
    lateinit var profitTextView: TextView
    lateinit var amountTextView: TextView



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        viewOfLayout =  inflater.inflate(R.layout.fragment_sales, container, false)
        initComponent()
        showCalender()

        fromDate  = Utils.getCurrentDateAndTime().toString()
        toDate  = Utils.getCurrentDateAndTime().toString()
        if (fromDate != null) {
            getSaleOrderServiceCall(fromDate, fromDate,"")
        }
        return viewOfLayout
    }

    private fun initComponent() {
        saleOrderRecylerView = viewOfLayout.findViewById(R.id.sale_order_recyler_vie)
        totalProductTextView = viewOfLayout.findViewById(R.id.totalProductTextView)
        saleProductTextView = viewOfLayout.findViewById(R.id.sellProductTextView)
        amountTextView = viewOfLayout.findViewById(R.id.amountTextView)
        profitTextView = viewOfLayout.findViewById(R.id.profitTextView)
        filterMenuButtom = viewOfLayout.findViewById(R.id.button2)
        noDataTextView = viewOfLayout.findViewById(R.id.textView62)
        datePickerImageView = viewOfLayout.findViewById(R.id.imageView8)
        progressBar = viewOfLayout.findViewById(R.id.progressBar)
        saleOrderRecylerView.layoutManager = LinearLayoutManager(requireContext())
        saleOrderRecylerView.setHasFixedSize(true)
        setAdapter()
    }

    private fun showPopupMenu(){
         powerMenu = PowerMenu.Builder(requireContext())
                .addItem(PowerMenuItem("Top Products Sell"))
                 .addItem(PowerMenuItem("Profit Products"))
                .addItem(PowerMenuItem("High Stock Products"))
                .addItem(PowerMenuItem("Low Stock Products"))
                .setAnimation(MenuAnimation.SHOWUP_TOP_LEFT) // Animation start point (TOP | LEFT)
                .setMenuRadius(10f)
                .setMenuShadow(10f)
                .setTextColor(requireActivity().resources.getColor(R.color.app_color))
                .setSelectedTextColor(Color.RED)
                .setMenuColor(requireActivity().resources.getColor(R.color.white))
                .setSelectedMenuColor(requireActivity().resources.getColor(R.color.app_color))
                .setOnMenuItemClickListener(onMenuItemClickListener)
                .build()
                powerMenu.showAsAnchorRightBottom(filterMenuButtom);

    }

    @SuppressLint("SetTextI18n")
    private val onMenuItemClickListener: OnMenuItemClickListener<PowerMenuItem?> =
            OnMenuItemClickListener<PowerMenuItem?> { position, item ->
                powerMenu.selectedPosition = position // change selected item
                powerMenu.dismiss()
                when (position) {
                    0 -> {
                        filterMenuButtom.text = "Top Products Sell"
                        getSaleOrderServiceCall(fromDate, toDate,"1")
                    }
                    1 -> {
                        filterMenuButtom.text = "Profit Products"
                        getSaleOrderServiceCall(fromDate, toDate,"2")
                    }
                    2 -> {
                        filterMenuButtom.text = "High Stock Products"
                        getSaleOrderServiceCall(fromDate, toDate,"3")
                    }
                    3 -> {
                        filterMenuButtom.text = "Low Stock Products"
                        getSaleOrderServiceCall(fromDate, toDate,"4")
                    }
                }
            }




    @SuppressLint("SimpleDateFormat")
    private fun showCalender(){

        filterMenuButtom.setOnClickListener {
               showPopupMenu()
        }

        datePickerImageView.setOnClickListener {
            val dateRangePicker = MaterialDatePicker.Builder.dateRangePicker()
                    .setTitleText("Select Date Range")
                    .build()

            dateRangePicker.addOnPositiveButtonClickListener {
                val sdf = SimpleDateFormat("dd/MM/yyyy")
                val netDate = it.first?.let { it1 -> Date(it1) }
                val First =sdf.format(netDate)
                val sdf1 = SimpleDateFormat("dd/MM/yyyy")
                val netDate1 = it.second?.let { it1 -> Date(it1) }
                val second =sdf1.format(netDate1)
                Log.e("First", First)
                Log.e("Second", second)

                fromDate = First
                toDate = second

                getSaleOrderServiceCall(First, second,"")
            }
            dateRangePicker.addOnNegativeButtonClickListener {}
            dateRangePicker.addOnCancelListener { dialog ->
                dialog.dismiss()
            }
            dateRangePicker.addOnDismissListener {}
            fragmentManager?.let { dateRangePicker.show(it, dateRangePicker.toString()) }
        }

    }


    private fun setAdapter() {
        saleOrderAdapter = SalesAdapter(requireContext(), salesArrayList)
        saleOrderRecylerView.adapter = saleOrderAdapter
    }

    private fun getSaleOrderServiceCall(fromDate: String, toDate: String,status:String){
        progressBar.visibility  = View.VISIBLE
        noDataTextView.visibility = View.GONE
        salesArrayList.clear()
        saleOrderAdapter.saleArrayList = salesArrayList
        saleOrderAdapter.notifyDataSetChanged()
        val jsonObject = JsonObject()
        jsonObject.addProperty("CompanyCode", COMPANY_CODE)
        jsonObject.addProperty("CategoryCode", "")
        jsonObject.addProperty("LocationCode", "HQ")
        jsonObject.addProperty("Status", status)
        jsonObject.addProperty("StartDate", fromDate)
        jsonObject.addProperty("EndDate", toDate)
        Log.e("REQUEST DATA", jsonObject.toString())
        val apiService = ApiClient.response?.create(ApiInterface::class.java)
        val call = apiService?.getSaleOrderServiceCall(jsonObject.toString())
        call?.enqueue(object : retrofit2.Callback<List<SaleModel>> {
            override fun onResponse(call: Call<List<SaleModel>>, response: Response<List<SaleModel>>) {
                Log.e("Status Code", response.code().toString())
                if (response.code() == 200) {
                    if (response.body().isNullOrEmpty()) {
                        saleOrderRecylerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        noDataTextView.visibility = View.VISIBLE
                        Log.e("Response size", response.body()?.size.toString())
//                        getDashBoardSummary(fromDate,toDate)
                    } else {
                        noDataTextView.visibility = View.GONE
                        Log.e("Response size", response.body()?.size.toString())
                        salesArrayList = response.body() as ArrayList<SaleModel>
                        saleOrderAdapter.saleArrayList = salesArrayList
                        saleOrderAdapter.notifyDataSetChanged()
                        getDashBoardSummary(fromDate,toDate)
                    }

                } else {
                    Utils.ShowSnakBar(response.code().toString(), viewOfLayout)
                }
            }

            override fun onFailure(call: Call<List<SaleModel>>, t: Throwable) {
                progressBar.visibility = View.GONE
                Utils.ShowSnakBar(t.toString(), viewOfLayout)
            }

        })
    }


    private fun getDashBoardSummary(fromDate: String, toDate: String) {

        val jsonObject = JsonObject()
        jsonObject.addProperty("CompanyCode", COMPANY_CODE)
        jsonObject.addProperty("ProductCode", "")
        jsonObject.addProperty("CategoryCode", "")
        jsonObject.addProperty("LocationCode", "HQ")
        jsonObject.addProperty("StartDate", fromDate)
        jsonObject.addProperty("EndDate", toDate)
        Log.e("Request Data", jsonObject.toString())

        val apiService = ApiClient.response?.create(ApiInterface::class.java)
        val call = apiService?.getDashBoardSummaryServiceCall(jsonObject.toString())
        call?.enqueue(object : retrofit2.Callback<List<DashBoardSummary>> {

            override fun onFailure(call: Call<List<DashBoardSummary>>, t: Throwable) {
                saleOrderRecylerView.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<DashBoardSummary>>, response: Response<List<DashBoardSummary>>) {

                   Log.e("Request Url", response.raw().request.url.toString())
                if (response.code() == 200){
                    saleOrderRecylerView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    var dashBoardSummary :ArrayList<DashBoardSummary> = ArrayList()
                    dashBoardSummary = response.body() as ArrayList<DashBoardSummary>
                    profitTextView.text = "$ ${dashBoardSummary[0].Profit?:""}"
                    saleProductTextView.text = "${dashBoardSummary[0].TotalSalesCount?:""}"
                    amountTextView.text = "$ ${dashBoardSummary[0].NetTotal?:""}"
                    totalProductTextView.text = "$ " + dashBoardSummary[0].Category
                }else{
                    saleOrderRecylerView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), response.code().toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
        )
    }
}