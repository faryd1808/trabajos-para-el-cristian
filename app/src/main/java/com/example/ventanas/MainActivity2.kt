package com.example.ventanas


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val campoNombre=findViewById<TextView>(R.id.nombre2)
        val campoMateria=findViewById<TextView>(R.id.materia2)
        val campon1=findViewById<TextView>(R.id.not1)
        val campon2=findViewById<TextView>(R.id.not2)
        val campon3=findViewById<TextView>(R.id.not3)
        val promedio=findViewById<TextView>(R.id.prom2)
        var bundle: Bundle? = this.intent.extras

        if (bundle != null){
            campoNombre.text="hola ${bundle.getString("Nombre")}"
            campoMateria.text="${bundle.getString("Materia")}"
            campon1.text="${bundle.getString("N1")}"
            campon2.text="${bundle.getString("N2")}"
            campon3.text="${bundle.getString("N3")}"
            promedio.text="${bundle.getString("Promedio")}"


        }
        if(bundle?.getString("Promedio").toString().toDouble()>=3.5){
            promedio.setTextColor(ContextCompat.getColor(this,R.color.aprovado))
        }else{
            promedio.setTextColor(ContextCompat.getColor(this,R.color.reprovado))
        }

        val buttonSal: Button=findViewById(R.id.btnSalir)
        buttonSal.setOnClickListener{onClick()}
    }

    private fun onClick(){
        finish()
    }
}