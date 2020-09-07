package com.avic.kotlinfirst.mvpsample.data

import com.google.gson.annotations.SerializedName

data class QuestionResult(
    @SerializedName("code") var code: String = "",
    @SerializedName("msg") var msg: String = "",
    @SerializedName("data") var data: List<ResultData> = emptyList()
)

data class ResultData(
    @SerializedName("queId") var queId: Int = 0,
    @SerializedName("title") var title: String = "",
    @SerializedName("publicTime") var publicTime: Long = 0L,
    @SerializedName("modiftyTime") var modifyTime: Long = 0L,
    @SerializedName("imgs") var imgs: String = ""
)