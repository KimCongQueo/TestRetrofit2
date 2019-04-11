package testretrofit.nauq.mal.com.testretrofit2.data.remote

import retrofit2.Call
import retrofit2.http.*
import testretrofit.nauq.mal.com.testretrofit2.data.model.Result
import testretrofit.nauq.mal.com.testretrofit2.data.model.User

public interface APIService {
    @POST("login")
    @FormUrlEncoded
    fun login(@Field("email") email : String,
                 @Field("password") password : String) : Call<User>
    @GET("users")
    fun getList(@Query("page") page: Int?) : Call<Result>
}