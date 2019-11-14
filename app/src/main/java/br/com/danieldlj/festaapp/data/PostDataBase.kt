package br.com.danieldlj.festaapp.data

import br.com.danieldlj.festaapp.domain.Post


class PostDataBase {

    companion object{

        fun getItems() = mutableListOf(
            Post(
                1,
                "Bar + Inicio das Vendas",
                "Bebidas + Preços + Preço de Ingresso",
                "27/06/2019",
                "10:00",
                "BCC",
                "",
                true
            ),
            Post(
                2,
                "Welcome Shot",
                "Welcome shot",
                "28/06/2019",
                "10:00",
                "BCC",
                "",
                false
            ),
            Post(
                3,
                "Piercing date",
                "Horário 15:30 - 18:00",
                "28/06/2019",
                "13:00",
                "BCC",
                "Durante o início do role, teremos o mano do piercing com um stand para colocar piercing na galera",
                true
            ),
            Post(
                4,
                "Sorteio",
                "Sorteio Piercing + Seguir insta do piercing + Confirmar Presença",
                "28/06/2019",
                "18:00",
                "BCC",
                "",
                false
            ),
            Post(
                5,
                "Bar + Inicio das Vendas",
                "Bebidas + Preços + Preço de Ingresso",
                "27/06/2019",
                "10:00",
                "BCC",
                "Sorteio tradicional, confirmar presença no evento, marcar um amiguinho",
                true
            )
        )
    }
}