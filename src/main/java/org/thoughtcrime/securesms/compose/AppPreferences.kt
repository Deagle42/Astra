package org.thoughtcrime.securesms.compose

object AppPreferences {
    var isDarkMode: Boolean = false
    var fontSize: Int = 16
    fun getTheme(): String = "default"
}
