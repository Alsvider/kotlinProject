package com.test.kotlinProject.network.request

import com.test.kotlinProject.base.BaseRequest

/**
 * Created by wangch on 2021/7/27.
 */
class LoginRequest(name: String,password:String) :BaseRequest(true){
    init {
        put("name",name)
        put("password",password)
    }
}