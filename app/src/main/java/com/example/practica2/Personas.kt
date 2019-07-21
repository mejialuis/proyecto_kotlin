package com.example.practica2

data class Personas (var Nombre:String ="",
                     var Apellido:String ="",
                     var Sexo:String ="",
                     var Telefono:Int=0,
                     var Cedula:String ="",
                     var Ocupacion:String ="",
                     var Direccion:String ="") {
    override fun toString(): String {
        return "Ingreso de nuevo cliente $Nombre\n"
    }

}

val jose:Personas = Personas("ManueI","Altamirano","Masculino",77335511,"282-asd-21","Estudiante","Leon")
var agregar :MutableList<Personas> = mutableListOf()
var Nombres :ArrayList<Personas> = arrayListOf()


