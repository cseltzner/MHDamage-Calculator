package com.example.mhdamagecalculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val dataSet: List<Int>)
    :RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val imageView: ImageView
            val eqDmgTextView: TextView

            init {
                imageView = view.findViewById(R.id.weapon_list_image)
                eqDmgTextView = view.findViewById(R.id.equivalent_dmg_textview)
            }
        }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var imageRes: Int
        when (position) {
            0 -> imageRes = R.drawable.great_sword_icon_white
            1 -> imageRes = R.drawable.long_sword_icon_white
            2 -> imageRes = R.drawable.sword_and_shield_icon_white
            3 -> imageRes = R.drawable.dual_blades_icon_white
            4 -> imageRes = R.drawable.hammer_icon_white
            5 -> imageRes = R.drawable.hunting_horn_icon_white
            6 -> imageRes = R.drawable.lance_icon_white
            7 -> imageRes = R.drawable.gunlance_icon_white
            8 -> imageRes = R.drawable.switch_axe_icon_white
            9 -> imageRes = R.drawable.charge_blade_icon_white
            10 -> imageRes = R.drawable.insect_glaive_icon_white
            11 -> imageRes = R.drawable.light_bowgun_icon_white
            12 -> imageRes = R.drawable.heavy_bowgun_icon_white
            13 -> imageRes = R.drawable.bow_icon_white
            else -> imageRes = R.drawable.great_sword_icon_white
        }

        holder.imageView.setImageResource(imageRes)
        val eqDmgText = "${holder.itemView.context.getString(R.string.attack)} ${dataSet[position]}"
        holder.eqDmgTextView.text = eqDmgText
    }
}