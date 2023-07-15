package com.example.tp_mob_anaritaamaral.data

import android.annotation.SuppressLint
import android.view.View
import com.example.tp_mob_anaritaamaral.model.Curso
import java.text.SimpleDateFormat
import java.util.Locale

class CursoMock() {
    var listaCursos = ArrayList<Curso>()
    @SuppressLint("SimpleDateFormat")
    val formatoData = SimpleDateFormat("dd-MM-yyyy")

    init {
        listaCursos.add(Curso(1, "Software Developer", "Porto", formatoData.parse("02-10-2023"), formatoData.parse("11-06-2024"), "Gratuito", 1000, "4ªedição"))
        listaCursos.add(Curso(2, "Software Developer", "Lisboa", formatoData.parse("04-10-2023"), formatoData.parse("28-06-2024"), "Gratuito", 1000, "2ªedição"))
        listaCursos.add(Curso(3, "Data Analyst", "Lisboa", formatoData.parse("11-10-2023"), formatoData.parse("28-06-2024"), "Gratuito", 1050, "1ªedição"))
        listaCursos.add(Curso(4, "Data Analyst", "Porto", formatoData.parse("16-10-2023"), formatoData.parse("05-07-2024"), "Gratuito", 1050, "3ªedição"))
        listaCursos.add(Curso(5, "Front-End Developer", "Lisboa", formatoData.parse("18-10-2023"), formatoData.parse("26-06-2024"), "Gratuito", 1000, "1ªedição"))
        listaCursos.add(Curso(6, "Network & Cyber Security Administrator", "Porto", formatoData.parse("06-11-2023"), formatoData.parse("04-07-2024"), "Gratuito", 950, "3ªedição"))
        listaCursos.add(Curso(7, "Network & Cyber Security Administrator", "Lisboa", formatoData.parse("08-11-2023"), formatoData.parse("05-07-2024"), "Gratuito", 950, "2ªedição"))

        /*
        for (i in 0 .. 4) {
            listaCursos.add(Curso(i, i.toString()))
        }
         */
        //Para aparecer só os cursos na lista:
        for (Curso in listaCursos) {
            println(Curso)
        }

    }
}