package net.csolorzano.clase2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private val obtenerResultado = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == Activity.RESULT_OK){
            val colorSeleccionado = it.data?.getIntExtra(ColorPicker.LLAVE_COLOR, R.color.white)
            val txtColor = findViewById<TextView>(R.id.txtResultado)
            Log.d(TAG, "Color seleccionado ${colorSeleccionado}")
            if(colorSeleccionado != null)
                txtColor.setBackgroundColor(ContextCompat.getColor(this, colorSeleccionado))
            txtColor.isVisible = true
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnAceptar).setOnClickListener {
            Intent(this, ColorPicker::class.java)
                .also { colorPickerIntent ->
                    obtenerResultado.launch(colorPickerIntent)
                }
        }
    }

    companion object{
        public const val TAG = "DispMovClase2"
    }
}