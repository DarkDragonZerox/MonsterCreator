package cl.desafiolatam.monstercreator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.desafiolatam.monstercreator.app.MonsterCreatorApplication
import cl.desafiolatam.monstercreator.model.Monster
import cl.desafiolatam.monstercreator.model.MonsterRepository
import cl.desafiolatam.monstercreator.model.MonsterRepositoryInterface
import kotlinx.coroutines.launch

/**
 * Created by Cristian Vidal on 2019-10-02.
 */
class AllMonsterViewModel(
    private val monsterRepository: MonsterRepositoryInterface =
        MonsterRepository(MonsterCreatorApplication.database.monsterDao()) ) : ViewModel() {
    private val allMonsterLiveData = monsterRepository.getAllMonsters()
    fun getAllMonsterLiveData(): LiveData<List<Monster>> = allMonsterLiveData
    fun clearAllCreatures() = allMonsterLiveData.value?.let {
        viewModelScope.launch { monsterRepository.clearAllMonsters(it) }
         }
}


