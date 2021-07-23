package com.test.kotlinProject.ui.login

import com.test.kotlinProject.base.BasePresenter
import com.test.kotlinProject.base.IPresenter
import com.test.kotlinProject.bean.LoginBean
import com.test.kotlinProject.bean.ResponseBean
import com.test.kotlinProject.extension.Schedule
import com.test.kotlinProject.network.BaseObserver
import com.test.kotlinProject.network.NetWorkManager
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Created by wangch on 2021/6/28.
 */
class LoginPresenter: BasePresenter<ILoginView>(),ILoginPresenter {
    override fun login(name: String, password: String) {
        val map = mapOf("name" to name)
        NetWorkManager.netWorkApi.login(map)
            .compose{
                it.Schedule() }
            .subscribeWith(object :BaseObserver<ResponseBean<LoginBean>>() {

                override fun onSucceed(t: ResponseBean<LoginBean>) {
                }

                override fun onErrors(code: Int, mse: String) {
                    super.onErrors(code, mse)
                }


            })

    }

}




