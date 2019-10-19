package br.com.danieldlj.festaapp.data

import br.com.danieldlj.festaapp.domain.Party


class AllPartyDataBase {

    companion object{

        fun getItems() = listOf(
            Party(
                1,
                "DiretOrgia",
                "#ffffff",
                "https://coverfiles.alphacoders.com/992/99262.png"
            ),
            Party(
                2,
                "Tequilada",
                "#000000",
                "https://timelinecovers.pro/facebook-cover/download/party_time-facebook-cover.jpg"
            ),
            Party(
                3,
                "ECAD 2000",
                "#000000",
                "https://fbcover.com/covers-images/download/work_hard_party_harder_Dancing.jpg"
            ),
            Party(
                4,
                "Mixtureba",
                "#000000",
                "https://fbcover.com/covers-images/download/work_hard_party_harder_Dancing.jpg"
            ),
            Party(
                4,
                "Halloween",
                "#ffffff",
                "https://golifehacks.info/wp-content/uploads/2017/10/Halloween-Party-facebook-cover-10.jpg"
            )
        )
    }
}