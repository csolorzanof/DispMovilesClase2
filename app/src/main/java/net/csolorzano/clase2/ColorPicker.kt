package net.csolorzano.clase2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class ColorPicker : AppCompatActivity() {

    val colorPickerClickListener = View.OnClickListener { view ->
        when(view.id){
            R.id.btnRojo -> seleccionarColor(R.color.rojo)
            R.id.btnAzul -> seleccionarColor(R.color.azul)
            R.id.btnVerde -> seleccionarColor(R.color.verde)
            R.id.btnAmarillo -> seleccionarColor(R.color.amarillo)
            R.id.btnNegro -> seleccionarColor(R.color.negro)
            else -> {
                Toast.makeText(this, "Color no existe", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun seleccionarColor(color: Int){
        Log.d(MainActivity.TAG, "ColorPicker Color Seleccionado ${color}")
        Intent().let{it ->
            it.putExtra(LLAVE_COLOR, color)
            setResult(Activity.RESULT_OK, it)
            finish()
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_picker)

        findViewById<Button>(R.id.btnRojo).setOnClickListener(colorPickerClickListener)
        findViewById<Button>(R.id.btnAzul).setOnClickListener(colorPickerClickListener)
        findViewById<Button>(R.id.btnAmarillo).setOnClickListener(colorPickerClickListener)
        findViewById<Button>(R.id.btnVerde).setOnClickListener(colorPickerClickListener)
        findViewById<Button>(R.id.btnNegro).setOnClickListener(colorPickerClickListener)
    }

    companion object{
        public const val LLAVE_COLOR = "LLAVE_COLOR"
    }
}