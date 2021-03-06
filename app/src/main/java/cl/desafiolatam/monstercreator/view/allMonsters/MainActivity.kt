package cl.desafiolatam.monstercreator.view.allMonsters

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.constraintlayout.widget.Placeholder
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import cl.desafiolatam.monstercreator.R
import cl.desafiolatam.monstercreator.app.MonsterCreatorApplication
import cl.desafiolatam.monstercreator.databinding.ActivityMainBinding
import cl.desafiolatam.monstercreator.databinding.ContentMainBinding
import cl.desafiolatam.monstercreator.view.monster.MonsterCreatorActivity
import cl.desafiolatam.monstercreator.view.monsteravatars.AdapterMonster
import cl.desafiolatam.monstercreator.viewmodel.AllMonsterViewModel


class MainActivity : AppCompatActivity(), View.OnClickListener {
    val viewModel=AllMonsterViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        val merge=ContentMainBinding.bind(binding.root)
        val adapterMonster=AdapterMonster()
        merge.rvLista.adapter=adapterMonster
        merge.rvLista.layoutManager=LinearLayoutManager(this)
        val listaMonstruos=viewModel.getAllMonsterLiveData()
        viewModel.getAllMonsterLiveData().observe(this,{ listaMonstruos.value?.let { it1 -> adapterMonster.updateMonsterList(it1) } })
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)


        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Create a Monster", Snackbar.LENGTH_LONG)
                .setAction("Continue?", this).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Log.d("actionbutton", "onOptionsItemSelected:$item ")
        return when (item.itemId) {
            R.id.action_settings -> {
                deleteAll()
                true}

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun deleteAll() {
        Log.d("actionbutton", "deleteAll: ")

        viewModel.clearAllCreatures()
    }

    override fun onClick(v: View?) {
        val intent=Intent(this,MonsterCreatorActivity::class.java)
        startActivity(intent)
    }


}
