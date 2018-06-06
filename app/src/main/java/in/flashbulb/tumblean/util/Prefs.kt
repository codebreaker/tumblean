package `in`.flashbulb.tumblean.util

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by sruthi on 3/17/18.
 */
class Prefs(context: Context) {
    val PREFS_FILENAME = "in.flashbulb.tumblean.pref"
    val OAUTH_TOKEN = "oauth_token"
    val OAUTH_TOKEN_SECRET = "oauth_token_secret"

    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0);

    var oAuthToken:String
        get() = prefs.getString(OAUTH_TOKEN,null)
        set(value) = prefs.edit().putString(OAUTH_TOKEN,value).apply()
    var oAuthTokenSecret:String
        get() = prefs.getString(OAUTH_TOKEN_SECRET,null)
        set(value) = prefs.edit().putString(OAUTH_TOKEN_SECRET,value).apply()



}