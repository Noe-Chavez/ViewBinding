package mx.com.disoftware.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import mx.com.disoftware.viewbinding.databinding.ActivityMainBinding
import mx.com.disoftware.viewbinding.databinding.FragmentViewBindingBinding

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

        /** Ver cómusniona un fragmento y corregir app, la idea es que noa paresca el fragmento
         * hasta que se de click en el botón, y que éstos (botón como el textview) se quiten y el
         * fragmento abarque todo el activity.
         * https://developer.android.com/guide/components/fragments?hl=es
         */
        activityMainBinding.buttonActivityMain.setOnClickListener {
            activityMainBinding.fragmentContainer.visibility = View.VISIBLE
            activityMainBinding.buttonActivityMain.visibility = View.GONE
            activityMainBinding.textViewMsg.visibility = View.GONE
            supportFragmentManager.commit {
                //this.add(....) es igual si se omite el this
                add(activityMainBinding.fragmentContainer.id, ViewBindingFragment())
            }
        }

    }
}

// https://developer.android.com/topic/libraries/view-binding#kotlin