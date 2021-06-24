package com.example.retrofitkotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitkotlin.databinding.ActivityMainBinding
import com.example.retrofitkotlin.retrofit.RetroService
import com.example.retrofitkotlin.retrofit.Retrostance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        intiRecyclerView()
        createData()
    }

    private fun intiRecyclerView() {
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter
        }
    }

    fun createData() {
        val retrostance = Retrostance.getRetroInstance().create(RetroService::class.java)
        val call = retrostance.getDatafromAPI()
        call.enqueue(object : Callback<RecyclerList>{
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                if(response.isSuccessful) {
                    recyclerViewAdapter.setListData(response.body()?.markets!!)
                    recyclerViewAdapter.notifyDataSetChanged()
                }
                else {
                    Toast.makeText(this@MainActivity,"ERROR FETCHING THE GSON",Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                Toast.makeText(this@MainActivity,"ERROR FETCHING THE GSON",Toast.LENGTH_LONG).show()
            }
        })
    }
}