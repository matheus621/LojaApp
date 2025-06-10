package com.example.lojaapp.data

import com.example.lojaapp.domain.model.Product

class ProductRepository {

    fun getProducts(): List<Product> {
        return listOf(
            Product(
                1,
                "Chuteira Nike Tiempo 10",
                "R$ 245,99",
                "https://imgnike-a.akamaihd.net/1920x1920/027342IMA9.jpg",
                "Chuteiras",
                "Até mesmo as Lendas descobrem formas de evoluir. Quer esteja começando ou apenas jogando por diversão, a mais recente iteração dos calçados Club colocam você em campo sem comprometer a qualidade. Material sintéticom se molda ao seu pé e não estica demais, dando a você melhor controle. Mais leve e elegante do que qualquer outro Tiempo até o momento, o Legend 10 é para qualquer posição no campo, seja enviando um passe preciso pela defesa ou voltando para impedir uma fuga."
            ),
            Product(
                2,
                "Nike Air Max Dn Essential",
                "R$ 699,00",
                "https://imgnike-a.akamaihd.net/1920x1920/094381IDA1.jpg",
                "Tênis",
                "Dê as boas-vindas à próxima geração do Air Max. Este modelo contemporâneo e deslumbrante homenageia o rico legado do Air Max com um cabedal em mesh multicamadas com estampa tátil e iconografia tradicional, detalhes foscos para um visual magnético e um inovador sistema de unidade Dynamic Air, projetado para fazer com que caminhar pareça deslizar no ar."
            ),
            Product(
                3,
                "Nike Air Max 2013",
                "R$ 920,00",
                "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/7a761111-c9ff-4d57-a5cd-3d42b06c4263/AIR+MAX+2013.png",
                "Tênis",
                "O Air Max 2013 retorna com detalhes de malha e sobreposições esportivas sem costura para ajudar a manter você com aparência e sensação de frescor. Além disso, o cadarço Flywire testado e verdadeiro e o amortecimento Air clássico de comprimento total proporcionam conforto e suporte duradouros."
            ),
            Product(
                4,
                "Nike Air Zoom Upturn SC",
                "R$ 399,99",
                "https://imgnike-a.akamaihd.net/1920x1920/058444IFA1.jpg",
                "Tênis",
                "Respirável, leve, durável. O Upturn SC combina mesh arejado com entressola acolchoada e Zoom Air generoso no calcanhar, tornando-o o tênis perfeito para calçar e sair."
            )
        )
    }

    fun getProductById(productId: String): Product? {
        return getProducts().find { it.id.toString() == productId }
    }
}