package cl.desafiolatam.monstercreator.view.monster

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import cl.desafiolatam.monstercreator.R
import cl.desafiolatam.monstercreator.databinding.ActivityMonsterCreatorBinding
import cl.desafiolatam.monstercreator.databinding.ActivityMonsterCreatorBindingImpl
import cl.desafiolatam.monstercreator.model.MonsterAttributes
import cl.desafiolatam.monstercreator.model.MonsterGenerator
import kotlin.math.absoluteValue

class MonsterCreatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMonsterCreatorBindingImpl.inflate(layoutInflater)
        setContentView(binding.root)

        val monsterName=binding.nameEditText.text.toString()
        val monsterImage=binding.avatarImageView.imageAlpha
        val monsterIntelligence=binding.intelligence.selectedItem.toString()
        val monsterEvilness=binding.endurance.selectedItem.toString()
        val monsterUgliness=binding.strength.selectedItem.toString()
        val monsterGenerator=MonsterGenerator()
        val attributes= MonsterAttributes()

        binding.saveButton.setOnClickListener {
            attributes.evilness=monsterEvilness.toInt()
            attributes.intelligence=monsterIntelligence.toInt()
            attributes.ugliness=monsterUgliness.toInt()


            monsterGenerator.generateMonster(attributes,monsterName,monsterImage)


             }



        // in this activity a monster is created




    }
}
