package com.winapp.retailboss.Models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class LoginModels : Serializable {

    @SerializedName("UserName")
    var UserName:String? = null

    @SerializedName("RoleName")
    var RoleName:String? = null

    @SerializedName("CompanyCode_Byte")
    var CompanyCode_Byte:String? = null

    @SerializedName("LocationCode")
    var LocationCode:String? = null

    @SerializedName("IsUserPermission")
    var IsUserPermission:String? = null

    @SerializedName("NoLocation")
    var NoLocation:String? = null

    @SerializedName("ElligibleShowCost")
    var ElligibleShowCost:String? = null

    @SerializedName("UserId")
    var UserId:String? = null

    @SerializedName("IsMainLocation")
    var IsMainLocation:String? = null

    @SerializedName("CompanyCode")
    var CompanyCode:String? = null

    @SerializedName("CompanyName")
    var CompanyName:String? = null

    @SerializedName("Address1")
    var Address1:String? = null

    @SerializedName("Address2")
    var Address2:String? = null

    @SerializedName("Address3")
    var Address3:String? = null

    @SerializedName("ErrorMessage")
    var ErrorMessage:String? = null

}