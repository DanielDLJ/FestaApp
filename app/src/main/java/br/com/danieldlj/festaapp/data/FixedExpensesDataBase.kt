package br.com.danieldlj.festaapp.data

import br.com.danieldlj.festaapp.domain.FixedExpenses


class FixedExpensesDataBase {

    companion object{

        fun getItems() = listOf(
            FixedExpenses(
                1,
                "Local",
                3000.0F,
                false
            ),
            FixedExpenses(
                1,
                "Segurança",
                200.0F,
                true
            ),
            FixedExpenses(
                1,
                "Som/Iluminação",
                400.0F,
                false
            ),
            FixedExpenses(
                1,
                "Fotografia",
                100.0F,
                false
            ),
            FixedExpenses(
                1,
                "Convites",
                32.0F,
                true
            ),
            FixedExpenses(
                1,
                "EVA (Cartaz e ficha)",
                150.0F,
                false
            ),
            FixedExpenses(
                1,
                "Tenda",
                111.10F,
                true
            )
        )
    }
}