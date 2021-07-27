package com.test.kotlinProject.model

import com.test.kotlinProject.bean.LoginBean
import com.test.kotlinProject.bean.ResponseBean
import io.reactivex.rxjava3.core.Single

/**
 * Created by wangch on 2021/7/23.
 */
interface DataProvider{

    fun login(name: String,password:String):Single<ResponseBean<LoginBean>>

}