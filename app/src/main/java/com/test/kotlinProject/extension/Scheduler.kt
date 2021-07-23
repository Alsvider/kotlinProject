package com.test.kotlinProject.extension

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Created by wangch on 2021/7/23.
 */

fun<T> Single<T>.Schedule()=subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())