package com.smartplanner.Utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtil {

	fun millisToFormattedDate(millis: Long): String {
		val formatter = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
		return formatter.format(Date(millis))
	}
}