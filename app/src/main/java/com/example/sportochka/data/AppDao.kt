package com.example.sportochka.data

import com.google.gson.JsonObject
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface AppDao {

    @GET("profile")
    suspend fun getProfile(@Header("Authorization") token: String): AllOutProfile

    @POST("profile/add_friend")
    suspend fun addFriend(@Header("Authorization") token: String, @Query("q") name: String)

    @POST("profile/update_coords")
    suspend fun updateCoordinats(@Header("Authorization") token: String, @Body coords: JsonObject)

    @POST("profile/update")
    suspend fun updateMyCoordinats(@Header("Authorization") token: String, @Body profile: JsonObject)

    companion object {
        const val BASE_URL = "http://192.168.234.30:8082"
    }
}