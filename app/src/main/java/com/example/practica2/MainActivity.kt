package com.example.practica2
import MVC.Person
import MVC.Todo
import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var count=10

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var nombre:Array<String>
        for (i in 0 until Todo.size) {
            nombre = Array(count++) {Todo[i].getNombre()}
            tvMM.text="Ingreso de nuevo cliente ${nombre[i]}"
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?):Boolean{
        menuInflater.inflate(R.menu.item,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if (id == R.id.Add) {
            Toast.makeText(this,"Solicitud",Toast.LENGTH_SHORT).show()
            val intento1 = Intent(this, Main2Activity::class.java)
            startActivity(intento1)
        }
        if (id == R.id.Usuarios) {
            Toast.makeText(this,"Monto",Toast.LENGTH_SHORT).show()
            val intento2 = Intent(this, Main3Activity::class.java)
            startActivity(intento2)
            return true
            }
        if (id == R.id.Mostrar) {
            Toast.makeText(this,"Monto",Toast.LENGTH_SHORT).show()
            val intento3 = Intent(this, Main4Activity::class.java)
            startActivity(intento3)
            return true
        }
        if (id == R.id.Acerca) {
            Toast.makeText(this,"Kotlin++",Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
