package testretrofit.nauq.mal.com.testretrofit2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Response
import testretrofit.nauq.mal.com.testretrofit2.data.model.User
import testretrofit.nauq.mal.com.testretrofit2.data.remote.APIService
import testretrofit.nauq.mal.com.testretrofit2.data.remote.ApiUtils
import javax.security.auth.callback.Callback

class LoginActivity: AppCompatActivity()  {
    var mAPIService : APIService = ApiUtils.getApiService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin?.setOnClickListener{
            val user = edtUsername.text.toString()
            val pass = edtPassword.text.toString()
            if(!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass)){
                login("peter@klaven", "cityslicka")
            }
        }
    }

    private fun login(user: String, pass: String) {
        mAPIService.login(user, pass).enqueue(object :retrofit2.Callback<User> {
            override fun onFailure(call: Call<User>?, t: Throwable?) {
                Log.e("aaaaaaaaa", "Unable to submit post to API.")
            }

            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                if(response!!.isSuccessful){
//                    Toast.makeText(this@LoginActivity, response.body().token.toString(), Toast.LENGTH_LONG ).show()
                    if(response.body().token != null){
                        val i : Intent
                        i = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(i)
                        finish()
                    }
                }
            }

        })
    }
}
