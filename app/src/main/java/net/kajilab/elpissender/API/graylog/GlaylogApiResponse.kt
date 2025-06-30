package net.kajilab.elpissender.API.graylog

import android.util.Log
import net.kajilab.elpissender.entity.LogData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GlaylogApiResponse {
    fun sendLog(logData: LogData){
        GlaylogRetrofitClient.instance.sendLog(logData).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Log.d("Retrofit", "Log sent successfully")
                } else {
                    Log.e("Retrofit", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.e("Retrofit", "Request failed: ${t.message}")
            }
        })
    }
}
