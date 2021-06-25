package com.test.kotlinProject.base

import android.content.Context
import android.os.Bundle
import com.test.kotlinProject.bean.EventBean

/**
 * Created by wangch on 2021/6/16.
 */
abstract class BaseMVPActivity<P : BasePresenter<IView<P>>> : BaseActivity(), IView<P> {
    override lateinit var presenter: P
    override lateinit var contex: Context
    override lateinit var activity: BaseActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this
        contex = this
        presenter = createPresenter()
        presenter.view = this
    }

    override fun getLayoutId(): Int? {
        return setLayoutID()
    }


    abstract fun setLayoutID(): Int

    abstract fun createPresenter(): P


    override fun handleEvent(eventBean: EventBean) {
        super.handleEvent(eventBean)
        presenter.handleEvent(eventBean)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }


}