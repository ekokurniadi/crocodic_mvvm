package id.ekokurniadi.myapplication.service

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

class MyFirebaseMessagingService:FirebaseMessagingService() {
    override fun onNewToken(token:String){
        Log.d("tokenfirebase",token)
    }
// untuk custom sound notification
//    val uriSound = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + packageName + "/raw/notification")
}