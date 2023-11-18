package org.adilanur.challenge02.sharedpref

import android.content.Context

class SharedPreference(context: Context) {
    private val sharedPreference = "sharedpref"
    private var preferences = context.getSharedPreferences(sharedPreference, 0)

    fun setPreferences(isGrid: Boolean) {
        preferences.edit().putBoolean("IS_GRID", isGrid).apply()
    }

    fun getPreferences(): Boolean {
        return preferences.getBoolean("IS_GRID", true)
    }

}