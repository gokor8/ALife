package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.mapper

import android.text.format.DateUtils
import com.alife.core.mapper.Mapper
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

interface BaseDateAgoFormatMapper : Mapper<Date, String>

class DateAgoFormatMapper @Inject constructor() : BaseDateAgoFormatMapper {

    override fun map(inputModel: Date): String {
        return DateUtils.getRelativeTimeSpanString(
            inputModel.time,
            Calendar.getInstance().timeInMillis,
            DateUtils.MINUTE_IN_MILLIS
        ).toString()
    }
}