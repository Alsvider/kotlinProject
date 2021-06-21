package com.test.kotlinProject.base

import android.content.Context

/**
 * Created by wangch on 2021/6/16.
 */
interface IView<out P : IPresenter<IView<P>>> {
    val presenter: P

    var context:Context


}

interface IPresenter<out V : IView<IPresenter<V>>> {
    val view: V
}
