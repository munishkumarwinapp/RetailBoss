package com.winapp.retailboss.Rest

import com.winapp.retailboss.Models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("Account/SignIn")
    fun loginServiceCall(@Query("Requestdata") Requestdata:String?) :Call<LoginModels>

    @GET("SalesApi/GetProfitByProductWiseSummaryData")
    fun getSaleOrderServiceCall(@Query("Requestdata") Requestdata:String?) :Call<List<SaleModel>>

    @GET("SalesApi/GetProfitByCategorySummaryData")
    fun getCategoryServiceCall(@Query("Requestdata") Requestdata:String?) :Call<List<CategoryModel>>

    @GET("SalesApi/GetPOSDashBoard_All")
    fun getDashBoardServiceCall(@Query("Requestdata") Requestdata:String?) :Call<DashBoardModel>

    @GET("SalesApi/GetDashboardSummaryData")
    fun getDashBoardSummaryServiceCall(@Query("Requestdata") Requestdata:String?) :Call<List<DashBoardSummary>>


    @GET("SalesApi/GetDashBoardChartData")
    fun getDashBoardChartDataServiceCall(@Query("Requestdata") Requestdata:String?) :Call<ChartModel>
}