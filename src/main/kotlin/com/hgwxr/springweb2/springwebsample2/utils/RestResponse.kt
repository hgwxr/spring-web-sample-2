package com.hgwxr.springweb2.springwebsample2.utils

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import java.io.Serializable
import java.util.*

class RestResponse(
    code: Int, private var message: String?,//不为空时,返回
    @JsonInclude(JsonInclude.Include.NON_NULL) //不为空时,返回
    private var data: Any?
) : Serializable {


    private var status = code

    /**
     * 时间戳并格式化
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "lz", timezone = "GMT+8")
    private var timestamp: Date? = null

    /**
     * 程序耗时
     */
    //@JsonIgnore//不返回注解
    private var time: Long = 0

    companion object {
        val serialVersionUID = 1L
        val STATUS_SUCCESS = 200
        fun buildSuccess(data: Any?): RestResponse {
            return RestResponse(STATUS_SUCCESS, "success", data)
        }
    }

//    public static RestResponse buildError(Object data) {
//        return new RestResponse(STATUS_SUCCESS, "success", data);
//    }

    //    public static RestResponse buildError(Object data) {
    //        return new RestResponse(STATUS_SUCCESS, "success", data);
    //    }
    fun getStatus(): Int {
        return status
    }

    fun setStatus(status: Int) {
        this.status = status
    }

    fun getData(): Any? {
        return data
    }

    fun setData(data: Any?) {
        this.data = data
    }

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String?) {
        this.message = message
    }

    fun getTimestamp(): Date? {
        return Date()
    }

    fun setTimestamp(timestamp: Date?) {
        this.timestamp = timestamp
    }

    fun getTime(): String? {
        return time.toString() + "ms"
    }

    fun setTime(time: Long) {
        this.time = time
    }
}