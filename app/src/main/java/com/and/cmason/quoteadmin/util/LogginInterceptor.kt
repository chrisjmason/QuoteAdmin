package com.and.cmason.quoteadmin.util

/**
 * Created by cmason on 15/02/2018.
 */
import android.util.Log

import java.io.IOException


import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody

class LoggingInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val t1 = System.nanoTime()
        Log.d(TAG, String.format("Sending request %s with %s",
                request.url(), request.headers()))

        val response = chain.proceed(request)

        val t2 = System.nanoTime()
        Log.d(TAG, String.format("Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6, response.headers()))

        val responseString = String(response.body()!!.bytes())

        Log.d(TAG, "Response: " + responseString)

        return response.newBuilder()
                .body(ResponseBody.create(response.body()!!.contentType(), responseString))
                .build()
    }

    companion object {
        private val TAG = "HTTP Request"
    }
}