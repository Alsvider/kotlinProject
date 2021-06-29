package com.test.kotlinProject.ui.login

import com.test.kotlinProject.base.IPresenter
import com.test.kotlinProject.base.IView

/**
 * Created by wangch on 2021/6/28.
 */

interface ILoginView :IView<ILoginPresenter>{

}

interface ILoginPresenter:IPresenter<ILoginView>{

}