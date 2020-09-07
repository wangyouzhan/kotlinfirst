package com.avic.kotlinfirst.runtimePermission

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.avic.kotlinfirst.R
import kotlinx.android.synthetic.main.activity_permission.*

class PermissionActivity : AppCompatActivity() {


    private var accept_call: Boolean = false;
    

    companion object{
        private const val REQUEST_CODE_PERMISSION: Int = 200
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        call_button.setOnClickListener {
            makeCall()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<out String>,
                                            grantResults: IntArray) {
        if (requestCode == REQUEST_CODE_PERMISSION){
            accept_call = grantResults[0] == PackageManager.PERMISSION_GRANTED
            if (accept_call){
                toast("Permission for call Granted")
                makeCall()
            }else{
                toast("Permission for call required")
            }
        }
    }


    private fun makeCall(){
        val intent: Intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:10086")
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), REQUEST_CODE_PERMISSION)
        }else{
            startActivity(intent)
        }

    }


    fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_LONG){
        Toast.makeText(this, message, duration).show()
    }
    
    
    
    
}








