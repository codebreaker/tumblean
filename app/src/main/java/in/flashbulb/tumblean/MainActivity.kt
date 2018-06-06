package `in`.flashbulb.tumblean

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tumblr.loglr.Interfaces.ExceptionHandler
import com.tumblr.loglr.Interfaces.LoginListener
import com.tumblr.loglr.LoginResult
import com.tumblr.loglr.Loglr

class MainActivity : AppCompatActivity(), LoginListener, ExceptionHandler {
    override fun onLoginFailed(runtimeException: RuntimeException) {
        Log.e("MainActivity","error "+runtimeException.localizedMessage)
    }

    override fun onLoginSuccessful(loginResult: LoginResult) {
        Log.e("MainActivity","login result = "+loginResult.getOAuthToken());
        prefs.oAuthToken = loginResult.getOAuthToken()
        prefs.oAuthTokenSecret = loginResult.getOAuthTokenSecret()
        var home = Intent(this@MainActivity,HomeActivity::class.java)
                startActivity(home)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //(application as Application).tumblrClient
        Loglr.setConsumerKey("d3J8T1d6q1AZrcEBc3MS2RY0yAg9jPZbFdlg4hzrm9f8UGa5mG")
                ?.setConsumerSecretKey("XsmLGRZvZZeONhuIBAa7ZdLCH0HNFFEK0wojILjW5lipH4PBmo")
                ?.setLoginListener(this@MainActivity)
                ?.setExceptionHandler(this@MainActivity/**/)
                ?.setUrlCallBack("http://flashbulb.in/")
                ?.initiate(this@MainActivity)
    }
}
