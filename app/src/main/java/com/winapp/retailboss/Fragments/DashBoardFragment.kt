package com.winapp.retailboss.Fragments

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.gson.JsonObject
import com.winapp.retailboss.Adapters.OverAllProfitAdapter
import com.winapp.retailboss.Adapters.OverViewAdapter
import com.winapp.retailboss.Adapters.SalesAdapter
import com.winapp.retailboss.Helpers.PrefManager
import com.winapp.retailboss.Models.ChartModel
import com.winapp.retailboss.Models.DashBoardModel
import com.winapp.retailboss.Models.DashBoardSummary
import com.winapp.retailboss.R
import com.winapp.retailboss.Rest.ApiClient
import com.winapp.retailboss.Rest.ApiInterface
import com.winapp.retailboss.Rest.COMPANY_CODE
import retrofit2.Call
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList


class DashBoardFragment : Fragment() {

    private lateinit var viewOfLayout: View
    private lateinit var adapterOneRecylerView: RecyclerView
    private lateinit var adapterTwoRecyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var nestedScrollView: NestedScrollView
    lateinit var overViewAdapter: OverViewAdapter
    lateinit var overAllProfitAdapter: OverAllProfitAdapter
    lateinit var salesOrderAdapter: SalesAdapter
    lateinit var userNameTextView: TextView
    lateinit var totalSalesTextView: TextView
    lateinit var todaySalesTextView: TextView
    lateinit var todayProductTextView: TextView
    lateinit var lableTextView: TextView
    lateinit var profitTextView: TextView
    lateinit var todayTab: TabItem
    lateinit var weekTab: TabItem
    lateinit var monthTab: TabItem
    lateinit var yearTab: TabItem
    var dashBoardData: DashBoardModel = DashBoardModel()
    lateinit var CubeChart: LineChart

    var chartModelArrayList: ChartModel = ChartModel()
    var isFrom = "T"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewOfLayout = inflater.inflate(R.layout.fragment_dash_board, container, false)
        initComponent()
        buttonActionMethods()
        getDashBoardServiceCall()

        return viewOfLayout
    }

    private fun initLineChartDownFill() {
        CubeChart = viewOfLayout.findViewById(R.id.cub_chart)
        CubeChart.setTouchEnabled(true)
        CubeChart.setDragEnabled(false)
        CubeChart.setScaleEnabled(true)
        CubeChart.setPinchZoom(false)
        CubeChart.setDrawGridBackground(false)
        CubeChart.maxHighlightDistance = 200F
//        CubeChart.animateX(5)
//        CubeChart.setViewPortOffsets(0F, 0F, 0F, 0F)
        lineChartDownFillWithData()
    }

    private fun lineChartDownFillWithData() {
        val description = Description()
        description.setText("Today Data")
        CubeChart.setDescription(description)
        val entryArrayList: ArrayList<Entry> = ArrayList()
        if (isFrom == "T") {
            //DAILY
            chartModelArrayList.DailyDetails.forEachIndexed { index, element ->
                entryArrayList.add(
                    Entry(
                        chartModelArrayList.DailyDetails[index].Hour?.toFloat() ?: 0f,
                        chartModelArrayList.DailyDetails[index].NetTotal?.toFloat() ?: 0f,
                        chartModelArrayList.DailyDetails[index].SalesCount ?: ""
                    )
                )
            }
        } else if (isFrom == "W") {
            // WEEK
            chartModelArrayList.WeeklyDetails.forEachIndexed { index, element ->
                entryArrayList.add(
                    Entry(
                        chartModelArrayList.WeeklyDetails[index].Weekly?.toFloat() ?: 0f,
                        chartModelArrayList.WeeklyDetails[index].NetTotal?.toFloat() ?: 0f,
                        chartModelArrayList.WeeklyDetails[index].SalesCount ?: ""
                    )
                )
            }
        } else if (isFrom == "M") {
            //MONTH
            chartModelArrayList.MonthlyDetails.forEachIndexed { index, element ->
                entryArrayList.add(
                    Entry(
                        chartModelArrayList.MonthlyDetails[index].Month?.toFloat() ?: 0f,
                        chartModelArrayList.MonthlyDetails[index].NetTotal?.toFloat() ?: 0f,
                        chartModelArrayList.MonthlyDetails[index].SalesCount ?: ""
                    )
                )
            }
        } else if (isFrom == "Y") {
            // YEAR
            chartModelArrayList.YearlyDetails.forEachIndexed { index, element ->
                entryArrayList.add(
                    Entry(
                        chartModelArrayList.YearlyDetails[index].Year?.toFloat() ?: 0f,
                        chartModelArrayList.YearlyDetails[index].NetTotal?.toFloat() ?: 0f,
                        chartModelArrayList.YearlyDetails[index].SalesCount ?: ""
                    )
                )
            }
        }else{
            //DAILY
            chartModelArrayList.DailyDetails.forEachIndexed { index, element ->
                entryArrayList.add(
                    Entry(
                        chartModelArrayList.DailyDetails[index].Hour?.toFloat() ?: 0f,
                        chartModelArrayList.DailyDetails[index].NetTotal?.toFloat() ?: 0f,
                        chartModelArrayList.DailyDetails[index].SalesCount ?: ""
                    )
                )
            }
        }

        //LineDataSet is the line on the graph
        val lineDataSet = LineDataSet(entryArrayList, "Retail Boss")
        lineDataSet.lineWidth = 2f
        lineDataSet.color = Color.RED
//        lineDataSet.setCircleColorHole(Color.GREEN)
        lineDataSet.setCircleColor(R.color.white)
        lineDataSet.highLightColor = Color.RED
        lineDataSet.setDrawValues(true)
        lineDataSet.circleRadius = 5f
        lineDataSet.setCircleColor(resources.getColor(R.color.grid_three))

        //to make the smooth line as the graph is adrapt change so smooth curve
        lineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        //to enable the cubic density : if 1 then it will be sharp curve
        lineDataSet.cubicIntensity = 0.5f

        //to fill the below of smooth line in graph
        lineDataSet.setDrawFilled(true)
        lineDataSet.fillColor = Color.TRANSPARENT
        //set the transparency
        lineDataSet.fillAlpha = 10

        //set the gradiant then the above draw fill color will be replace
        val drawable = ContextCompat.getDrawable(requireContext(), R.color.chart_color)
        lineDataSet.fillDrawable = drawable

        //set legend disable or enable to hide {the left down corner name of graph}
        val legend: Legend = CubeChart.legend
        legend.isEnabled = true

        //to remove the cricle from the graph
        lineDataSet.setDrawCircles(true)
        lineDataSet.setDrawCircleHole(true)

        //lineDataSet.setColor(ColorTemplate.COLORFUL_COLORS);
        val iLineDataSetArrayList: ArrayList<ILineDataSet> = ArrayList()
        iLineDataSetArrayList.add(lineDataSet)

        //LineData is the data accord
        val lineData = LineData(iLineDataSetArrayList)
        lineData.setValueTextSize(10f)
        lineData.setValueTextColor(resources.getColor(R.color.payment_color))
        CubeChart.setData(lineData)
        CubeChart.invalidate()
    }

    private fun buttonActionMethods() {

        val tabLayout = viewOfLayout.findViewById(R.id.tabLayout3) as TabLayout

        tabLayout.setOnTabSelectedListener(object : OnTabSelectedListener {
            @SuppressLint("SetTextI18n")
            override fun onTabSelected(tab: TabLayout.Tab) {
                val position = tab.position
                Log.e("Tab Position", position.toString())
                when (position) {
                    4 -> {
                        val c: Calendar = Calendar.getInstance()
                        val mYear = c.get(Calendar.YEAR)
                        val mMonth = c.get(Calendar.MONTH)
                        val mDay = c.get(Calendar.DAY_OF_MONTH)


                        val datePickerDialog = DatePickerDialog(
                            requireContext(),
                            OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                                //                                txtDate.setText(dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                            }, mYear, mMonth, mDay
                        )
                        datePickerDialog.show()
                    }
                    1 -> {
                        isFrom = "W"
                        totalSalesTextView.text = "$ " + dashBoardData?.TotalSummary?.InvoiceWeekTotal.toString()
                        todaySalesTextView.text = "$ " + dashBoardData.TotalSummary?.InvoiceWeekTotal.toString()
                        todayProductTextView.text = dashBoardData.TotalSummary?.ProductWeeklyTotal.toString()
                        lableTextView.text = "Weekly Sales"
                        initLineChartDownFill()
                    }
                    2 -> {
                        isFrom = "M"
                        totalSalesTextView.text = "$ " + dashBoardData?.TotalSummary?.InvoiceMonthTotal.toString()
                        todaySalesTextView.text = "$ " + dashBoardData.TotalSummary?.InvoiceMonthTotal.toString()
                        todayProductTextView.text = dashBoardData.TotalSummary?.ProductMonthlyTotal.toString()
                        lableTextView.text = "Monthly Sales"
//                        totalSalesTextView.text =  "$ " + dashBoardData?.TotalSummary?.InvoiceMonthTotal.toString()
                        initLineChartDownFill()
                    }
                    3 -> {
                        isFrom = "Y"
                        totalSalesTextView.text = "$ " + dashBoardData?.TotalSummary?.InvoiceYearlyTotal.toString()
                        todaySalesTextView.text = "$ " + dashBoardData.TotalSummary?.InvoiceYearlyTotal.toString()
                        todayProductTextView.text = dashBoardData.TotalSummary?.ProductYearlyTotal.toString()
                        lableTextView.text = "Yearly Sales"
                        initLineChartDownFill()
                    }
                    else -> {
                        isFrom = "T"
                        totalSalesTextView.text = "$ " + dashBoardData?.TotalSummary?.InvoiceTodayTotal.toString()
                        todaySalesTextView.text = "$ " + dashBoardData.TotalSummary?.InvoiceTodayTotal.toString()
                        todayProductTextView.text = dashBoardData.TotalSummary?.ProductTodayTotal.toString()
                        lableTextView.text = "Today Sales"
                        initLineChartDownFill()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {
                val position = tab?.position

                when (position) {
                    4 -> {
                        val c: Calendar = Calendar.getInstance()
                        val mYear = c.get(Calendar.YEAR)
                        val mMonth = c.get(Calendar.MONTH)
                        val mDay = c.get(Calendar.DAY_OF_MONTH)


                        val datePickerDialog = DatePickerDialog(
                            requireContext(),
                            OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                                //                                txtDate.setText(dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                            }, mYear, mMonth, mDay
                        )
                        datePickerDialog.show()
                    }
                    1 -> {
                       isFrom = "W"
                        initLineChartDownFill()
                    }
                    2 -> {
                        isFrom = "M"
                        initLineChartDownFill()
                    }
                    3 -> {
                        isFrom = "Y"
                        initLineChartDownFill()
                    }
                    else -> {
                        isFrom = "T"
                        initLineChartDownFill()
                    }
                }
            }
        })

    }

    private fun initComponent() {

        totalSalesTextView = viewOfLayout.findViewById(R.id.invoiceTodayTextview)
        todaySalesTextView = viewOfLayout.findViewById(R.id.invoiceTodaySalesTextView)
        todayProductTextView = viewOfLayout.findViewById(R.id.invoiceTotalProductTextView)
        lableTextView = viewOfLayout.findViewById(R.id.textView7)

        adapterOneRecylerView = viewOfLayout.findViewById(R.id.adapterOneRecylerView)
        nestedScrollView = viewOfLayout.findViewById(R.id.dashboard_scroll_view)
        progressBar = viewOfLayout.findViewById(R.id.progressBar3)
        userNameTextView = viewOfLayout.findViewById(R.id.textView4)
        adapterOneRecylerView.layoutManager = GridLayoutManager(requireContext(), 2)
        adapterOneRecylerView.setHasFixedSize(true)

        adapterTwoRecyclerView = viewOfLayout.findViewById(R.id.overAllProfitListView)
        adapterTwoRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapterTwoRecyclerView.setHasFixedSize(true)

        setAdapter()
    }

    private fun setAdapter() {
        overViewAdapter = OverViewAdapter(requireContext(), ArrayList())
        overAllProfitAdapter = OverAllProfitAdapter(requireContext(), ArrayList())
        adapterOneRecylerView.adapter = overViewAdapter

        adapterTwoRecyclerView.adapter = overAllProfitAdapter

        userNameTextView.text = PrefManager.getUserName(requireContext())

    }

    private fun getDashBoardServiceCall() {
        nestedScrollView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        val jsonObject = JsonObject()
        jsonObject.addProperty("CompanyCode", COMPANY_CODE)
        Log.e("Request Data", jsonObject.toString())
        val apiService = ApiClient.response?.create(ApiInterface::class.java)
        val call = apiService?.getDashBoardServiceCall(jsonObject.toString())

        call?.enqueue(object : retrofit2.Callback<DashBoardModel> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<DashBoardModel>,
                response: Response<DashBoardModel>
            ) {
                if (response.code() == 200) {
                    Log.e("Resquest Url", response.raw().request.url.toString())
                    dashBoardData = response.body() as DashBoardModel
                    totalSalesTextView.text = "$ " + response.body()?.TotalSummary?.InvoiceTotal.toString()
                    todaySalesTextView.text = "$ " + response.body()?.TotalSummary?.InvoiceTodayTotal.toString()
                    todayProductTextView.text = response.body()?.TotalSummary?.ProductTodayTotal.toString()
                    getDashBoardSummary()
                } else {
                    nestedScrollView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), response.code().toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<DashBoardModel>, t: Throwable) {
                Log.e("Error Message", t.toString())
                nestedScrollView.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }

        })

    }

    private fun getDashBoardSummary() {
        nestedScrollView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        val jsonObject = JsonObject()
        jsonObject.addProperty("CompanyCode", COMPANY_CODE)
        jsonObject.addProperty("ProductCode", "")
        jsonObject.addProperty("CategoryCode", "")
        jsonObject.addProperty("LocationCode", "HQ")
        jsonObject.addProperty("EndDate", "04/10/2021")
        Log.e("Request Data", jsonObject.toString())
        val apiService = ApiClient.response?.create(ApiInterface::class.java)
        val call = apiService?.getDashBoardSummaryServiceCall(jsonObject.toString())
        call?.enqueue(object : retrofit2.Callback<List<DashBoardSummary>> {
            override fun onFailure(call: Call<List<DashBoardSummary>>, t: Throwable) {
                nestedScrollView.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }

            override fun onResponse(
                call: Call<List<DashBoardSummary>>,
                response: Response<List<DashBoardSummary>>
            ) {
                Log.e("Request Url", response.raw().request.url.toString())
                if (response.code() == 200) {
                    var dashBoardSummary: ArrayList<DashBoardSummary> = ArrayList()
                    dashBoardSummary = response.body() as ArrayList<DashBoardSummary>
                    overViewAdapter.dashBoardSummary = dashBoardSummary
                    overViewAdapter.notifyDataSetChanged()
                    overAllProfitAdapter.dashBoardSummary = dashBoardSummary
                    overAllProfitAdapter.notifyDataSetChanged()
                    getDashBoardChartData()
                } else {
                    Toast.makeText(requireContext(), response.code().toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }

        }
        )
    }


    private fun getDashBoardChartData() {
        nestedScrollView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        val jsonObject = JsonObject()
        jsonObject.addProperty("CompanyCode", COMPANY_CODE)
        jsonObject.addProperty("ProductCode", "")
        jsonObject.addProperty("CategoryCode", "")
        jsonObject.addProperty("LocationCode", "HQ")
        jsonObject.addProperty("EndDate", "04/10/2021")
        Log.e("Request Data", jsonObject.toString())
        val apiService = ApiClient.response?.create(ApiInterface::class.java)
        val call = apiService?.getDashBoardChartDataServiceCall(jsonObject.toString())

        call?.enqueue(object : retrofit2.Callback<ChartModel> {
            override fun onResponse(call: Call<ChartModel>, response: Response<ChartModel>) {

                if (response.code() == 200) {
                    nestedScrollView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    chartModelArrayList = response.body()!!
                    initLineChartDownFill()
                } else {
                    nestedScrollView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                }

            }

            override fun onFailure(call: Call<ChartModel>, t: Throwable) {
                nestedScrollView.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
                Log.e("ChartError", t.toString())
            }

        })

    }
}