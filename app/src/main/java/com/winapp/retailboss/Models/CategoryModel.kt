package com.winapp.retailboss.Models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CategoryModel : Serializable {

    @SerializedName("InvoiceNo")
    var InvoiceNo: String? = null

    @SerializedName("InvoiceDate")
    var InvoiceDate: String? = null

    @SerializedName("slNo")
    var slNo: String? = null

    @SerializedName("CompanyCode")
    var CompanyCode: String? = null

    @SerializedName("ProductStatus")
    var ProductStatus: String? = null

    @SerializedName("ProductCode")
    var ProductCode: String? = null

    @SerializedName("LocationCode")
    var LocationCode: String? = null

    @SerializedName("ProductName")
    var ProductName: String? = null

    @SerializedName("Qty")
    var Qty: String? = null

    @SerializedName("LQty")
    var LQty: String? = null

    @SerializedName("CQty")
    var CQty: String? = null

    @SerializedName("Sold")
    var Sold: String? = null

    @SerializedName("Profit")
    var Profit: String? = null

    @SerializedName("Bought")
    var Bought: String? = null

    @SerializedName("SubTotal")
    var SubTotal: String? = null

    @SerializedName("PcsPerCarton")
    var PcsPerCarton: String? = null

    @SerializedName("UnitCost")
    var UnitCost: String? = null

    @SerializedName("AverageCost")
    var AverageCost: String? = null

    @SerializedName("CreateUser")
    var CreateUser: String? = null

    @SerializedName("CreateDate")
    var CreateDate: String? = null

    @SerializedName("ModifyUser")
    var ModifyUser: String? = null

    @SerializedName("ModifyDate")
    var ModifyDate: String? = null

    @SerializedName("ErrorMessage")
    var ErrorMessage: String? = null

    @SerializedName("CategoryCode")
    var CategoryCode: String? = null

    @SerializedName("CategoryName")
    var CategoryName: String? = null

    @SerializedName("CustomerCode")
    var CustomerCode: String? = null

}