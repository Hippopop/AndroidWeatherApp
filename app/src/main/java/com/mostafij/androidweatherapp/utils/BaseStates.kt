package com.mostafij.androidweatherapp.utils


enum class BaseState {
    ERROR, LOADING, SUCCESS,
}

data class BaseError(val msg: String, val code: Int) {
    companion object {
        val unknownBaseError = BaseError("Something went wrong, please try again!", 400);
    }
}

