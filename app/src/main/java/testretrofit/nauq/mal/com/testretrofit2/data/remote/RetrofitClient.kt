package testretrofit.nauq.mal.com.testretrofit2.data.remote

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



class RetrofitClient {
    companion object { //STATIC
        private var retrofit :  Retrofit? = null
        fun getClient(baseURL : String): Retrofit? {
            if (retrofit == null){
                retrofit = Retrofit.Builder()
                        .baseUrl(baseURL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit;
        }
    }

}