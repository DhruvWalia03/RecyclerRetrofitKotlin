package com.example.retrofitkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var DataList = ArrayList<RecyclerData>()

    fun setListData(data: ArrayList<RecyclerData>) {
        this.DataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.activity_card_view_design, parent,false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(DataList[position])
    }

    override fun getItemCount(): Int {
        return DataList.size
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val  exg_id = view.findViewById<TextView>(R.id.exchg_id)
        val  symbol = view.findViewById<TextView>(R.id.symbol)
        val  priceunc = view.findViewById<TextView>(R.id.textView)
        val  price = view.findViewById<TextView>(R.id.textView2)
        val  change24 = view.findViewById<TextView>(R.id.textView3)
        val  spread = view.findViewById<TextView>(R.id.textView4)
        val  volume24 = view.findViewById<TextView>(R.id.textView5)
        val  status = view.findViewById<TextView>(R.id.textView6)
        val  time = view.findViewById<TextView>(R.id.textView7)

        fun bindData (item: RecyclerData) {
            this.exg_id.text = item.exchange_id
            this.symbol.text = item.symbol
            this.priceunc.text = item.price_unconverted
            this.price.text = item.price
            this.change24.text = item.change_24h
            this.spread.text = item.spread
            this.volume24.text = item.volume_24h
            this.status.text = item.status
            this.time.text = item.time
        }
    }
}