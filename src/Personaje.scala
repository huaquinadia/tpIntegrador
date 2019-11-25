
class Personaje (){
  var nombre : String
  var energia : Int
 def felicidad(a : Int):Int={a}
 def rebeldia (b: Int,felicidad: Int =>Int  ):Double= {
  1/felicidad(b)
 }
 def esRebelde(rebeldia: Double=>Double, numero: Double): Boolean={
   rebeldia (numero)>10
 }
 def interactuar(unPersonaje: Personaje){
   energia= energia/2
 }
 def conocerUnEcenario(unEcenario: Ecenario){
   energia= energia - unEcenario.fama
 }
  
}

class Huesped (var minutosEnElParque : Double, var mejoresAmigos : Array[Personaje])extends Personaje{
 
def felicidadDeLosAmigos():Array[Double]=
 mejoresAmigos.map {amigo: Personaje => felicidad};
 
override def felicidad(): Double= minutosEnElParque *felicidadDeLosAmigos.sum;
def ConsecuenciaDeConocerUnEcenario(){
   }
}

class Anfitrion (var Energia: Int, var velocidadDeProcesamiento: Double, 
    var unRecuerdo:Array[Recuerdo])extends Personaje{
 override  def felicidad():Double= energia/velocidadDeProcesamiento;
 }
class Ecenario(var nombre: String, var categoria ){
  
  def fama():Int = 100 + categoria.costo;
 
  def evolucionar():Ecenario = categoria.evolucionar(Ecenario)
 }


class Recuerdo(var descripcion:String, unEcenario:Ecenario){
  def emotividad ():Double={
    descripcion.length * unEcenario.fama
    }
}


trait BajoCosto{
  var nombre : String
  def costo ():Int= nombre.length
 def evolucionr(ecenario:Ecenario):Ecenario= ecenario.categoria(new Standar)
}

trait Standar{
  def costo():Int= 10
  def evolucionar():Ecenario= ecenario.categoria(new DeLujo)
}

trait DeLujo{
  def sumarVisitas(valor:Int):Int= +valor
  def costo():Int= sumarVistas;
  def evolucionar ()={try{}
  catch {case e :EvolucionarNotFoundEcxeption=>println ("este ecenario no evoluciona")
    e.printStackTrace()
     }finally fil.close()
  }
}

class Trama(var personajes: Array[Personaje],var unEcenario: Ecenario){
  def felicidadDePersonajes(): Personaje ={
    personajes.sum(personaje=>personaje.felicidad)
  }
  def complejidadDeLaTrama():Int={
    unEcenario.fama*felicidadDePersonajes
  }
  def renovar():Trama={
    unEcenario.evolucionar
    personajes.filter {personaje=>personaje.esRebelde}
  }
  def personajesConocenEcenario():Array[Personaje]={
    personajes.foreach{personaje=>personaje.conocerUnEcenario(unEcenario)}
  }
  def cruzarPersonajes():Array[Personajes]={
    personajes.foreach{personaje=>personaje.interactuar(unPersonaje:Personaje)}
  }
  def cruzarTrama():Trama={
    personajesConocenEcenario
    cruzarPersonajes
  }
  
}

object main{
  def main (args: Array[String]){
    val valor = new Personaje ()
    println(valor.nombre)
    println(valor.energia)
    println(valor.felicidad(7))
    
  }
}


