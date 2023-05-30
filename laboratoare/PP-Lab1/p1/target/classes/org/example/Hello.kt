package org.example

import java.util.*

class Birth(val year: Int, val month: Int, val day: Int){
    override fun toString() : String{
        return "($day.$month.$year)"
    }
}
class Contact(val name: String, var phone: String, val birthDate: Birth){
    fun Print() {
        println("Name: $name, Mobile: $phone, Date: $birthDate")
    }
}

fun search(agenda: MutableList<Contact>, tipCautare: Int) {
    val reader = Scanner(System.`in`)
    val Caut:String
    if(tipCautare == 0){
        println("Introduceti numele cautat: ")
        Caut = reader.nextLine()
        println("Persoanele din lista cu numele respectiv: ")
    } else if(tipCautare == 1) {
        println("Introduceti numarul de telefon cautat: ")
        Caut = reader.nextLine()
        println("Persoanele din lista cu numarul de telefon respectiv: ")
    } else {
        println("Tip de cautare invalid")
        return
    }

    for(persoana in agenda){
        if(tipCautare == 0){
            if(persoana.name == Caut) {
                persoana.Print()
            }
        } else if(tipCautare == 1) {
            if(persoana.phone == Caut) {
                persoana.Print()
            }
        }
    }
}

fun editNumber(agenda: MutableList<Contact>) {
    println("Schimbare numar Contract")
    val reader = Scanner(System.`in`)
    println("Introduceti numele persoanei: ")
    val name = reader.nextLine()
    println("Introduceti noul numar de telefon: ")
    val newNumber = reader.nextLine()

    for(persoana in agenda){
       if(persoana.name == name) {
           persoana.phone = newNumber;
       }
    }
}
fun main(args : Array<String>){
    val agenda = mutableListOf<Contact>()
    agenda.add(Contact("Mihai", "0744321987", Birth(1900, 11, 25)))
    agenda += Contact("George", "0761332100", Birth(2002, 3, 14))
    agenda += Contact("Liviu" , "0231450211", Birth(1999, 7, 30))
    agenda += Contact("Alex", "0761332100", Birth(2002, 3, 14))
    agenda += Contact("Popescu", "0211342787", Birth(1955, 5, 12))
    for (persoana in agenda){
        persoana.Print()
    }

    println("Agenda dupa eliminare contact [George]:")
    agenda.removeAt(1)
    for (persoana in agenda){
        persoana.Print()
    }

    agenda.remove(Contact("Liviu" , "0231450211", Birth(1999, 7, 30)))
    println("Agenda dupa eliminare contact [Liviu]:")
    agenda.removeAt(1)

    for (persoana in agenda){
        persoana.Print()
    }

    println("Introduceti tipul de cautare:\n(0)Nume\n(1)Numar Telefon\nTip:")
    val reader = Scanner(System.`in`)
    val tipCautare = reader.nextInt()

    search(agenda, tipCautare)


    editNumber(agenda)
    println("Agenda dupa editare numar:")

    for (persoana in agenda){
        persoana.Print()
    }
}
