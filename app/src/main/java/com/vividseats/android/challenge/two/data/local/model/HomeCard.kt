package com.vividseats.android.challenge.two.data.local.model


data class HomeCard(var topLabel : String,
                    var middleLabel: String,
                    var bottomLabel: String,
                    var eventCount: Int,
                    var image: String,
                    var startDate: Long,
                    var rank: Int)