package com.vividseats.android.challenge.two.data.remote

import java.util.concurrent.TimeUnit

class HttpConstants {

    companion object {
        const val ENDPOINT = "api"
        const val TIMEOUT_IO: Long = 10_000
        val TIMEOUT_TIME_UNIT: TimeUnit = TimeUnit.MILLISECONDS
    }
}