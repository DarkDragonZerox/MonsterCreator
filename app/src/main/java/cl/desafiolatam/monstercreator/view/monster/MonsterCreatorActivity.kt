package cl.desafiolatam.monstercreator.view.monster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import cl.desafiolatam.monstercreator.app.MonsterCreatorApplication
import cl.desafiolatam.monstercreator.databinding.ActivityMonsterCreatorBindingImpl
import cl.desafiolatam.monstercreator.model.MonsterAttributes
import cl.desafiolatam.monstercreator.model.MonsterGenerator
import cl.desafiolatam.monstercreator.model.MonsterImage
import cl.desafiolatam.monstercreator.view.monsteravatars.MonsterAdapter
import cl.desafiolatam.monstercreator.view.monsteravatars.MonsterBottomDialogFragment
import cl.desafiolatam.monstercreator.viewmodel.MonsterCreatorViewModel

class MonsterCreatorActivity : AppCompatActivity(), MonsterAdapter.MonsterListener {

    // in this activity a monster is created
    var monsterLiveImage=MutableLiveData<MonsterImage>()

    val application= MonsterCreatorApplication()


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("TAG", "onCreate: el valor de monsterliveImage es: ${monsterLiveImage.value}")
        super.onCreate(savedInstanceState)
        val binding=ActivityMonsterCreatorBindingImpl.inflate(layoutInflater)
        setContentView(binding.root)
        monsterLiveImage.observe(this, Observer {
            Log.d("TAG", "onCreate: observando cambios en ${monsterLiveImage.value} ")
            binding.avatarImageView.imageAlpha = it.drawable
        })
        val viewModel=MonsterCreatorViewModel(application)
        val monsterGenerator=MonsterGenerator()
        val attributes= MonsterAttributes()

        binding.saveButton.setOnClickListener {


            val monsterName=binding.nameEditText.text.toString()
            val monsterImage=binding.avatarImageView.imageAlpha
            val monsterIntelligence=binding.intelligence.selectedItem.toString()
            val monsterEvilness=binding.endurance.selectedItem.toString()
            val monsterUgliness=binding.strength.selectedItem.toString()

            attributes.evilness=monsterEvilness.toInt()
            attributes.intelligence=monsterIntelligence.toInt()
            attributes.ugliness=monsterUgliness.toInt()

            Log.d("SaveMonster","MonsterName: $monsterName")
            Log.d("SaveMonster","MonsterAtributes: $attributes")



            val monster=monsterGenerator.generateMonster(attributes,monsterName,monsterImage)
            Log.d("SaveMonster", "onCreate: guardando el Monstruo: $monster")
            viewModel.saveCreature(monster)



             }


        binding.avatarImageView.setOnClickListener {
            supportFragmentManager.
            beginTransaction().
            add(MonsterBottomDialogFragment.newInstance(),"").
            addToBackStack("volver").
            commit()
        }








    }

    override fun monsterClicked(monsterImage: MonsterImage) {
        Log.d("Monsterclicked", "monsterClicked: $monsterImage")
        monsterLiveImage.value=monsterImage

    }
}
