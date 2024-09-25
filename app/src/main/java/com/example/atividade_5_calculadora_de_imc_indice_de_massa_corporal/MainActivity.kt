package com.example.atividade_5_calculadora_de_imc_indice_de_massa_corporal

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputPeso = findViewById<EditText>(R.id.edPeso)
        val inputAltura = findViewById<EditText>(R.id.edAltura)
        val resultado = findViewById<TextView>(R.id.txtResultado)
        val botaoCaucular = findViewById<Button>(R.id.btnCalcular)

        val format = DecimalFormat ("###.00")

        botaoCaucular.setOnClickListener {

            val pesoInformado = inputPeso.text.toString()
            val alturaInformada = inputAltura.text.toString()

            if (pesoInformado.isNotEmpty() && alturaInformada.isNotEmpty()){

                val pesoDouble = pesoInformado.toDouble()
                val alturaDouble = alturaInformada.toDouble()

                val imc: Double = pesoDouble / (alturaDouble * alturaDouble)

                if (imc < 18.5){
                    resultado.setText("Abixo do peso  IMC: ${format.format(imc)}")
                }else if (imc >=18.5 && imc <= 24.9) {
                    resultado.setText("Peso normal  IMC: ${format.format(imc)}")
                }else if (imc >= 25 &&  imc <=29.9) {
                    resultado.setText("Sobrepeso  IMC: ${format.format(imc)}")
                }else if (imc >= 30){
                    resultado.setText("Obesidade  IMC: ${format.format(imc)}")
                }

            }else{
                resultado.setText("Insira o Peso e a Altura")
            }

        }

    }

    fun limparValores(view: View){
        val inputPeso = findViewById<EditText>(R.id.edPeso)
        val inputAltura = findViewById<EditText>(R.id.edAltura)
        val resultado = findViewById<TextView>(R.id.txtResultado)

        inputPeso.setText("")
        inputAltura.setText("")
        resultado.setText("")

    }
}