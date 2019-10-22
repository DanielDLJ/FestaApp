package br.com.danieldlj.festaapp.data

import br.com.danieldlj.festaapp.domain.Republic
import br.com.danieldlj.festaapp.domain.Resident


class ListRepDataBase {

    companion object{

        fun getItems()
                = mutableListOf(
            Republic(
                1,
                "Diretoria",
                "https://graph.facebook.com/RepDiretoria/picture?type=square",
                false,
                listOf(
                    Resident(
                    1,
                    "Bernardo",
                    "Bronha",
                    false
                ),
                    Resident(
                        1,
                        "Felipe",
                        "Rato",
                        false
                    ),
                    Resident(
                        1,
                        "Pedro",
                        "Pikachu",
                        true
                    )
                )
            ),
            Republic(
                1,
                "Sunas",
                "https://graph.facebook.com/RepublicaSunasUFSCar/picture?type=square",
                false,
                listOf(
                    Resident(
                        1,
                        "Victor",
                        "Dick",
                        true
                    ),
                    Resident(
                        1,
                        "João",
                        "CS",
                        true
                    ),
                    Resident(
                        1,
                        "Deivid Sá",
                        "Locutor",
                        false
                    )
                )
            ),
            Republic(
                1,
                "ViraCopos",
                "https://graph.facebook.com/RepublicaViraCoposSorocaba/picture?type=square",
                false,
                listOf(
                    Resident(
                        1,
                        "Fernanda",
                        "Topper",
                        false
                    ),
                    Resident(
                        1,
                        "Juliane",
                        "Bolera",
                        false
                    ),
                    Resident(
                        1,
                        "Gabriele",
                        "Rússia",
                        false
                    )
                )

            )
        )
    }
}