package cl.desafiolatam.monstercreator.view.monsteravatars

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.monstercreator.databinding.MonsterItemBinding
import cl.desafiolatam.monstercreator.model.Monster

class AdapterMonster : RecyclerView.Adapter<AdapterMonster.MonsterVH>() {
    private val monsterList= mutableListOf<Monster>()
    class MonsterVH(itemView:MonsterItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        val monsterName: TextView =itemView.name
        val monsterPoints:TextView=itemView.MonsterPoints
        val imgMonster: ImageView =itemView.monsterImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonsterVH {
        val binding = MonsterItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MonsterVH(binding)
    }

    override fun onBindViewHolder(holder: MonsterVH, position: Int) {
        val monster=monsterList[position]
        holder.monsterName.text=monster.name
        holder.monsterPoints.text=monster.monsterPoints.toString()
        holder.imgMonster.imageAlpha=monster.drawable
    }

    override fun getItemCount(): Int {
     return monsterList.size
    }
    fun updateMonsterList(plista:List<Monster>)
    {
        monsterList.clear()
        monsterList.addAll(plista)
        notifyDataSetChanged()
    }
}