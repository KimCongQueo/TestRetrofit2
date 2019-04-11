package testretrofit.nauq.mal.com.testretrofit2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import testretrofit.nauq.mal.com.testretrofit2.data.UserAdapter
import testretrofit.nauq.mal.com.testretrofit2.data.model.Result
import testretrofit.nauq.mal.com.testretrofit2.data.model.User
import testretrofit.nauq.mal.com.testretrofit2.data.model.Users
import testretrofit.nauq.mal.com.testretrofit2.data.remote.APIService
import testretrofit.nauq.mal.com.testretrofit2.data.remote.ApiUtils
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    var mAPIService = ApiUtils.getApiService()
    var mData : ArrayList<Users>? =  ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcList.layoutManager = LinearLayoutManager(this)
        rcList.adapter
        mAPIService.getList(2).enqueue(object : retrofit2.Callback<Result>{
            override fun onResponse(call: Call<Result>?, response: Response<Result>?) {
                if(response!!.isSuccessful){
                    Toast.makeText(this@MainActivity, response.body().data?.get(1).toString(), Toast.LENGTH_LONG ).show()
                    response.body().data?.let {
                        mData?.addAll(response.body().data!!)
                        rcList.adapter = UserAdapter(mData , this@MainActivity)
                    }
                }
            }

            override fun onFailure(call: Call<Result>?, t: Throwable?) {
                Log.e("aaaaaaaaa", "Unable to submit post to API.")
            }

        })
    }
}
