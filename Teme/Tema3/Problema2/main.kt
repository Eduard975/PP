package org.example

import java.io.File

fun Boolean.toInt() = if (this) 1 else 0

fun main() {
    val ebook = File("ebook.txt").readLines()
    var new_ebook = arrayListOf<String>()
    val n = ebook.size;
    var i = 0;
    var j = 0;
    print("-----------Cartea Originala------------\n" +ebook.joinToString("\n" ))
    while(i < n) {
        val temp = ebook[i].trim().replace("\\s{2,}".toRegex(), " ")

        if(temp.isNotEmpty()) {
            var digit_counter = 0;
            for(c in temp.toCharArray()){
                digit_counter += c.isDigit().toInt();
            }
            if(digit_counter != temp.length){
                new_ebook.add(j, temp)
                j++;
            }
        }

        if(temp.isEmpty() && j > 0 && new_ebook[j-1].isNotEmpty()){
            new_ebook.add(j, temp)
            j++;
        }

        i++;
    }
    print("\n-----------Cartea Editata------------\n" + new_ebook.joinToString("\n" ))
}