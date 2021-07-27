package com.test.kotlinProject.network

import com.test.kotlinProject.APP
import com.test.kotlinProject.R
import com.test.kotlinProject.bean.ResponseBean
import com.test.kotlinProject.bean.ResponseCode
import io.reactivex.rxjava3.observers.DisposableSingleObserver

/**
 * Created by wangch on 2021/7/23.
 */
abstract class BaseObserver<T> : DisposableSingleObserver<ResponseBean<T>>() {
    override fun onSuccess(t: ResponseBean<T>) {
        if (t.code == ResponseCode.success) {
            t.data?.let { onSucceed(t.data) }
        } else {
            onErrors(t.code, t.message)
        }
    }

    override fun onError(e: Throwable) {
        onErrors(
            ResponseCode.unDefined,
            e.message ?: APP.instance.getString(R.string.network_error)
        )
    }

 open   fun onErrors(code: Int, mse: String) {
    // TODO: 2021/7/23 判断是否需要退出登录
    }


    abstract fun onSucceed(t: T)
}

//abstract class BaseObserver<T> : DisposableSingleObserver<T>() {
//
//    override fun onSuccess(t: T) {
//        t as ResponseBean<*>
//        if (t.code == ResponseCode.success) {
//            onSucceed(t)
//        } else {
//            onErrors(t.code, t.message)
//        }
//    }
//
//    override fun onError(e: Throwable) {
//        onErrors(
//            ResponseCode.unDefined,
//            e.message ?: APP.instance.getString(R.string.network_error)
//        )
//    }
//
//    open fun onErrors(code: Int, mse: String) {
//        // TODO: 2021/7/23 判断是否需要退出登录
//    }
//
//
//    abstract fun onSucceed(t: T)
//}
