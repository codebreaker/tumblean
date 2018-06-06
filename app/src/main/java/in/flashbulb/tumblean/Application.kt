package `in`.flashbulb.tumblean

import `in`.flashbulb.tumblean.util.Prefs
import com.tumblr.jumblr.JumblrClient

/**
 * Created by sruthi on 4/29/18.
 */
class Application:android.app.Application(){
    private val CONSUMER_SECRET = "XsmLGRZvZZeONhuIBAa7ZdLCH0HNFFEK0wojILjW5lipH4PBmo"
    private val CONSUMER_KEY = "d3J8T1d6q1AZrcEBc3MS2RY0yAg9jPZbFdlg4hzrm9f8UGa5mG"
    companion object {
        var prefs:Prefs? = null
        var tumblrClient:JumblrClient? = null
    }

    lateinit var tumblrClient: JumblrClient
    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
        tumblrClient = JumblrClient(CONSUMER_KEY,CONSUMER_SECRET);
    }

    fun updateOAuthToken(){
//        tumblrClient.setToken()
    }

}
val prefs:Prefs by lazy {
    Application.prefs!!
}

val tumblrClient:JumblrClient by lazy {
    Application.tumblrClient!!
}