package com.winapp.retailboss.Models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ChartModel: Serializable  {

    @SerializedName("CompanyCode")
    var CompanyCode: Int? = null

    @SerializedName("DashBoardDetails")
    var DashBoardDetails: ArrayList<DashBoardSummary> = ArrayList()

    @SerializedName("DailyDetails")
    var DailyDetails : ArrayList<DailyDetails> = ArrayList()

    @SerializedName("MonthlyDetails")
    var MonthlyDetails : ArrayList<DailyDetails> = ArrayList()

    @SerializedName("YearlyDetails")
    var YearlyDetails : ArrayList<DailyDetails> = ArrayList()

    @SerializedName("WeeklyDetails")
    var WeeklyDetails : ArrayList<DailyDetails> = ArrayList()


}

class DailyDetails : Serializable {

    @SerializedName("SalesCount")
    var SalesCount: Int? = null

    @SerializedName("Hour")
    var Hour: Int? = null

    @SerializedName("NetTotal")
    var NetTotal: Double? = null

    @SerializedName("Weekly")
    var Weekly: Int? = null

    @SerializedName("Month")
    var Month: Int? = null

    @SerializedName("Year")
    var Year: Int? = null
}