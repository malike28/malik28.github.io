package ti_20411041.mc.mc5markus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENTS"
    }

    private var ZooList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        ZooList = ArrayList()


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ZooAdapter(this, ZooList) {
            val intent = Intent(this, DetailZoo::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

        prepareZooListData()
    }

    private fun prepareZooListData() {
        var zoo = DataModel(
            R.drawable.manunited,
            "Manchester United",
            "Manchester United Football Club adalah sebuah klub sepak bola profesional yang berbasis di Old Trafford, Manchester Raya, yang bermain di Liga Utama Inggris dengan gelar Liga Utama Inggris terbanyak sepanjang masa. Didirikan sebagai Newton Heath LYR Football Club pada tahun 1878, klub ini berganti nama menjadi Manchester United pada 1902 dan pindah ke Old Trafford pada tahun 1910."
        )
        ZooList.add(zoo)

        zoo = DataModel(
            R.drawable.liverpool,
            "Liverpool",
            "Manchester United Football Club adalah sebuah klub sepak bola profesional yang berbasis di Old Trafford, Manchester Raya, yang bermain di Liga Utama Inggris dengan gelar Liga Utama Inggris terbanyak sepanjang masa. Didirikan sebagai Newton Heath LYR Football Club pada tahun 1878, klub ini berganti nama menjadi Manchester United pada 1902 dan pindah ke Old Trafford pada tahun 1910."
        )
        ZooList.add(zoo)

        zoo = DataModel(
            R.drawable.city,
            "Manchester City",
            "Manchester United Football Club adalah sebuah klub sepak bola profesional yang berbasis di Old Trafford, Manchester Raya, yang bermain di Liga Utama Inggris dengan gelar Liga Utama Inggris terbanyak sepanjang masa. Didirikan sebagai Newton Heath LYR Football Club pada tahun 1878, klub ini berganti nama menjadi Manchester United pada 1902 dan pindah ke Old Trafford pada tahun 1910."
        )
        ZooList.add(zoo)

        zoo = DataModel(
            R.drawable.arsenal,
            "Arsenal",
            "Manchester United Football Club adalah sebuah klub sepak bola profesional yang berbasis di Old Trafford, Manchester Raya, yang bermain di Liga Utama Inggris dengan gelar Liga Utama Inggris terbanyak sepanjang masa. Didirikan sebagai Newton Heath LYR Football Club pada tahun 1878, klub ini berganti nama menjadi Manchester United pada 1902 dan pindah ke Old Trafford pada tahun 1910."
        )
        ZooList.add(zoo)

        zoo = DataModel(
            R.drawable.chelsea,
            "Chelsea",
            "Manchester United Football Club adalah sebuah klub sepak bola profesional yang berbasis di Old Trafford, Manchester Raya, yang bermain di Liga Utama Inggris dengan gelar Liga Utama Inggris terbanyak sepanjang masa. Didirikan sebagai Newton Heath LYR Football Club pada tahun 1878, klub ini berganti nama menjadi Manchester United pada 1902 dan pindah ke Old Trafford pada tahun 1910."
        )
        ZooList.add(zoo)

        zoo = DataModel(
            R.drawable.totten,
            "Toottenham Hotspur",
            "Manchester United Football Club adalah sebuah klub sepak bola profesional yang berbasis di Old Trafford, Manchester Raya, yang bermain di Liga Utama Inggris dengan gelar Liga Utama Inggris terbanyak sepanjang masa. Didirikan sebagai Newton Heath LYR Football Club pada tahun 1878, klub ini berganti nama menjadi Manchester United pada 1902 dan pindah ke Old Trafford pada tahun 1910."
        )
        ZooList.add(zoo)

        zoo = DataModel(
            R.drawable.fullham,
            "Full Ham",
            "Manchester United Football Club adalah sebuah klub sepak bola profesional yang berbasis di Old Trafford, Manchester Raya, yang bermain di Liga Utama Inggris dengan gelar Liga Utama Inggris terbanyak sepanjang masa. Didirikan sebagai Newton Heath LYR Football Club pada tahun 1878, klub ini berganti nama menjadi Manchester United pada 1902 dan pindah ke Old Trafford pada tahun 1910."
        )
        ZooList.add(zoo)

        zoo = DataModel(
            R.drawable.wesham,
            "West Ham United",
            "Manchester United Football Club adalah sebuah klub sepak bola profesional yang berbasis di Old Trafford, Manchester Raya, yang bermain di Liga Utama Inggris dengan gelar Liga Utama Inggris terbanyak sepanjang masa. Didirikan sebagai Newton Heath LYR Football Club pada tahun 1878, klub ini berganti nama menjadi Manchester United pada 1902 dan pindah ke Old Trafford pada tahun 1910."
        )
        ZooList.add(zoo)
    }
}