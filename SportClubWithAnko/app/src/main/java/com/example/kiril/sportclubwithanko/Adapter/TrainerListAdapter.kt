package com.example.kiril.sportclubwithanko.Adapter
import android.support.v7.widget.ListPopupWindow.MATCH_PARENT
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.kiril.sportclubwithanko.ComponentsAnco.TrainerListView
import com.example.kiril.sportclubwithanko.TrainerInfo


class TrainerListAdapter(
        private val trainers: TrainerInfo.List) : RecyclerView.Adapter<TrainerListAdapter.TrainerListViewHolder>()
{
    class TrainerListViewHolder(val view : TrainerListView) : RecyclerView.ViewHolder(view) {

    }

    override fun getItemCount() = trainers.size

    override fun onBindViewHolder(holder: TrainerListViewHolder, position: Int) {
        val trainerV = holder.view
        val trainer = trainers[position]
        trainerV.bind(trainer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : TrainerListAdapter.TrainerListViewHolder {

        val view = TrainerListView(parent.context)
        view.layoutParams = RecyclerView.LayoutParams(MATCH_PARENT, 400)

        return TrainerListViewHolder(view)
    }
}