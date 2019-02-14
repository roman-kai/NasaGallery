package roman.kai.nasagallery.ui.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Roman K. on 14/02/2019
 */
open class SimpleViewHolder (v: View): RecyclerView.ViewHolder(v){

    val context: Context by lazy { itemView.context }

    constructor(parent: ViewGroup, layoutId: Int):
            this(LayoutInflater.from(parent.context).inflate(layoutId,parent,false))
}