package mx.com.disoftware.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.com.disoftware.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflar el activity (la vista) activity_main, para ello utilizamos layoutInflater (nos regresa la vista).
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        // Obtener acceso a los recursos del activity_main.xml.
        val view = activityMainBinding.root
        // Vincular el xml con este archvio kotlin.
        setContentView(view)

        activityMainBinding.textViewMsg.text = "Utilizando View Binding"
        activityMainBinding.textViewMsg.textSize = 25f;

    }
}