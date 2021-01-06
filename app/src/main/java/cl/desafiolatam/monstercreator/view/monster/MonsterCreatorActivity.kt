package cl.desafiolatam.monstercreator.view.monster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.desafiolatam.monstercreator.R

class MonsterCreatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monster_creator)


        // in this activity must place a recyclerView with all the monster on the DB
    }
}
