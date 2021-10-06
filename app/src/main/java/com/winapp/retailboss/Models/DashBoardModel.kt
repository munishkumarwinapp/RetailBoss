package com.winapp.retailboss.Models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DashBoardModel : Serializable {

    @SerializedName("PurchaseSummary")
    var PurchaseSummary: String? = null

    @SerializedName("SalesSummary")
    var SalesSummary: String? = null

    @SerializedName("TotalSummary")
    var TotalSummary: TotalSummary? = TotalSummary()

}

class DashBoardSummary : Serializable {

    @SerializedName("Bought")
    var Bought: Double? = null

    @SerializedName("Sold")
    var Sold: Double? = null

    @SerializedName("Profit")
    var Profit: Double? = null

    @SerializedName("NetTotal")
    var NetTotal: Double? = null

    @SerializedName("Category")
    var Category: Double? = null

    @SerializedName("SubCategory")
    var SubCategory: Double? = null

    @SerializedName("CashIn")
    var CashIn: Double? = null

    @SerializedName("CashOut")
    var CashOut: Double? = null

    @SerializedName("TotalSalesCount")
    var TotalSalesCount: Double? = null


}


class TotalSummary :Serializable{

    @SerializedName("GRATodayTotal")
    var GRATodayTotal: Double? = null

    @SerializedName("GRAWeekTotal")
    var GRAWeekTotal: Double? = null

    @SerializedName("GRAMonthTotal")
    var GRAMonthTotal: Double? = null

    @SerializedName("GRAYearlyTotal")
    var GRAYearlyTotal: Double? = null

    @SerializedName("GRANetTotal")
    var GRANetTotal: Double? = null

    @SerializedName("GRATodayOutStanding")
    var GRATodayOutStanding: Double? = null

    @SerializedName("GRAWeekOutStanding")
    var GRAWeekOutStanding: Double? = null

    @SerializedName("GRAMonthOutStanding")
    var GRAMonthOutStanding: Double? = null

    @SerializedName("GRAYearlyOutStanding")
    var GRAYearlyOutStanding: Double? = null

    @SerializedName("GRAOutStanding")
    var GRAOutStanding: Double? = null

    @SerializedName("InvoiceTodayTotal")
    var InvoiceTodayTotal: Double? = null

    @SerializedName("InvoiceWeekTotal")
    var InvoiceWeekTotal: Double? = null

    @SerializedName("InvoiceMonthTotal")
    var InvoiceMonthTotal: Double? = null

    @SerializedName("InvoiceYearlyTotal")
    var InvoiceYearlyTotal: Double? = null

    @SerializedName("InvoiceTotal")
    var InvoiceTotal: Double? = null

    @SerializedName("InvoiceTodayOutStanding")
    var InvoiceTodayOutStanding: Double? = null

    @SerializedName("InvoiceWeekOutStanding")
    var InvoiceWeekOutStanding: Double? = null

    @SerializedName("InvoiceMonthOutStanding")
    var InvoiceMonthOutStanding: Double? = null

    @SerializedName("InvoiceYearlyOutStanding")
    var InvoiceYearlyOutStanding: Double? = null

    @SerializedName("InvoiceOutStanding")
    var InvoiceOutStanding: Double? = null

    @SerializedName("CustomerTodayTotal")
    var CustomerTodayTotal: Double? = null

    @SerializedName("CustomerWeeklyTotal")
    var CustomerWeeklyTotal: Double? = null

    @SerializedName("CustomerMonthlyTotal")
    var CustomerMonthlyTotal: Double? = null

    @SerializedName("CustomerYearlyTotal")
    var CustomerYearlyTotal: Double? = null

    @SerializedName("CustomerAllTotal")
    var CustomerAllTotal: Double? = null

    @SerializedName("ProductTodayTotal")
    var ProductTodayTotal: Double? = null

    @SerializedName("ProductWeeklyTotal")
    var ProductWeeklyTotal: Double? = null

    @SerializedName("ProductMonthlyTotal")
    var ProductMonthlyTotal: Double? = null

    @SerializedName("ProductYearlyTotal")
    var ProductYearlyTotal: Double? = null

    @SerializedName("ProductAllTotal")
    var ProductAllTotal: Double? = null

    @SerializedName("PurchaseReturnTotal")
    var PurchaseReturnTotal: Double? = null

    @SerializedName("PaymentTotal")
    var PaymentTotal: Double? = null

}