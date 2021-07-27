package com.test.kotlinProject.model

import com.test.kotlinProject.bean.LoginBean
import com.test.kotlinProject.bean.ResponseBean
import com.test.kotlinProject.network.NetWorkManager
import com.test.kotlinProject.network.request.LoginRequest
import io.reactivex.rxjava3.core.Single

/**
 * Created by wangch on 2021/7/23.
 */
class DataProviderImpl : DataProvider {

    override fun login(name: String, password: String): Single<ResponseBean<LoginBean>> {
        var loginRequest = LoginRequest(name, password)
        return NetWorkManager.netWorkApi.login(loginRequest)
    }
}