package com.test.kotlinProject.base

import com.test.kotlinProject.bean.EventBean
import com.test.kotlinProject.model.DataProvider
import com.test.kotlinProject.model.DataProviderImpl
import io.reactivex.rxjava3.disposables.CompositeDisposable

/**
 * Created by wangch on 2021/6/16.
 */
open class BasePresenter<V : IView<IPresenter<V>>> : IPresenter<V> {

    override lateinit var view: V
    var dataProvider: DataProvider? = DataProviderImpl()
    var compositeDisposable = CompositeDisposable()

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onDestroy() {
        dataProvider = null
        compositeDisposable.dispose()
    }

    override fun handleEvent(eventBean: EventBean) {

    }



}