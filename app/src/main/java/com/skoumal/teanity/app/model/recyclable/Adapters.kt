package com.skoumal.teanity.app.model.recyclable

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.skoumal.teanity.app.BR
import com.skoumal.teanity.databinding.GenericRvItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.internal.toImmutableList

open class GenericAdapter<Item : GenericRvItem>(
    private val extrasBinder: ((ViewDataBinding) -> Unit)? = null
) : RecyclerView.Adapter<GenericAdapter<Item>.BindableViewHolder>() {

    private var internalItems = mutableListOf<Item>()
    val items get() = internalItems.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindableViewHolder {
        return BindableViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return internalItems.size
    }

    override fun onBindViewHolder(holder: GenericAdapter<Item>.BindableViewHolder, position: Int) {
        holder.bind(internalItems[position])
    }

    override fun getItemViewType(position: Int): Int {
        return internalItems[position].layoutRes
    }

    fun callbackFrom(newList: List<Item>) = object : DiffUtil.Callback() {

        private val oldList = internalItems.toImmutableList()
        private val newList = newList.toImmutableList()

        override fun getOldListSize(): Int = oldList.size
        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].sameAs(newList[newItemPosition])
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].contentSameAs(newList[newItemPosition])
        }
    }

    @Synchronized
    fun update(list: List<Item>, diff: DiffUtil.DiffResult) {
        internalItems = list.toMutableList()
        diff.dispatchUpdatesTo(this)
    }

    inner class BindableViewHolder(
        parent: ViewGroup,
        layoutRes: Int
    ) : RecyclerView.ViewHolder(
        DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layoutRes,
            parent,
            false
        ).root
    ) {

        fun bind(item: Item) {
            DataBindingUtil.bind<ViewDataBinding>(itemView)?.also {
                it.setVariable(BR.item, item)
                extrasBinder?.invoke(it)
                it.executePendingBindings()
            }
        }

    }

}

suspend inline fun DiffUtil.Callback.calculateDiff() = withContext(Dispatchers.Default) {
    DiffUtil.calculateDiff(this@calculateDiff)
}