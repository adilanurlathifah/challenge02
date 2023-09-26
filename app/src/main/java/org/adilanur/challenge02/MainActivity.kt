package org.adilanur.challenge02

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), MenuRVAdapter.OnItemClickListener {

    private lateinit var menuRV: RecyclerView
    private lateinit var menuRVAdapter: MenuRVAdapter
    private lateinit var menuList: ArrayList<Menu>
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private var isGridLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuRV = findViewById(R.id.idRVMenus)
        menuList = ArrayList()
        layoutManager = GridLayoutManager(this, 2)

        menuRVAdapter = MenuRVAdapter(menuList, this, this, isGridLayoutManager)
        menuRV.adapter = menuRVAdapter
        menuRV.layoutManager = layoutManager

        menuList.add(Menu("Burger", "Burger adalah makanan cepat saji yang terdiri dari roti yang diiris menjadi dua bagian, dengan isian pada bagian tengahnya. Isian pada burger biasanya terdiri dari daging sapi cincang (beef patty), sayuran seperti lettuce dan tomat, keju, saus seperti mayones dan saus tomat, serta kadang-kadang diikuti dengan sosis atau ham", R.drawable.burger))
        menuList.add(Menu("Dimsum", "Dimsum adalah hidangan tradisional Cina yang terdiri dari makanan kecil atau snack yang disajikan dalam porsi kecil dan biasanya dimakan sebagai sarapan atau makan ringan.", R.drawable.dimsum))
        menuList.add(Menu("Cappucinno", "cappuccino adalah minuman kopi yang terbuat dari espresso, susu dan busa susu. ", R.drawable.cappucinno))
        menuList.add(Menu("Ayam Goreng", "Ayam goreng tepung adalah hidangan ayam yang digoreng dengan tepung yang dicampur dengan berbagai rempah-rempah dan bumbu. Ayam dipotong menjadi beberapa bagian atau dibelah menjadi dua bagian, kemudian dilumuri dengan campuran bumbu tepung dan digoreng hingga kecoklatan dan renyah. ", R.drawable.fried_chicken))
        menuList.add(Menu("Sate", "Sate khas Indonesia yang terdiri dari daging yang dipanggang dan disajikan dengan bumbu kacang.", R.drawable.sate))
        menuList.add(Menu("Sushi", "Sushi adalah makanan khas Jepang yang terdiri dari nasi yang dibentuk menjadi bola kecil atau gulungan, yang dicampur dengan cuka beras dan diisi dengan segala macam bahan seperti ikan mentah, udang, telur, sayuran, dan lain-lain. ", R.drawable.sushi))
        menuList.add(Menu("Kentang Goreng", "Kentang goreng adalah makanan yang terbuat dari kentang yang dipotong memanjang menjadi bentuk batang-batang kecil yang kemudian digoreng hingga warnanya menjadi kecoklatan dan teksturnya menjadi renyah di luar serta lembut di dalam. ", R.drawable.fried_fries))
        menuList.add(Menu("Milkshake", "Milkshake adalah minuman yang terbuat dari campuran susu, es krim, dan sirup atau bahan lain sebagai pemanisnya. Minuman ini sering dijajakan di toko es krim dan restoran.", R.drawable.milkshake))
        menuList.add(Menu("Spaghetti", "Spaghetti adalah hidangan pasta Italia yang terbuat dari mi panjang dengan saus tomat, bawang putih, dan bahan-bahan lain seperti daging sapi cincang, jamur, atau olives. Itu adalah hidangan yang populer dan dapat dijumpai di banyak restoran Italia di seluruh dunia.", R.drawable.spaghetti))
        menuList.add(Menu("Pizza", "Pizza adalah hidangan Italia berupa roti bundar yang dipanggang dengan berbagai topping seperti keju, saus tomat, daging, sayuran, dan rempah-rempah. Pizza sangat populer di seluruh dunia dan sering dijual di restoran cepat saji atau toko makanan.", R.drawable.pizza_food))
        menuList.add(Menu("Sate Telur Gulung", "Sate Telur Gulung adalah hidangan Indonesia yang terbuat dari telur ayam rebus yang digulung dengan daging sapi atau ayam cincang, dan dibuat seperti sate dengan tusuk sate. ", R.drawable.sate_telur_gulung))

        menuRVAdapter.notifyDataSetChanged()

    }

    override fun onItemClick(menu: Menu) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("menuName", menu.menuName)
        intent.putExtra("menuDetail", menu.menuDetail)
        intent.putExtra("menuImg", menu.menuImg)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                toggleLayoutManager(item)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun toggleLayoutManager(item: MenuItem) {
        if (isGridLayoutManager) {
            layoutManager = LinearLayoutManager(this)
            item.setIcon(R.drawable.ic_grid)
        } else {
            layoutManager = GridLayoutManager(this, 2)
            item.setIcon(R.drawable.ic_list)
        }
        isGridLayoutManager = !isGridLayoutManager
        menuRVAdapter = MenuRVAdapter(menuList, this, this, isGridLayoutManager)
        menuRV.adapter = menuRVAdapter
        menuRV.layoutManager = layoutManager
    }
}