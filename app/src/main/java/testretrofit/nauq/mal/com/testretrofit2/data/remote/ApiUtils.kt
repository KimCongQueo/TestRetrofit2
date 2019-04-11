package testretrofit.nauq.mal.com.testretrofit2.data.remote

object ApiUtils {
    val BASE_URL = "https://reqres.in/api/"
    fun getApiService() : APIService {
        return RetrofitClient.getClient(BASE_URL)!!.create(APIService::class.java)
    }
}