package com.vividseats.android.challenge.two.data.remote.core


/**
 * A wrapper for data that is requested from a data source.
 *
 * @param status the current status ([Status.LOADING], [Status.SUCCESS], or [Status.ERROR]) of the Resource at any given
 * time.
 * @param data the object that the Resource wraps. Each [status] could have its own representation of the data.
 * @param error the [Error] that the Resource wraps in the case that the Resource has a status of [Status.ERROR].
 */
sealed class Resource<DataType> constructor(
    val status: Status,
    val data: DataType?
) {

    class Loading<DataType>(loadingData: DataType?) : Resource<DataType>(Status.LOADING, loadingData)

    class Success<DataType>(successData: DataType) : Resource<DataType>(Status.SUCCESS, successData)
}