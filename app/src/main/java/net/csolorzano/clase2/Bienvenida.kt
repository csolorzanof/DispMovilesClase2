package net.csolorzano.clase2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Bienvenida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        intent?.let{
            val nombreCompleto = it.getStringExtra(LLAVE_NOMBRE_COMPLETO)
            findViewById<TextView>(R.id.txtMensajeBienvenida).text =
                getString(R.string.mensaje_bienvenida,nombreCompleto, "ASDASDADS")

        }
    }

    companion object{
        private const val LLAVE_NOMBRE_COMPLETO = "NOMCOMP"
    }
}