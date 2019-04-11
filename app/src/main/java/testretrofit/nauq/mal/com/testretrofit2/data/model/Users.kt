package testretrofit.nauq.mal.com.testretrofit2.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Users {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("first_name")
    @Expose
    var firstName: String? = null
    @SerializedName("last_name")
    @Expose
    var lastName: String? = null
    @SerializedName("avatar")
    @Expose
    var avatar: String? = null

}