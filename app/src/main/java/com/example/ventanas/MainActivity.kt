package com.example.ventanas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var campoNombre: EditText? = null
    var campoMateria: EditText?= null
    var campoN1: EditText? = null
    var campoN2: EditText? = null
    var campoN3: EditText? = null
    var promedio : Double? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoNombre=findViewById(R.id.nombre)
        campoMateria=findViewById(R.id.materia)
        campoN1=findViewById(R.id.nota1)
        campoN2=findViewById(R.id.nota2)
        campoN3=findViewById(R.id.nota3)

        val btnProm:Button=findViewById(R.id.button)
        btnProm.setOnClickListener {onClick(1)}
        val btnOtro: Button=findViewById(R.id.buttonOtra)
        btnOtro.setOnClickListener {onClick(2)}

    }

    private fun calcularProm(): Double{
        var n1 : Double=campoN1?.text.toString().toDouble()
        var n2 : Double=campoN2?.text.toString().toDouble()
        var n3 : Double=campoN3?.text.toString().toDouble()

        promedio=((n1+n2+n3)/3)

        return promedio as Double
    }
    private fun onClick(botones :Int){
        when(botones){
            1 -> {
                calcularProm()
                var vNombre:String= campoNombre!!.text.toString()
                var vMateria:String= campoMateria!!.text.toString()
                var vN1:String= campoN1!!.text.toString()
                var vN2:String= campoN2!!.text.toString()
                var vN3:String= campoN3!!.text.toString()
                var vProm: String= promedio!!.toString()

                Toast.makeText(this,"Hola $vNombre \n Promedio $vProm\n notas: $vN1 $vN2 $vN3", Toast.LENGTH_LONG).show()
            }

            2 ->{
                val intent= Intent(this,MainActivity2::class.java)
                val bundle:Bundle=Bundle()
                bundle.putString("Nombre", campoNombre!!.text.toString ())
                bundle.putString("Materia", campoMateria!!.text.toString())
                bundle.putString("N1", campoN1!!.text.toString())
                bundle.putString("N2", campoN2!!.text.toString())
                bundle.putString("N3", campoN3!!.text.toString())
                bundle.putString("Promedio", promedio!!.toString())
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }



    }
}