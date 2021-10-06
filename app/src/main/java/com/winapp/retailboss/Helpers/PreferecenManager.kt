package com.winapp.retailboss.Helpers

import android.content.Context
import android.content.SharedPreferences

object PrefManager {

    private val USER_ID = "USER_ID"
    private val USER_NAME = "USER_NAME"
    private val COMPANY_ADDRESS = "COMPANY_ADDRESS"
    private val USER_ADDRESS = "USER_ADDRESS"
    private val COMPANY_MAIL = "COMPANY_MAIL"
    private val TAX_TYPE = "TAX_TYPE"
    private val TAX_VALUE = "TAX_VALUE"
    private val COMPANY_LOGO = "COMPANY_LOGO"
    private val USER_LOGIN = "USER_LOGIN"
    private val COMPANY_NAME = "COMPANY_NAME"
    private val COMPANY_SHORT_CODE = "COMPANY_SHORT_CODE"
    private val USER_MAIL = "USER_MAIL"
    private val ADDRESS_ONE = "ADDRESS_ONE"
    private val ADDRESS_TWO = "ADDRESS_TWO"
    private val ADDRESS_THREE = "ADDRESS_THREE"
    private val CUSTOMER_CODE = "CUSTOMER_CODE"
    private val TAX_CODE = "TAX_CODE"
    private val COMPANY_PHONE_NO = "COMPANY_PHONE_NO"
    private val USER_PHONE_NO = "USER_PHONE_NO"
    private val SCANNER_VALUE = "SCANNER_VALUE"

    private fun getPref(context: Context): SharedPreferences {
        return context.getSharedPreferences("scanner",0)
    }

    // GET AND SET USER ID
    fun getUserPhoneNo(context: Context):String{
        getPref(context).getString(USER_PHONE_NO,"")?.let {
            return it
        }
        return ""
    }

    fun setUserPhoneNo(context: Context, userId:String){
        with(getPref(context).edit()) {
            putString(USER_PHONE_NO, userId)
            apply()
        }
    }

    // GET AND SET Scanner ID
    fun getScannerValue(context: Context):String{
        getPref(context).getString(SCANNER_VALUE,"")?.let {
            return it
        }
        return ""
    }

    fun setScannerValue(context: Context, userId:String){
        with(getPref(context).edit()) {
            putString(SCANNER_VALUE, userId)
            apply()
        }
    }

    // GET AND SET USER NAME
    fun getUserName(context: Context):String{
        getPref(context).getString(USER_NAME,"")?.let {
            return it
        }
        return ""
    }

    fun setUserName(context: Context, userName:String){
        with(getPref(context).edit()) {
            putString(USER_NAME, userName)
            apply()
        }
    }

    // GET AND SET ADDRESS
    fun getAddress(context: Context):String{
        getPref(context).getString(COMPANY_ADDRESS,"")?.let {
            return it
        }
        return ""
    }

    fun setAddress(context: Context, address:String){
        with(getPref(context).edit()) {
            putString(COMPANY_ADDRESS, address)
            apply()
        }
    }

    // GET AND SET ADDRESS
    fun getUserAddress(context: Context):String{
        getPref(context).getString(USER_ADDRESS,"")?.let {
            return it
        }
        return ""
    }

    fun setUserAddress(context: Context, address:String){
        with(getPref(context).edit()) {
            putString(USER_ADDRESS, address)
            apply()
        }
    }

    // GET AND SET MAIL
    fun getMailAddress(context: Context):String{
        getPref(context).getString(COMPANY_MAIL,"")?.let {
            return it
        }
        return ""
    }

    fun setMailAddress(context: Context, address:String){
        with(getPref(context).edit()) {
            putString(COMPANY_MAIL, address)
            apply()
        }
    }

    // GET AND SET MAIL
    fun getUserMailAddress(context: Context):String{
        getPref(context).getString(USER_MAIL,"")?.let {
            return it
        }
        return ""
    }

    fun setUserMailAddress(context: Context, address:String){
        with(getPref(context).edit()) {
            putString(USER_MAIL, address)
            apply()
        }
    }

    // GET AND SET MAIL
    fun getLogo(context: Context):String{
        getPref(context).getString(COMPANY_LOGO,"")?.let {
            return it
        }
        return ""
    }

    fun setLogo(context: Context, address:String){
        with(getPref(context).edit()) {
            putString(COMPANY_LOGO, address)
            apply()
        }
    }

    // GET AND SET TAX_TYPE
    fun getTaxType(context: Context):String{
        getPref(context).getString(TAX_TYPE,"")?.let {
            return it
        }
        return ""
    }

    fun setTaxType(context: Context, address:String){
        with(getPref(context).edit()) {
            putString(TAX_TYPE, address)
            apply()
        }
    }

    // GET AND SET TAX_TYPE
    fun getTaxPercentage(context: Context):String{
        getPref(context).getString(TAX_VALUE,"")?.let {
            return it
        }
        return ""
    }

    fun setTaxPercentage(context: Context, address:String){
        with(getPref(context).edit()) {
            putString(TAX_VALUE, address)
            apply()
        }
    }

    // GET AND SET TAX_TYPE
    fun getShortCode(context: Context):String{
        getPref(context).getString(COMPANY_SHORT_CODE,"")?.let {
            return it
        }
        return ""
    }

    fun setShortCode(context: Context, address:String){
        with(getPref(context).edit()) {
            putString(COMPANY_SHORT_CODE, address)
            apply()
        }
    }

    // GET AND SET USER_LOGIN
    fun getUserLogin(context: Context):String{
        getPref(context).getString(USER_LOGIN,"")?.let {
            return it
        }
        return ""
    }

    fun setUserLogin(context: Context, address:String){
        with(getPref(context).edit()) {
            putString(USER_LOGIN, address)
            apply()
        }
    }

    // GET AND SET COMPANY_NAME
    fun getCompanyName(context: Context):String{
        getPref(context).getString(COMPANY_NAME,"")?.let {
            return it
        }
        return ""
    }

    fun setCompanyName(context: Context, address:String){
        with(getPref(context).edit()) {
            putString(COMPANY_NAME, address)
            apply()
        }
    }

    // GET AND SET ADDRESS 1
    fun getAddressOne(context: Context):String{
        getPref(context).getString(ADDRESS_ONE,"")?.let {
            return it
        }
        return ""
    }

    fun setAddressOne(context: Context, address:String){
        with(getPref(context).edit()) {
            putString(ADDRESS_ONE, address)
            apply()
        }
    }

    // GET AND SET ADDRESS 2
    fun getAddressTwo(context: Context):String{
        getPref(context).getString(ADDRESS_TWO,"")?.let {
            return it
        }
        return ""
    }

    fun setAddressTwo(context: Context, address:String){
        with(getPref(context).edit()) {
            putString(ADDRESS_TWO, address)
            apply()
        }
    }

    // GET AND SET ADDRESS 3
    fun getAddressThree(context: Context):String{
        getPref(context).getString(ADDRESS_THREE,"")?.let {
            return it
        }
        return ""
    }

    fun setAddressThree(context: Context, address:String){
        with(getPref(context).edit()) {
            putString(ADDRESS_THREE, address)
            apply()
        }
    }

    // GET AND SET CUSTOMER CODE
    fun getCustomerCode(context: Context):String{
        getPref(context).getString(CUSTOMER_CODE,"")?.let {
            return it
        }
        return ""
    }

    fun setCustomerCode(context: Context, address:String) {
        with(getPref(context).edit()) {
            putString(CUSTOMER_CODE, address)
            apply()
        }

    }
}