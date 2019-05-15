package com.example.recyclerviewexample

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {

    var imageAdapter: ImageRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageAdapter = ImageRecyclerAdapter(arrayListOf())
        testList.apply {
            adapter = imageAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(SpacingItemDecoration(8, context))
        }
        addItemButton.setOnClickListener {v ->
            imageAdapter?.apply{
                val rnd = Random().nextInt(300)
                val item = ImageObject("Ciccio Pascuccio", "1${rnd+700}", rnd)
                items.add(item)
                notifyItemInserted(items.size-1)
            }

        }
    }

}
