package cl.desafiolatam.monstercreator.model

import androidx.lifecycle.LiveData
import cl.desafiolatam.monstercreator.app.MonsterCreatorApplication
import cl.desafiolatam.monstercreator.model.db.MonsterDao

/**
 * Created by Cristian Vidal on 2019-09-26.
 */

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class MonsterRepository(private val monsterDao: MonsterDao):MonsterRepositoryInterface {
    val monsterBD=MonsterCreatorApplication.database

    override fun saveMonster(monster: Monster) {
        monsterBD.monsterDao().insertMonster(monster)
    }

    override fun getAllMonsters(): LiveData<List<Monster>> {
        return monsterBD.monsterDao().getAllMonsters()

    }

    override fun clearAllMonsters(value: List<Monster>) {
       for (monster in value){
        monsterBD.monsterDao().deleteAllMonsters(monster)}
    }

}
interface MonsterRepositoryInterface {
    fun saveMonster(monster: Monster)
    fun getAllMonsters(): LiveData<List<Monster>>
    fun clearAllMonsters(value: List<Monster>)
}