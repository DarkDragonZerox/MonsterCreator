package cl.desafiolatam.monstercreator.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.desafiolatam.monstercreator.model.Monster
import cl.desafiolatam.monstercreator.model.MonsterRepository
import kotlinx.coroutines.launch

/**
 * Created by Cristian Vidal on 2019-09-27.
 */

// Class extends AndroidViewModel and requires application as a parameter.
class MonsterCreatorViewModel(application: Application) : AndroidViewModel(application) {



}