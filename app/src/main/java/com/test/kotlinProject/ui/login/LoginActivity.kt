package com.test.kotlinProject.ui.login

import android.view.View
import android.widget.Toast
import com.test.kotlinProject.APP
import com.test.kotlinProject.R
import com.test.kotlinProject.base.BaseMVPActivity
import com.test.kotlinProject.databinding.ActivityLoginBinding

/**
 * Created by wangch on 2021/6/28.
 */
class LoginActivity : BaseMVPActivity<ILoginPresenter>(), ILoginView {
    private lateinit var loginBinding:ActivityLoginBinding
    override fun setLayoutID(): Int {
        return R.layout.activity_login
    }

    override fun createPresenter(): ILoginPresenter {
        return LoginPresenter()
    }

    override fun initData() {
        super.initData()

         loginBinding = ActivityLoginBinding.bind(binding.root)
    }

    override fun initListener() {
        super.initListener()
        loginBinding.login.setOnClickListener {
            Toast.makeText(APP.instance,"点我了",Toast.LENGTH_SHORT).show()
        }
        loginBinding.login.text="你好"
    }


}