package com.test.kotlinProject.network

import com.test.kotlinProject.bean.ResponseBean
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by wangch on 2021/7/22.
 */
interface NetWorkApi {
@POST("test/login")
fun login(@Body map: Map<String, String>):Single<ResponseBean<LoginBean>>
}