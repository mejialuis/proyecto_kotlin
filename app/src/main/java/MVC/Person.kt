package MVC

import android.view.ViewDebug

class Person{
    private var Nombre:String =""
    private var Apellido:String =""
    private var Sexo:String =""
    private var Telefono:Int=0
    private var Cedula:String =""
    private var Ocupacion:String =""
    private var Direccion:String =""


    constructor(
        Nombre: String,
        Apellido: String,
        Sexo: String,
        Telefono: Int,
        Cedula: String,
        Ocupacion: String,
        Direccion: String
    ) {
        this.Nombre = Nombre
        this.Apellido = Apellido
        this.Sexo = Sexo
        this.Telefono = Telefono
        this.Cedula = Cedula
        this.Ocupacion = Ocupacion
        this.Direccion = Direccion
    }

    fun getNombre(): String{
        return Nombre
    }
    fun getApellido(): String{
        return Apellido
    }
    fun getSexo(): String{
        return Sexo
    }
    fun getTelefono(): Int{
        return Telefono
    }
    fun getCedula(): String{
        return Cedula
    }
    fun getOcupacion(): String{
        return Ocupacion
    }
    fun getDireccion(): String{
        return Direccion
    }
    override fun toString(): String {
        return "Ingreso de nuevo cliente $Nombre"
    }
}
var Todo :MutableList<Person> = mutableListOf()
