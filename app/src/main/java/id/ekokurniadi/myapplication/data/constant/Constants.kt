package id.ekokurniadi.myapplication.data.constant

/**
 * Berisi konstanta yang digunakan dalam program
 *
 */
class Constants {

    object INTENT {
        const val KEY_LOCATION = "location"
        const val KEY_DATE = "date"
        const val KEY_TIME = "time"
        const val KEY_ACC = "acc"
        const val KEY_TYPE = "type"
        const val KEY_RATING = "rating"
    }

    object REMOTE {
        const val API_STATUS = "status"
        const val API_MESSAGE = "message"
        const val API_STATUS_SUCCESS = 1
        const val OBJ_DATA = "data"
    }

    object SHAREDPREF {
        const val DEFAULT_VALUE_USER_ID = ""
        const val NAME = "NAME"
        const val KEY_USER_ID = "USER_ID"
        const val KEY_TOKEN = "TOKEN"
        const val KEY_SID = "SID"
    }

    object DEFAULT {
        const val BASIC_AUTH_USER = "crocodic"
        const val BASIC_AUTH_PASS = "123456"
    }

}