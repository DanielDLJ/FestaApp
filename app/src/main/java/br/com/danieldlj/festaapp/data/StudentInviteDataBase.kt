package br.com.danieldlj.festaapp.data

import br.com.danieldlj.festaapp.domain.Invite
import br.com.danieldlj.festaapp.domain.Post


class StudentInviteDataBase {

    companion object{

        fun getItems() = mutableListOf(
            Invite(
                1,
                1,
                "Promocional",
                2.0F,
                0,
                0.0F,
                1
            ),
            Invite(
                1,
                1,
                "1º Lote (reps)",
                4.0F,
                50,
                200.0F,
                1
            ),
            Invite(
                1,
                1,
                "1º Lote",
                4.0F,
                130,
                520.0F,
                1
            ),
            Invite(
                1,
                1,
                "2º lote",
                7.0F,
                0,
                0.0F,
                1
            ),
            Invite(
                    1,
                1,
            "3º lote",
            20.0F,
            0,
            0.0F,
            1
            ),
            Invite(
                1,
                1,
                "Porta",
                10.0F,
                0,
                0.0F,
                1
            )
        )
    }
}