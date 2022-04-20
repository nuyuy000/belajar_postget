package com.example.taskday7_8.model

import com.example.taskday7_8.LoginRequest
import com.example.taskday7_8.LoginResponse
import com.example.taskday7_8.RegisterRequest
import com.example.taskday7_8.RegisterResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST("auth/register")
    fun postRegister(@Body request: RegisterRequest): Call<RegisterResponse>

    @POST("auth/login")
    fun postLogin(@Body request: LoginRequest): Call<LoginResponse>

    @Multipart
    @PUT("users")
    fun putUser(@Header("Authorization") token: String,
                @Part("username") username: RequestBody,
                @Part("email") email: RequestBody,
                @Part("photo") photo: MultipartBody.Part)

}