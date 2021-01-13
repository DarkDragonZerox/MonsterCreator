package cl.desafiolatam.monstercreator.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.desafiolatam.monstercreator.app.MonsterCreatorApplication
import cl.desafiolatam.monstercreator.model.Monster
import cl.desafiolatam.monstercreator.model.MonsterRepository
import kotlinx.coroutines.launch

/**
 * Created by Cristian Vidal on 2019-09-27.
 */

// Class extends AndroidViewModel and requires application as a parameter.
class MonsterCreatorViewModel(application: Application) : AndroidViewModel(application) {


    val repository = MonsterRepository(MonsterCreatorApplication.database.monsterDao())


    fun saveCreature(monster: Monster) {
        Log.d("MonsterCreator", "saveCreature: Grabando el monstruo: $monster en la base de datos")
        viewModelScope.launch { repository.monsterBD.monsterDao().insertMonster(monster) }

    }

}