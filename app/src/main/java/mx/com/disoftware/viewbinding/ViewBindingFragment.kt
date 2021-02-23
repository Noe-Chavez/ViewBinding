package mx.com.disoftware.viewbinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.com.disoftware.viewbinding.databinding.FragmentViewBindingBinding

class ViewBindingFragment : Fragment() {

    private var _viewBindingFragment: FragmentViewBindingBinding? = null

    // Esta propiedad es válida sólo cuando se ejecuta el onCreateView hasta el onDestroyView.
    private val viewBindingFragment get() = _viewBindingFragment!!

    // Por el onCreate se infla el fragment.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // inflar la vista del fragmento.
        _viewBindingFragment = FragmentViewBindingBinding.inflate(inflater, container, false)
        // accceder a los recuros del fragmento.
        val view = viewBindingFragment.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var acum = 1
        viewBindingFragment.textViewMsgFragment.text = "View Binding en Fragmentos"
        viewBindingFragment.buttonFragment.setOnClickListener {
            viewBindingFragment.textViewMsgFragment.text = "me has presionado ${acum++}"
            viewBindingFragment.textViewMsgFragment.textSize = 25f
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // liverar la memoria cuando se destruya este fragmento.
        _viewBindingFragment = null
    }

}

// https://www.youtube.com/watch?v=31XwN-Ztba4&t=293s (para el reporte ver de nuevo)