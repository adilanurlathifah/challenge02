package org.adilanur.challenge02.datasource

import org.adilanur.challenge02.R
import org.adilanur.challenge02.model.Foods


object Menu {
    val menu : List<Any>
        get() = mutableListOf(
            Foods(
                14000,
                "Burger adalah makanan cepat saji yang terdiri dari roti yang diiris menjadi dua bagian, dengan isian pada bagian tengahnya. Isian pada burger biasanya terdiri dari daging sapi cincang (beef patty), sayuran seperti lettuce dan tomat, keju, saus seperti mayones dan saus tomat, serta kadang-kadang diikuti dengan sosis atau ham",
                "Cheese Burger",
                R.drawable.burger,

                ),
            Foods(
                60000,
                "Ayam goreng tepung adalah hidangan ayam yang digoreng dengan tepung yang dicampur dengan berbagai rempah-rempah dan bumbu. Ayam dipotong menjadi beberapa bagian atau dibelah menjadi dua bagian, kemudian dilumuri dengan campuran bumbu tepung dan digoreng hingga kecoklatan dan renyah.",
                "Fried Chicken",
                R.drawable.fried_chicken,
            ),

            Foods(
                219913,
                "Spaghetti adalah hidangan pasta Italia yang terbuat dari mi panjang dengan saus tomat, bawang putih, dan bahan-bahan lain seperti daging sapi cincang, jamur, atau olives. Itu adalah hidangan yang populer dan dapat dijumpai di banyak restoran Italia di seluruh dunia.",
                "Spaghetti",
                R.drawable.spaghetti,

                ),
            Foods(
                9000,
                "Makanan yang berasal dari China, dengan isian daging dan sayuran",
                "Dimsum",
                R.drawable.dimsum,

                ),
            Foods(
                25000,
                "Milkshake terbuat dari susu dan perisa strawberry",
                "Strawberry Milkshake",
                R.drawable.milkshake,

                ),
            Foods(
                4888,
                "Sate khas Indonesia yang terdiri dari daging yang dipanggang dan disajikan dengan bumbu kacang.",
                "Sate",
                R.drawable.sate,
            ),
            Foods(

                92090,
                "Pizza adalah hidangan Italia berupa roti bundar yang dipanggang dengan berbagai topping seperti keju, saus tomat, daging, sayuran, dan rempah-rempah. Pizza sangat populer di seluruh dunia dan sering dijual di restoran cepat saji atau toko makanan.",
                "Pizza",
                R.drawable.pizza_food,
            ),
            )
}