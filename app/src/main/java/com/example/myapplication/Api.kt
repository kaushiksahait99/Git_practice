package com.example.myapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @POST("posts")
    fun inputData(
      @Body request: Request
    ): Call<Response>
    /*{
    "title": "fool",
    "body": "bar",
    "userId": 1
}*/
}