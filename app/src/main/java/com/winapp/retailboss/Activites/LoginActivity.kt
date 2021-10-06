package com.winapp.retailboss.Activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import com.github.loadingview.LoadingDialog
import com.google.gson.JsonObject
import com.winapp.retailboss.Helpers.PrefManager
import com.winapp.retailboss.Helpers.Utils
import com.winapp.retailboss.Models.LoginModels
import com.winapp.retailboss.R
import com.winapp.retailboss.Rest.ApiClient
import com.winapp.retailboss.Rest.ApiInterface
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var loginButton:Button
    lateinit var userNameEditText:EditText
    lateinit var passwordEditText: EditText
    lateinit var loginLayout:ConstraintLayout
    lateinit var dialog: LoadingDialog
    lateinit var backButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)
        supportActionBar?.hide()
        initialiseVariable()
        buttonActionMethods()
    }

    private fun initialiseVariable(){
        userNameEditText = findViewById(R.id.editTextTextPersonName2)
        passwordEditText = findViewById(R.id.editTextTextPersonName3)
        backButton = findViewById(R.id.imageButton2)
        loginButton = findViewById(R.id.button4)
        loginLayout = findViewById(R.id.loginLayout)
    }


    private fun buttonActionMethods(){
        loginButton.setOnClickListener {
            when {
                userNameEditText.text.toString().isEmpty() -> {
                    Utils.ShowSnakBar("User Name Should not be empty", loginLayout)
                }
                passwordEditText.text.toString().isEmpty() -> {
                    Utils.ShowSnakBar("Password Should not be empty", loginLayout)
                }
                else -> {
                    getLoginServiceCall()
                }
            }
        }
        backButton.setOnClickListener {
            finish()
        }
    }

    private fun getLoginServiceCall(){
        dialog = LoadingDialog[this].show()
        val jsonObject = JsonObject()
        jsonObject.addProperty("UserName", userNameEditText.text.toString())
        jsonObject.addProperty("Password", passwordEditText.text.toString())
        Log.e("REQUEST DATA",jsonObject.toString())
        val apiService = ApiClient.response?.create(ApiInterface::class.java)
        val call = apiService?.loginServiceCall(jsonObject.toString())
        call?.enqueue(object : retrofit2.Callback<LoginModels>{
            override fun onResponse(call: Call<LoginModels>, response: Response<LoginModels>) {
             dialog.hide()
             if (response.code() == 200){
                 Log.e("Request url", response.raw().request.url.toString())
              if (response.body()?.ErrorMessage.isNullOrEmpty()){
                  PrefManager.setUserName(this@LoginActivity, response.body()?.UserName?:"")
                  startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
              }else{
                  Utils.ShowSnakBar(response.body()?.ErrorMessage?:"", loginLayout)
              }
             }else{
                 Utils.ShowSnakBar("Sorry Some thing wrong Please try again !!", loginLayout)
             }
            }

            override fun onFailure(call: Call<LoginModels>, t: Throwable) {
                dialog.hide()
                Utils.ShowSnakBar(t.toString(), loginLayout)
            }

        })
    }

}