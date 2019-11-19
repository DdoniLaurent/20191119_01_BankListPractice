package com.tioeun.a20191119_01_banklistpractice.utils

import android.content.Context
import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ServerUtil {

    interface JonResponseHandler {
        fun onResponse(json: JSONObject)
    }

    companion object {

        var BASE_URL = "http://192.168.0.26:5000"

        fun getRequestBankList(context: Context, handler: JonResponseHandler) {
            var client = OkHttpClient()

            var uriBuilder = HttpUrl.parse("${BASE_URL}/info/bank")!!.newBuilder()

//            파라미터 첨부가 필요없다.
//            uriBuilder.addEncodedQueryParameter()

//            intent와 비슷한 개념. 어디로 갈지 세팅 완료
//            실제 출발은 아직 안함
            val requestUrl = uriBuilder.build().toString()
            val request = Request.Builder()
                .url(requestUrl)
                .build()

            client.newCall(request).enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("서버통신실패", e.localizedMessage)
                }

                override fun onResponse(call: Call, response: Response) {
                    val body = response.body()!!.string()
                    val json = JSONObject(body)
                    handler?.onResponse(json)
                }

            })

        }


        fun getRequestCompanyList(context: Context, handler: JonResponseHandler) {
            var client = OkHttpClient()

            var uriBuilder = HttpUrl.parse("${BASE_URL}/info/company")!!.newBuilder()

//            파라미터 첨부가 필요없다.
//            uriBuilder.addEncodedQueryParameter()

//            intent와 비슷한 개념. 어디로 갈지 세팅 완료
//            실제 출발은 아직 안함
            val requestUrl = uriBuilder.build().toString()
            val request = Request.Builder()
                .url(requestUrl)
                .build()

            client.newCall(request).enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("서버통신실패", e.localizedMessage)
                }

                override fun onResponse(call: Call, response: Response) {
                    val body = response.body()!!.string()
                    val json = JSONObject(body)
                    handler?.onResponse(json)
                }

            })

        }


    }
}