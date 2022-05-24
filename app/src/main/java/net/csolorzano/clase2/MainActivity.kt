package net.csolorzano.clase2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    val nombre:EditText get() = findViewById(R.id.txtNombre)
    val apellido:EditText get() = findViewById(R.id.txtApellido)
    val correo:EditText get() = findViewById(R.id.txtCorreo)
    val btnAceptar:Button get() = findViewById(R.id.btnAceptar)
    val descuento:TextView get() = findViewById(R.id.txtDescuento)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAceptar.setOnClickListener {
            if(nombre.text.isNotEmpty() && apellido.text.isNotEmpty() && correo.text.isNotEmpty()){
                val valorDescuento = UUID.randomUUID().toString().take(8).uppercase()
                descuento.text = valorDescuento
            }else{
                Toast.makeText(this, "Todos los campos son requerido", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(LLAVE_DESCUENTO, descuento.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val valorDescuento = savedInstanceState.getString(LLAVE_DESCUENTO,"")
        descuento.text = valorDescuento
    }

    companion object{
        private const val LLAVE_DESCUENTO = "AAA"
        private const val LLAVE_NOMBRE_COMPLETO = "AAA"
    }
}