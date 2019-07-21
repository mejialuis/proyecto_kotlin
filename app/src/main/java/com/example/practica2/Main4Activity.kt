package com.example.practica2

import MVC.Todo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main4.*

class Main4Activity : AppCompatActivity(), TextWatcher {


 var count=10
    var j=0
    var nombre:Array<String> = Array(count) {""}
    var apellido:Array<String> = Array(count) {""}
    var telefono:Array<String> = Array(count) {""}
    var cedula:Array<String> = Array(count) {""}
    var ocupacion:Array<String> = Array(count) {""}
    var direccion:Array<String> = Array(count) {""}


 override fun onCreate(savedInstanceState: Bundle?) {
     super.onCreate(savedInstanceState)
     setContentView(R.layout.activity_main4)

     btAnterior.setOnClickListener {
         if (j>0){
             nombre = Array(count++) {Todo[j].getNombre()}
             apellido= Array(count++){Todo[j].getApellido()}
             telefono= Array(count++){Todo[j].getTelefono().toString()}
             cedula=Array(count++){Todo[j].getCedula()}
             ocupacion=Array(count++){Todo[j].getOcupacion()}
             direccion=Array(count++){Todo[j].getDireccion()}
             tvNom.text = nombre[j]
             tvApe.text = apellido[j]
             tvTel.text = telefono[j]
             tvCed.text = cedula[j]
             tvOcu.text = ocupacion[j]
             tvDir.text = direccion[j]
         j--
         }else {
             Toast.makeText(this, "Ultimo", Toast.LENGTH_SHORT).show()
         }
     }
     btSiguiente.setOnClickListener {
         if (j< Todo.size-1){
             nombre = Array(count++) {Todo[j].getNombre()}
             apellido= Array(count++){Todo[j].getApellido()}
             telefono= Array(count++){Todo[j].getTelefono().toString()}
             cedula=Array(count++){Todo[j].getCedula()}
             ocupacion=Array(count++){Todo[j].getOcupacion()}
             direccion=Array(count++){Todo[j].getDireccion()}
             tvNom.text = nombre[j]
             tvApe.text = apellido[j]
             tvTel.text = telefono[j]
             tvCed.text = cedula[j]
             tvOcu.text = ocupacion[j]
             tvDir.text = direccion[j]
             j++
         }else {
             Toast.makeText(this, "Ultimo", Toast.LENGTH_SHORT).show()
         }
     }
     //nombre = findViewById(R.id.tvNom)
     /*apellido = findViewById(R.id.etApe)
     telefono = findViewById(R.id.etTel)
     cedula = findViewById(R.id.etCed)
     ocupacion = findViewById(R.id.etOcu)
     direccion = findViewById(R.id.etDir)

     nombre?.addTextChangedListener(this)
     apellido?.addTextChangedListener(this)
     telefono?.addTextChangedListener(this)
     cedula?.addTextChangedListener(this)
     ocupacion?.addTextChangedListener(this)
     direccion?.addTextChangedListener(this)*/






   /*   bt1.setOnClickListener {
         nom = etNom?.text.toString()
         ape = etApe?.text.toString()
         tel = etTel?.text.toString()
         ced = etCed?.text.toString()
         ocu = etOcu?.text.toString()
         dir = etDir?.text.toString()

         nom = jose.Nombre
         ape = jose.Apellido
         tel = jose.Telefono.toString()
         ced = jose.Cedula
         ocu = jose.Ocupacion
         dir = jose.Direccion

     }*/
 }
    fun MostrarDato(){
        for (i in 0 until Todo.size) {
            nombre = Array(count++) {Todo[i].getNombre()}
            apellido= Array(count++){Todo[i].getApellido()}
            telefono= Array(count++){Todo[i].getTelefono().toString()}
            cedula=Array(count++){Todo[i].getCedula()}
            ocupacion=Array(count++){Todo[i].getOcupacion()}
            direccion=Array(count++){Todo[i].getDireccion()}

        }
    }
 override fun afterTextChanged(s: Editable?) {
     TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
 }

 override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
     TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
 }

 override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
     TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
 }
}
