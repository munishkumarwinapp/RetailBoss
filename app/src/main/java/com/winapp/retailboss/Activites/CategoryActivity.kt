package com.winapp.retailboss.Activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.JsonObject
import com.winapp.retailboss.Adapters.CategoryAdapter
import com.winapp.retailboss.Helpers.Utils
import com.winapp.retailboss.Models.CategoryModel
import com.winapp.retailboss.Models.SaleModel
import com.winapp.retailboss.R
import com.winapp.retailboss.Rest.ApiClient
import com.winapp.retailboss.Rest.ApiInterface
import com.winapp.retailboss.Rest.COMPANY_CODE
import retrofit2.Call
import retrofit2.Response

class CategoryActivity : AppCompatActivity() {

    lateinit var categoryAdapter: CategoryAdapter
    lateinit var categoryRecyclerView: RecyclerView
    lateinit var progressBar:ProgressBar
    var categoryArrayList:ArrayList<CategoryModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
//        supportActionBar?.title = "Category"
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.hide()
        initComponent()
        getCategoryServiceCall()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

    private fun initComponent() {

        categoryRecyclerView = findViewById(R.id.categoryRecyclerVIew)
        progressBar = findViewById(R.id.progressBar2)
        categoryRecyclerView.layoutManager = LinearLayoutManager(this@CategoryActivity)
        categoryRecyclerView.setHasFixedSize(true)
        setAdapter()

    }

    private fun setAdapter() {
        categoryAdapter = CategoryAdapter(this@CategoryActivity,categoryArrayList)
        categoryRecyclerView.adapter = categoryAdapter
    }

    private fun getCategoryServiceCall(){
        categoryRecyclerView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        val jsonObject = JsonObject()
        jsonObject.addProperty("CompanyCode", COMPANY_CODE)
        jsonObject.addProperty("CategoryCode", "")
        jsonObject.addProperty("LocationCode", "HQ")
        jsonObject.addProperty("ProductCode", "")
        jsonObject.addProperty("StartDate", "01/01/2021")
        jsonObject.addProperty("EndDate", "28/09/2021")
        Log.e("Request Data",jsonObject.toString())
        val apiService = ApiClient.response?.create(ApiInterface::class.java)
        val call = apiService?.getCategoryServiceCall(jsonObject.toString())
        call?.enqueue(object : retrofit2.Callback<List<CategoryModel>> {
            override fun onResponse(call: Call<List<CategoryModel>>, response: Response<List<CategoryModel>>) {
                Log.e("Status Code", response.code().toString())
                if (response.code() == 200){
                    categoryRecyclerView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    categoryArrayList = response.body() as ArrayList<CategoryModel>
                    categoryAdapter.categoryArrayList = categoryArrayList
                    categoryAdapter.notifyDataSetChanged()

                }else{
                    categoryRecyclerView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                }

            }

            override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                categoryRecyclerView.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }

        })
    }

}