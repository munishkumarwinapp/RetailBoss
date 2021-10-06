package com.winapp.retailboss.Models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class SaleModel : Serializable {

    @SerializedName("CompanyCode")
    var CompanyCode: Int? = null

    @SerializedName("InvoiceNo")
    var InvoiceNo: String? = null

    @SerializedName("InvoiceDate")
    var InvoiceDate:String? = null

    @SerializedName("ProductCode")
    var ProductCode: String? = null

    @SerializedName("ProductStatus")
    var ProductStatus:String? = null

    @SerializedName("Sold")
    var Sold:String? = null

    @SerializedName("Bought")
    var Bought:String? = null

    @SerializedName("Profit")
    var Profit:String? = null


    @SerializedName("ParentProductCode")
    var ParentProductCode: String? = null

    @SerializedName("ProductName")
    var ProductName: String? = null

    @SerializedName("LocationName")
    var LocationName: String? = null

    @SerializedName("CategoryCode")
    var CategoryCode: String? = null

    @SerializedName("CategoryText")
    var CategoryText: String? = null

    @SerializedName("SubCategoryCode")
    var SubCategoryCode: String? = null

    @SerializedName("SubCategoryText")
    var SubCategoryText: String? = null

    @SerializedName("SupplierCode")
    var SupplierCode: String? = null

    @SerializedName("SupplierText")
    var SupplierText: String? = null

    @SerializedName("UOMCode")
    var UOMCode: String? = null

    @SerializedName("UOMText")
    var UOMText: String? = null

    @SerializedName("PcsPerCarton")
    var PcsPerCarton: String? = null

    @SerializedName("WeightPrice")
    var WeightPrice: String? = null

    @SerializedName("MinimumCartonSellingPrice")
    var MinimumCartonSellingPrice: String? = null

    @SerializedName("CartonWeight")
    var CartonWeight: String? = null

    @SerializedName("HavePackage")
    var HavePackage: String? = null

    @SerializedName("Weight")
    var Weight: String? = null

    @SerializedName("Carton")
    var Carton: String? = null

    @SerializedName("BatchCarton")
    var BatchCarton: String? = null

    @SerializedName("BatchLoose")
    var BatchLoose: String? = null

    @SerializedName("UnitCost")
    var UnitCost: String? = null

    @SerializedName("TotalUnitCost")
    var TotalUnitCost: String? = null

    @SerializedName("TotalAverageCost")
    var TotalAverageCost: String? = null

    @SerializedName("AverageCost")
    var AverageCost: String? = null

    @SerializedName("RetailPrice")
    var RetailPrice: String? = null

    @SerializedName("WholeSalePrice")
    var WholeSalePrice: String? = null

    @SerializedName("HaveBatch")
    var HaveBatch: String? = null

    @SerializedName("HaveExpiry")
    var HaveExpiry: String? = null

    @SerializedName("HaveMfgDate")
    var HaveMfgDate: String? = null

    @SerializedName("WeightBarcodeAssigned")
    var WeightBarcodeAssigned: String? = null

    @SerializedName("WeightBarcodeStartsOn")
    var WeightBarcodeStartsOn: String? = null

    @SerializedName("WeightBarcodeEndsOn")
    var WeightBarcodeEndsOn: String? = null

    @SerializedName("ProductWeight")
    var ProductWeight: String? = null

    @SerializedName("NoOfCarton")
    var NoOfCarton: String? = null

    @SerializedName("LocationCode")
    var LocationCode: String? = null

    @SerializedName("BarCode")
    var BarCode: String? = null

    @SerializedName("IsActive")
    var IsActive: String? = null

    @SerializedName("CreateUser")
    var CreateUser: String? = null

    @SerializedName("CreateDate")
    var CreateDate: String? = null

    @SerializedName("CreateDateString")
    var CreateDateString: String? = null

    @SerializedName("EffectiveDate")
    var EffectiveDate: String? = null

    @SerializedName("ModifyUser")
    var ModifyUser: String? = null

    @SerializedName("ModifyDate")
    var ModifyDate: String? = null

    @SerializedName("ErrorMessage")
    var ErrorMessage: String? = null

    @SerializedName("ItemWiseTaxPercentage")
    var ItemWiseTaxPercentage: String? = null

    @SerializedName("TaxPerc")
    var TaxPerc: String? = null

    @SerializedName("NonStockItem")
    var NonStockItem: String? = null

    @SerializedName("Specification")
    var Specification: String? = null

    @SerializedName("ProductImage")
    var ProductImage: String? = null

    @SerializedName("MinimumStock")
    var MinimumStock: String? = null

    @SerializedName("Attribute_Qty")
    var Attribute_Qty: String? = null

    @SerializedName("Qty")
    var Qty: String? = null

    @SerializedName("BatchQty")
    var BatchQty: String? = null

    @SerializedName("BatchNo")
    var BatchNo: String? = null

    @SerializedName("ExpiryDate")
    var ExpiryDate: String? = null

    @SerializedName("MfgDate")
    var MfgDate: String? = null

    @SerializedName("ExpiryDateString")
    var ExpiryDateString: String? = null

    @SerializedName("MfgDateString")
    var MfgDateString: String? = null

    @SerializedName("ColorCode")
    var ColorCode: String? = null

    @SerializedName("SizeCode")
    var SizeCode: String? = null

    @SerializedName("ColorName")
    var ColorName: String? = null

    @SerializedName("SizeName")
    var SizeName: String? = null

    @SerializedName("ShowOnSelfOrderApp")
    var ShowOnSelfOrderApp: String? = null

    @SerializedName("BrandCode")
    var BrandCode: String? = null

    @SerializedName("CartonUOMCode")
    var CartonUOMCode: String? = null

    @SerializedName("CartonUOMText")
    var CartonUOMText: String? = null

    @SerializedName("BrandName")
    var BrandName: String? = null

    @SerializedName("OutletPrice")
    var OutletPrice: String? = null

    @SerializedName("Price")
    var Price: String? = null

    @SerializedName("HaveSerialNo")
    var HaveSerialNo: String? = null

    @SerializedName("BatchNoOfCarton")
    var BatchNoOfCarton: String? = null

    @SerializedName("GRADate")
    var GRADate: String? = null

    @SerializedName("GraQty")
    var GraQty: String? = null

    @SerializedName("RunQty")
    var RunQty: String? = null

    @SerializedName("RunNo")
    var RunNo: String? = null

    @SerializedName("BalanceQty ")
    var BalanceQty: String? = null

    @SerializedName("UnitPrice")
    var UnitPrice: String? = null

    @SerializedName("StockQty")
    var StockQty: String? = null
    
    @SerializedName("HaveBatchExpiry")
    var HaveBatchExpiry: String? = null

    @SerializedName("FIFOCost")
    var FIFOCost: String? = null

    @SerializedName("TotalFIFOCost")
    var TotalFIFOCost: String? = null

    @SerializedName("FromStockInHand")
    var FromStockInHand: String? = null

    @SerializedName("ToStockInHand")
    var ToStockInHand: String? = null

    @SerializedName("TranNo")
    var TranNo: String? = null

    @SerializedName("SlNo")
    var SlNo: String? = null

    @SerializedName("TranType")
    var TranType: String? = null

    @SerializedName("CQty")
    var CQty: String? = null

    @SerializedName("LQty")
    var LQty: String? = null

    @SerializedName("SOCQty")
    var SOCQty: String? = null

    @SerializedName("SOQty")
    var SOQty: String? = null

    @SerializedName("POCQty")
    var POCQty: String? = null

    @SerializedName("POQty")
    var POQty: String? = null

    @SerializedName("TotalCount")
    var TotalCount: String? = null

    @SerializedName("BrandText")
    var BrandText: String? = null

    @SerializedName("IsNegative")
    var IsNegative: String? = null

    @SerializedName("CombinedStock")
    var CombinedStock: String? = null

    @SerializedName("CartonPriceCookie")
    var CartonPriceCookie: String? = null

    @SerializedName("Havepos")
    var Havepos: String? = null

    @SerializedName("CategoryName")
    var CategoryName: String? = null

    @SerializedName("SubCategoryName")
    var SubCategoryName: String? = null

    @SerializedName("TotalCost")
    var TotalCost: String? = null

    @SerializedName("InvoiceDateString")
    var InvoiceDateString:String? = null

    @SerializedName("CartonPrice")
    var CartonPrice: String? = null

    @SerializedName("TaxCode")
    var TaxCode: String? = null

    @SerializedName("TaxType")
    var TaxType: String? = null

    @SerializedName("IsFrozen")
    var IsFrozen: String? = null

    @SerializedName("ProductImageString")
    var ProductImageString: String? = null

    @SerializedName("DepartmentName")
    var DepartmentName: String? = null

    @SerializedName("TotalStockCost")
    var TotalStockCost: String? = null

    @SerializedName("ProductImagePath")
    var ProductImagePath: String? = null

    @SerializedName("DepartmentCode")
    var DepartmentCode: String? = null

    @SerializedName("InStock")
    var InStock: String? = null

    @SerializedName("IsParentProduct")
    var IsParentProduct: String? = null

    @SerializedName("IsFastItem")
    var IsFastItem: String? = null

    @SerializedName("NeedWeightFromScale")
    var NeedWeightFromScale: String? = null

    @SerializedName("StdCartonPrice")
    var StdCartonPrice: String? = null

    @SerializedName("StdUnitPrice")
    var StdUnitPrice: String? = null

    @SerializedName("StdNewCartonPrice")
    var StdNewCartonPrice: String? = null

    @SerializedName("StdNewUnitPrice")
    var StdNewUnitPrice: String? = null

    @SerializedName("StdOutletPrice")
    var StdOutletPrice: String? = null

    @SerializedName("StdNewOutletPrice")
    var StdNewOutletPrice: String? = null

    @SerializedName("MarginPerc")
    var MarginPerc: String? = null

    @SerializedName("PromoCount")
    var PromoCount: String? = null
}