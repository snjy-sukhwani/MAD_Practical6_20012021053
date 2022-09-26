package com.example.mad_practical6_20012021053

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.MediaController
import android.widget.VideoView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        // For Removing/Hiding the Notification Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val mediaController= MediaController(this)
        val uri: Uri = Uri.parse("android.resource://"+packageName+"/"+R.raw.thestoryoflight)
        val myVideoView=findViewById<VideoView>(R.id.webPlayerScreen)
        myVideoView.setMediaController(mediaController)
        mediaController.setAnchorView(myVideoView)
        myVideoView.setVideoURI(uri)
        myVideoView.requestFocus()
        myVideoView.start()


        val button=findViewById<FloatingActionButton>(R.id.homeBtn)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}