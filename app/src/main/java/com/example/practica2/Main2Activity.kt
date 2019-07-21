package com.example.practica2

import MVC.Todo
import android.app.Person
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main4.*

@Suppress("NAME_SHADOWING")
class Main2Activity : AppCompatActivity(), TextWatcher {
    var sexo= arrayOf("Masculino","Femenino")
    //intento2
    private var count = 10
    private var nombre = ""
    private var apellido = ""
    private var telefono=""
    private var cedula = ""
    private var ocupacion = ""
    private var direccion = ""
    private var genero = ""
    var lista: MutableList<MVC.Person> = ArrayList()
    var lista1: MutableList<Personas> = ArrayList()
    //private var Names: MutableList<MVC.Person> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



        val adapter=ArrayAdapter(this, android.R.layout.simple_spinner_item, sexo)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spSexo.adapter = adapter
        spSexo.onItemSelectedListener =object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                genero = sexo[position]
            }
        }
        btContinuar.setOnClickListener {
                Continuar()
        }
    }
    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }
    fun agregarDatos(){
        //lista.add(MVC.Person(nombre,apellido,genero,telefono.toInt(),cedula,ocupacion,direccion))
        lista1.add(Personas(nombre,apellido,genero,telefono.toInt(),cedula,ocupacion,direccion))
       MostrarDatos(lista)
        etNombre!!.setText("")
        etApellido!!.setText("")
        etTelefono!!.setText("")
        etCedula!!.setText("")
        etOcupacion!!.setText("")
        etDireccion!!.setText("" )

    }
    fun Continuar(){
        nombre = etNombre?.text.toString()
        apellido = etApellido?.text.toString()
        telefono = etTelefono?.text.toString()
        cedula = etCedula?.text.toString()
        ocupacion = etOcupacion?.text.toString()
        direccion = etDireccion?.text.toString()
        Todo.add(MVC.Person(nombre,apellido,genero,telefono.toInt(),cedula,ocupacion,direccion))

        val intento1 = Intent(this, MainActivity::class.java)
        startActivity(intento1)

    }
    private fun MostrarDatos(listData: MutableList<MVC.Person>){
        val adapter = ArrayAdapter<MVC.Person>(this, android.R.layout.simple_list_item_1, listData)
    }
}
