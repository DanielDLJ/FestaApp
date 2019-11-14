package br.com.danieldlj.festaapp.data

import br.com.danieldlj.festaapp.domain.*


class RotationDataBase {

    companion object{

        fun getItems()
                = mutableListOf(
            Rotation(
                1,
                "Porta",
                mutableListOf(
                    RotationTime(
                    "20:00",
                      "21:00",
                        listOf(
                            Person(
                                1,
                                "Daniel",
                                ""),
                            Person(
                                1,
                                "Bia",
                                ""),
                            Person(
                                1,
                                "Ricardo",
                                "")
                            )
                    ),
                    RotationTime(
                        "21:00",
                         "22:00",
                        mutableListOf(
                            Person(
                                1,
                                "Daniel",
                                ""),
                            Person(
                                1,
                                "Bia",
                                ""),
                            Person(
                                1,
                                "Ricardo",
                                "")
                        )
                    )
                )
            ),
            Rotation(
                1,
                "Bar",
                listOf(
                    RotationTime(
                        "20:00",
                          "21:00",
                        listOf(
                            Person(
                                1,
                                "Daniel",
                                ""),
                            Person(
                                1,
                                "Bia",
                                ""),
                            Person(
                                1,
                                "Ricardo",
                                "")
                        )
                    )
                )
            ),
            Rotation(
                1,
                "Caixa",
                listOf(
                    RotationTime(
                        "20:00",
                         "21:00",
                        listOf(
                            Person(
                                1,
                                "Daniel",
                                ""),
                            Person(
                                1,
                                "Bia",
                                ""),
                            Person(
                                1,
                                "Ricardo",
                                "")
                        )
                    )
                )
            )

        )
    }
}