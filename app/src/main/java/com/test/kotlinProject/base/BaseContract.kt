package com.test.kotlinProject.base

import android.app.Activity
import android.content.Context
import com.test.kotlinProject.bean.EventBean

/**
 * Created by wangch on 2021/6/16.
 */
interface IView<out P : IPresenter<IView<P>>> {

    var presenter: @UnsafeVariance P

    var contex:Context

    var activity:BaseActivity

}

interface IPresenter<out V : IView<IPresenter<V>>> {
    var view: @UnsafeVariance V
    fun handleEvent(eventBean: EventBean)  //eventbus 事件回调
    fun  onResume()
    fun  onPause()
    fun  onDestroy()
}
