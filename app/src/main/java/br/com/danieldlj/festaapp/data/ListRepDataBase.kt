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
                        false
                     ),
                    Resident(
                        1,
                        "Rato",
                        false
                    ),
                    Resident(
                        1,
                        "Pikachu",
                        false
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
                        "Dick",
                        false
                    ),
                    Resident(
                        1,
                        "CS",
                        false
                    ),
                    Resident(
                        1,
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
                        "Topper",
                        false
                    ),
                    Resident(
                        1,
                        "Bolera",
                        false
                    ),
                    Resident(
                        1,
                        "Rússia",
                        false

                    )
                )

            )
        )
    }
}