package com.test.kotlinProject.bean

/**
 * Created by wangch on 2021/7/23.
 */
class ResponseBean<T> (
    val code: Int = ResponseCode.unDefined,
    val message:String="",
    val data:T?
)

object ResponseCode {
    const val success = 0
    const val error = -100
    const val unDefined=-1000
}