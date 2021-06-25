package com.test.kotlinProject.base

import android.content.Context
import android.os.Bundle

/**
 * Created by wangch on 2021/6/25.
 */

abstract class BaseMvpFragment<P:IPresenter<IView<P>>>:BaseFragment(),IView<P> {

    override lateinit var presenter: P
    override lateinit var contex: Context
    override lateinit var activity: BaseActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity=requireActivity() as BaseActivity
        presenter = createPresenter()

        presenter.view = this
    }

    abstract fun createPresenter(): P


    override fun onDestroy() {
        super.onDestroy()
    }
}