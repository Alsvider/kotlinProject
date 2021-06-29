package com.test.kotlinProject.base

import com.test.kotlinProject.bean.EventBean

/**
 * Created by wangch on 2021/6/16.
 */
open class BasePresenter<V:IView<IPresenter<V>>>: IPresenter<V> {

 override lateinit var view:V


 override fun onResume() {
 }

 override fun onPause() {
 }

 override fun onDestroy() {

 }

 override fun handleEvent(eventBean: EventBean) {

 }
}