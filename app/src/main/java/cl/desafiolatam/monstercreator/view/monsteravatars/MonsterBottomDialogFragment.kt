package cl.desafiolatam.monstercreator.view.monsteravatars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import cl.desafiolatam.monstercreator.R
import cl.desafiolatam.monstercreator.databinding.LayoutMonsterBottomSheetBinding
import cl.desafiolatam.monstercreator.model.MonsterImage
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


/**
 * Created by Cristian Vidal on 2019-10-02.
 */

class MonsterBottomDialogFragment : BottomSheetDialogFragment(), MonsterAdapter.MonsterListener {

    private lateinit var callback: MonsterAdapter.MonsterListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding=LayoutMonsterBottomSheetBinding.inflate(inflater,container,false)
        binding.avatarRecyclerView.layoutManager = GridLayoutManager(context, 3)
        binding.avatarRecyclerView.adapter=MonsterAdapter(MonsterStore.MONSTERS_IMAGE as MutableList<MonsterImage>, this)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        try {
            callback = activity as MonsterAdapter.MonsterListener

        } catch (e: ClassCastException) {
            throw ClassCastException(activity.toString() + " must implement MonsterAdapter.MonsterListener")
        }
    }

    override fun monsterClicked(monsterImage: MonsterImage) {
         callback.monsterClicked(monsterImage)
    }

    companion object {
        fun newInstance(): MonsterBottomDialogFragment {
            return MonsterBottomDialogFragment()
        }
    }
}