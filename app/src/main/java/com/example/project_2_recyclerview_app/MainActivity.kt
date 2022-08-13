package com.example.project_2_recyclerview_app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.project_2_recyclerview_app.adapter.HotelAdapter
import com.example.project_2_recyclerview_app.dataSource.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Connect the adapter with the data here
        // Bind the recyclerview and the adapter here

        val hotelList = DataSource().loadHotels()
        val adapter = HotelAdapter(hotelList, this)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

        adapter.setOnClickListener(object : HotelAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                when (position) {
                    0 -> {
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(getString(R.string.novotelc_url))
                        startActivity(intent)
                    }
                    1 -> {
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(getString(R.string.carawan_url))
                        startActivity(intent)
                    }
                    2 -> {
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(getString(R.string.damac_url))
                        startActivity(intent)
                    }
                    3 -> {
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(getString(R.string.radison_url))
                        startActivity(intent)
                    }
                    4 -> {
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(getString(R.string.damac_url))
                        startActivity(intent)
                    }
                    5 -> {
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(getString(R.string.carawan_url))
                        startActivity(intent)
                    }
                    6 -> {
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(getString(R.string.damac_url))
                        startActivity(intent)
                    }
                    7 -> {
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(getString(R.string.radison_url))
                        startActivity(intent)
                    }

                }
            }

        })

    }
}