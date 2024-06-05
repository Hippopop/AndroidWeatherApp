package com.mostafij.androidweatherapp.data.model

import com.google.gson.annotations.SerializedName

data class ConditionData(
    @SerializedName("text") val text: String?,
    @SerializedName("icon") val icon: String?,
    @SerializedName("code") val code: Int?,
)