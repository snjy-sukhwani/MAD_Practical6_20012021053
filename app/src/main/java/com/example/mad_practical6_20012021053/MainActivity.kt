package com.example.mad_practical6_20012021053

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.WindowCompat
import com.example.mad_practical6_20012021053.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.youtubePlayerBtn.setOnClickListener{

            val inputLink = binding.youtubeLink.text.toString()
            //Toast.makeText(this,"1. Link : $inputLink",Toast.LENGTH_LONG).show()

            // Checking for valid youtube link :
            // Examples :
            //      1. https://www.youtube.com/watch?v=g6fnFALEseI
            //      2. https://youtu.be/g6fnFALEseI
            //      3. https://www.youtube.com/watch?v=A66TYFdz8YA
            //      4. https://www.youtube.com/watch?v=5Eqb_-j3FDA

            if (inputLink.startsWith("https://www.youtube.com/watch?v=") ||
                inputLink.startsWith("www.youtube.com/watch?v=") ||
                inputLink.startsWith("youtube.com/watch?v="))
            {
                val equal_loc = inputLink.indexOf('=')
                val youtubelink = inputLink.slice(equal_loc+1..inputLink.length-1)

                //Toast.makeText(this,"2. Link : $youtubelink",Toast.LENGTH_LONG).show()

                if (youtubelink.length==11){
                    Toast.makeText(this,"Youtube Link is Valid",Toast.LENGTH_LONG).show()

                    // Explicit Intent with Data Transfer
                    val youtubeLinkTransfer = Intent(this,YoutubeActivity::class.java)
                    youtubeLinkTransfer.putExtra("link",youtubelink)
                    startActivity(youtubeLinkTransfer)
                }
                else{
                    Toast.makeText(this,"Youtube Link is InValid\nTry Another Link",Toast.LENGTH_LONG).show()
                }
            }

            else if(inputLink.startsWith("https://youtu.be/")){
                val startfrom = inputLink.lastIndexOf('/')
                val youtubelink = inputLink.slice(startfrom+1..inputLink.length-1)

                //Toast.makeText(this,"Link : $youtubelink",Toast.LENGTH_LONG).show()

                if (youtubelink.length==11){
                    Toast.makeText(this,"Youtube Link is Valid",Toast.LENGTH_LONG).show()

                    // Explicit Intent with Data Transfer
                    val youtubeLinkTransfer = Intent(this,YoutubeActivity::class.java)
                    youtubeLinkTransfer.putExtra("link",youtubelink)
                    startActivity(youtubeLinkTransfer)
                }
                else{
                    Toast.makeText(this,"Link is InValid\nTry Another Link",Toast.LENGTH_LONG).show()
                }
            }

            else{
                Toast.makeText(this,"Link is InValid\nTry Another Link",Toast.LENGTH_LONG).show()
            }
        }

        binding.webPlayerBtn.setOnClickListener {
            Toast.makeText(this,"Video is Playing . . ",Toast.LENGTH_LONG).show()
            val web = Intent(this,WebActivity::class.java)
            startActivity(web)
        }

    }
}