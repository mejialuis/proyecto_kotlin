package com.example.practica2

import MVC.Todo
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Person
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main3.*
import android.widget.AdapterView.OnItemSelectedListener
import java.util.*

class Main3Activity : AppCompatActivity(), TextWatcher {

    private lateinit var sp2 : Spinner
    private lateinit var spNom : Spinner
    var cal= Calendar.getInstance()
    var año=cal.get(Calendar.YEAR)
    var mes=cal.get(Calendar.MONTH)
    var dia=cal.get(Calendar.DAY_OF_MONTH)
    var mnt=0
    var int=0
    var total = 0
    var interes=0
    var plz=0
    var count= Todo.size
    var nombre:Array<String> = Array(count) {""}


    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        etFecha.setText(""+dia+"-"+(mes+1)+"-"+año)
        var Monto: EditText? = null
        var plazo: EditText? = null
        sp2 = findViewById(R.id.spInteres)
        spNom=findViewById(R.id.spNombres)


        for (i in 0 until Todo.size) {
            nombre = Array(count++) {Todo[i].getNombre()}
        }

        val inter = arrayOf<Int>(15, 20, 25)
        Monto?.addTextChangedListener(this)

        plazo?.addTextChangedListener(this)

        val adapter2 = ArrayAdapter(this, android.R.layout.simple_list_item_1, inter)
        val adapter3 = ArrayAdapter(this, android.R.layout.simple_list_item_1, nombre)

        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        adapter3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        sp2.adapter = adapter2
        spNom.adapter=adapter3

        spInteres.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Guardar()
            }
        }
        btFinalizar.setOnClickListener{
            if (etMonto.text.toString().isEmpty()){
                etMonto.setError("Campo obligatorio")
                Toast.makeText(this, "Se debe ingresar un Monto", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (etPlazo.text.toString().isEmpty()){
                Toast.makeText(this, "Se debe ingresar el Plazo", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            Toast.makeText(this, "¡MUCHAS GRACIAS!", Toast.LENGTH_LONG).show()
            val intento1 = Intent(this, MainActivity::class.java)
            startActivity(intento1)
        }
        button.setOnClickListener(){
            val dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener{view :DatePicker ,myear:Int,mmes:Int,mdia:Int ->
                etFecha.setText(""+dia+"-"+mes+"-"+año)
            },año,mes,dia)
            dpd.show()
        }
    }
    override fun afterTextChanged(s: Editable?) {

        etFecha.setText(""+dia+"-"+(mes+1)+"-"+año)
        Guardar()


    }
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        Guardar()

    }
    @SuppressLint("SetTextI18n")
    fun Guardar() {
        if (etMonto.text.toString().isEmpty()) {
            Toast.makeText(this, "Ingrese su monto", Toast.LENGTH_SHORT).show()
            etMontoPagar.text = "0.0"
            etMontoCuota.text = "0.0"
            etFecha.setText(""+dia+"-"+(mes+1)+"-"+año)


        } else{
            mnt=etMonto.text.toString().toInt()
            int=spInteres.selectedItem.toString().toInt()
            interes=(mnt*int)/100
            total=mnt+interes
            etMontoPagar.text = total.toString()
        }
        if (etPlazo.text.toString().isEmpty()) {
            Toast.makeText(this, "Ingrese su plazo", Toast.LENGTH_SHORT).show()
        } else {
            plz=etPlazo.text.toString().toInt()
            etMontoCuota.text=(total/plz).toString()
            etFechafin.setText((dia).toString()+"/"+(mes+plz).toString()+"/"+año.toString())
            Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show()
        }
    }
}