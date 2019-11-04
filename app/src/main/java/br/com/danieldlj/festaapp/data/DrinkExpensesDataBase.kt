package br.com.danieldlj.festaapp.data

import br.com.danieldlj.festaapp.domain.DrinkExpenses


class DrinkExpensesDataBase {

    companion object{

        fun getItems() = listOf(
            DrinkExpenses(
                1,
                "Corote",
                "https://pm1.narvii.com/7251/9f5a1cf2abbd44db0ca093477cc3dc3094496b33r1-600-600v2_128.jpg",
                0.6F,
                120F,
                0F,
                4.58F,
                549.6F,
                "Adega Maracanã",
                3.333333333F,
                1333.333333F,
                false
            ),
            DrinkExpenses(
                2,
                "Cerveja Eisenbahn",
                "https://clubedomalte.fbitsstatic.net/img/p/eisenbahn-pilsen-lata-350ml-88508/255565.jpg?w=300&h=300&v=no-change",
                1.23F,
                246F,
                0F,
                3.92F,
                964.32F,
                "Adega Portugal",
                2.5F,
                2050F,
                false
            ),
            DrinkExpenses(
                1,
                "Cerveja Tauber",
                "https://tendaatacado.vteximg.com.br/arquivos/ids/223492-380-380/975647.jpg",
                0F,
                0F,
                0F,
                3.31F,
                0F,
                "Adega Maracanã",
                2.5F,
                0F,
                false
            ),
            DrinkExpenses(
                1,
                "Cerveja Preta",
                "https://www.imigrantesbebidas.com.br/bebida/images/products/full/255_Cerveja_Petra_Schwarzbier_Escura_500_ml.1534622379.jpg",
                0.21F,
                42F,
                0F,
                4.85F,
                203.7F,
                "Adega Jr Lucci",
                2.5F,
                300F,
                false
            ),
            DrinkExpenses(
                1,
                "Vodka",
                "https://marketup-cdn.s3.amazonaws.com/files/135488/products/5cbed833-fd1a-43ff-9d34-2164c10211e7.jpeg",
                0.333333333F,
                0F,
                0F,
                0F,
                0F,
                "Adega",
                0F,
                0F,
                false
            ),
            DrinkExpenses(
                1,
                "Energético",
                "https://cdn-cosmos.bluesoft.com.br/products/7898049482405",
                0.666666667F,
                0F,
                0F,
                0F,
                0F,
                "Adega",
                0F,
                0F,
                false
            )
        )
    }
}