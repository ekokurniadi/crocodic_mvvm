package id.ekokurniadi.myapplication.api


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import id.ekokurniadi.myapplication.data.constant.Constants
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.HttpException

open class ApiResponse(

    @Expose
    @SerializedName("status")
    var status: ApiStatus? = ApiStatus.SUCCESS,

    @Expose
    @SerializedName("message")
    var message: JSONArray = JSONArray(),

    @Expose
    @SerializedName("data")
    var data: String? = null,

    @Expose
    @SerializedName("is_token_expired")
    var isTokenExpired: Boolean = false,

    @Expose
    @SerializedName("flag_view")
    var flagView: Int = 0,

    @Expose
    @SerializedName("throwable")
    var throwableBody: String? = null
) {
    fun responseError(it: Throwable, flagView: Int = 0): ApiResponse {
        this.status = ApiStatus.ERROR
        try {
            val error = it as HttpException
            val errorBody = error.response().errorBody()?.string()
            val responseJson = JSONObject(errorBody)
            val apiMessage = responseJson.getJSONArray(Constants.REMOTE.API_MESSAGE)
            this.message = apiMessage
            this.flagView = flagView

            if (error.code() == 401)
                if (this.message[0].toString()
                        .equals("The token is expired!", true) || this.message[0].toString()
                        .equals("The token is invalid!", true)
                ) {
                    resetSessionToken()
                }

        } catch (e: Exception) {
            this.throwableBody = it.localizedMessage
        }
        return this
    }

    fun responseWrong(apiMessage: JSONArray, flagView: Int = 0): ApiResponse {
        this.status = ApiStatus.WRONG
        this.flagView = flagView
        this.message = apiMessage
        return this
    }

    fun responseSuccess(
        apiMessage: JSONArray,
        data: String? = null,
        flagView: Int = 0
    ): ApiResponse {
        this.status = ApiStatus.SUCCESS
        this.message = apiMessage
        this.data = data
        this.flagView = flagView
        return this
    }

    fun responseLoading(flagView: Int = 0): ApiResponse {
        this.status = ApiStatus.LOADING
        this.flagView = flagView
        return this
    }

    private fun resetSessionToken() {
        this.isTokenExpired = true
    }

}