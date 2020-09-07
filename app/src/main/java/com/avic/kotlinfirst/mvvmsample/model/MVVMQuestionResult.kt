package com.avic.kotlinfirst.mvvmsample.model

import com.google.gson.annotations.SerializedName

data class MVVMQuestionResult(
    @SerializedName("code") var code: String = "",
    @SerializedName("msg") var msg: String = "",
    @SerializedName("data") var data: List<MVVMResultData> = emptyList()
)

data class MVVMResultData(
    @SerializedName("queId") var queId: Int = 0,
    @SerializedName("title") var title: String = "",
    @SerializedName("publicTime") var publicTime: Long = 0L,
    @SerializedName("modiftyTime") var modifyTime: Long = 0L,
    @SerializedName("imgs") var imgs: String = ""
)