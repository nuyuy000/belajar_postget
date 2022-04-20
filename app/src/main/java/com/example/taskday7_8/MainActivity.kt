package com.example.taskday7_8

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.taskday7_8.databinding.ActivityMainBinding
import com.example.taskday7_8.model.ApiClient
import com.example.taskday7_8.model.ProfileActivity
import com.example.taskday7_8.model.RegistrasiActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
        var sharedPreference: SharedPreferences? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            sharedPreference = getSharedPreferences("SHARED_FILE", Context.MODE_PRIVATE)

            val token = sharedPreference?.getString("token","")
            if (token != ""){
              (token.toString())
            }


            binding.btnRegis.setOnClickListener {
                val intent = Intent(this, RegistrasiActivity::class.java)
                startActivity(intent)
            }

            binding.apply {
                btnLogin.setOnClickListener {
                    val email = etEmail.text.toString()
                    val password = etPassword.text.toString()
                    val loginRequest = LoginRequest(email, password)
                    postLogin(loginRequest)
                }
            }

        }

//        private fun authMe(token:String){
//            ApiClient.instance.authMe("Bearer $token").enqueue(object : Callback<AuthResponse> {
//                override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
//                    val code = response.code()
//                    if (code == 200){
//                        Toast.makeText(this@MainActivity, "login sukses", Toast.LENGTH_SHORT).show()
//                        val intent = Intent(this@MainActivity, ProfileActivity::class.java)
//                        startActivity(intent)
//                        finish()
//
//                    }
                }
//
//                override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
//
//                }
//            })
        }

        private fun postLogin(request: LoginRequest){
            ApiClient.instance.postLogin(request).enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    val code = response.code()
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

                }
            })
        }
