package net.csolorzano.clase2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnAceptar).setOnClickListener {
            val nombreCompleto = findViewById<EditText>(R.id.txtNombreCompleto).text.toString()

            if(nombreCompleto.isNotEmpty()){
                Intent(this, Bienvenida::class.java)
                    .also{ intentBienvenida ->
                        intentBienvenida.putExtra(LLAVE_NOMBRE_COMPLETO, nombreCompleto)
                        startActivity(intentBienvenida)
                    }
            }else{
                Toast.makeText(this, "Nombre completo es requerido", Toast.LENGTH_LONG)
                    .show()
            }
        }

        findViewById<Button>(R.id.btnCuenta).setOnClickListener {
            val cuenta = findViewById<EditText>(R.id.txtNumCuenta).text.toString()
            Intent(this, Bienvenida::class.java)
                .also { it ->
                    it.putExtra(LLAVE_NOMBRE_COMPLETO, cuenta)
                    startActivity(it)
                }
        }
    }

    companion object{
        private const val LLAVE_NOMBRE_COMPLETO = "NOMCOMP"
    }
}