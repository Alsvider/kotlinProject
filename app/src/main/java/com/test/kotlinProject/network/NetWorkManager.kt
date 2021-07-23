package com.test.kotlinProject.network

import android.util.Log
import com.google.gson.GsonBuilder
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import com.test.kotlinProject.BuildConfig
import com.test.kotlinProject.utils.StringNullAdapter
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by wangch on 2021/7/22.
 */
object NetWorkManager {

    private val okHttpClient by lazy {
        val level: Level = if (BuildConfig.DEBUG) Level.BASIC else Level.NONE
        val logInterceptor = LoggingInterceptor.Builder()
            .setLevel(level)
            .tag("kotlinDemo")
            .log(Log.VERBOSE)
            .build()

        OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(logInterceptor)
            .build()
    }

    val netWorkApi: NetWorkApi by lazy {
        var gson = GsonBuilder()
            .registerTypeAdapter(String::class.java, StringNullAdapter())
            .create()

        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(NetWorkApi::class.java)
    }


}


