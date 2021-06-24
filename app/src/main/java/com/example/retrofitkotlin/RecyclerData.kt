package com.example.retrofitkotlin

data class RecyclerList(val markets: ArrayList<RecyclerData>)

data class RecyclerData(val exchange_id:String,val symbol:String,val price_unconverted:String,
                        val price:String, val change_24h:String,val spread:String,
                        val volume_24h:String,val status:String,val time:String)