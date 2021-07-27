package com.test.kotlinProject.ui.login
import com.test.kotlinProject.base.BasePresenter
import com.test.kotlinProject.bean.LoginBean
import com.test.kotlinProject.extension.Schedule
import com.test.kotlinProject.network.BaseObserver

/**
 * Created by wangch on 2021/6/28.
 */
class LoginPresenter: BasePresenter<ILoginView>(),ILoginPresenter {
    override fun login(name: String, password: String) {
        dataProvider?.let {
           it. login(name,password)
                .compose{
                    it.Schedule() }
                .subscribeWith(object : BaseObserver<LoginBean>(){

                    override fun onSucceed(loginBean: LoginBean) {
                        TODO("Not yet implemented")
                    }
                    override fun onErrors(code: Int, mse: String) {
                        super.onErrors(code, mse)
                    }


                })
        }




    }

}




