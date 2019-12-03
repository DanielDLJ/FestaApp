package br.com.danieldlj.festaapp.data

import br.com.danieldlj.festaapp.domain.Post


class PostDataBase {

    companion object{

        fun getItems() = mutableListOf(
            Post(
                1,
                1,
                "Bar + Inicio das Vendas",
                "Bebidas + Preços + Preço de Ingresso",
                "27/06/2019",
                "BCC",
                "",
                true
            ),
            Post(
                2,
                1,
                "Welcome Shot",
                "Welcome shot",
                "28/06/2019",
                "BCC",
                "",
                false
            ),
            Post(
                3,
                1,
                "Piercing date",
                "Horário 15:30 - 18:00",
                "28/06/2019",
                "BCC",
                "Durante o início do role, teremos o mano do piercing com um stand para colocar piercing na galera",
                true
            ),
            Post(
                4,
                1,
                "Sorteio",
                "Sorteio Piercing + Seguir insta do piercing + Confirmar Presença",
                "28/06/2019",
                "BCC",
                "",
                false
            ),
            Post(
                5,
                1,
                "Bar + Inicio das Vendas",
                "Bebidas + Preços + Preço de Ingresso",
                "27/06/2019",
                "BCC",
                "Sorteio tradicional, confirmar presença no evento, marcar um amiguinho",
                true
            )
        )
    }
}