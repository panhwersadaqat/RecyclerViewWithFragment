package com.example.sadaqatpanhwer.demonavigationmenu.Menu.HomePage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.example.sadaqatpanhwer.demonavigationmenu.R
import java.util.ArrayList
import android.widget.AdapterView.OnItemClickListener
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import io.reactivex.Observable


class RecyclerFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.recycler_view_fragment, container, false)

        //row list one
        val array_image1 = ArrayList<Int>()
        array_image1.add(R.drawable.a)
        array_image1.add(R.drawable.b)
        array_image1.add(R.drawable.c)
        array_image1.add(R.drawable.d)
        array_image1.add(R.drawable.e)
        array_image1.add(R.drawable.f)
        array_image1.add(R.drawable.g)

        //row list two
        val array_image2 = ArrayList<Int>()
        array_image2.add(R.drawable.d)
        array_image2.add(R.drawable.e)
        array_image2.add(R.drawable.f)
        array_image2.add(R.drawable.g)
        array_image2.add(R.drawable.a)
        array_image2.add(R.drawable.b)
        array_image2.add(R.drawable.c)


        //row list three
        val array_image3 = ArrayList<Int>()
        array_image3.add(R.drawable.e)
        array_image3.add(R.drawable.f)
        array_image3.add(R.drawable.a)
        array_image3.add(R.drawable.b)
        array_image3.add(R.drawable.g)
        array_image3.add(R.drawable.c)
        array_image3.add(R.drawable.d)



        val recyclerView1 = view.findViewById<RecyclerView>(R.id.recycler_view)
        val recyclerView2 = view.findViewById<RecyclerView>(R.id.recycler_viewtwo)
        val recyclerView3 = view.findViewById<RecyclerView>(R.id.recycler_viewthree)





        val horizontalLayoutManagaer = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView1.layoutManager = horizontalLayoutManagaer

        recyclerView1.adapter = RecyclerViewAdapter(array_image1)
        recyclerView2.adapter = RecyclerViewAdapter2(array_image2)
        recyclerView3.adapter = RecyclerViewAdapter3(array_image3)
        return view
    }

    //recycler view holder class
    private inner class RecyclerViewHolder(inflater: LayoutInflater, container: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.card_view, container, false)) {



         val mCardView: CardView
         val mImageView: ImageView

        init {
            mCardView = itemView.findViewById(R.id.card_container)
            mImageView = itemView.findViewById(R.id.image_holder)


//            itemView.setOnClickListener {
//                val position = adapterPosition
//                Toast.makeText(view!!.context, "Item is clicked "+adapterPosition, Toast.LENGTH_SHORT).show()
//            }//end of item click

        }
    }
    //recyler view adaptere class
    private inner class RecyclerViewAdapter(private val array_image: ArrayList<Int>) : RecyclerView.Adapter<RecyclerViewHolder>() {
        override fun onCreateViewHolder(parents: ViewGroup, viewType: Int): RecyclerViewHolder {
            val inflater = LayoutInflater.from(activity)
            return RecyclerViewHolder(inflater, parents)


        }

        override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
         holder.mImageView.setImageResource(array_image[position])
            holder.itemView.setOnClickListener { v ->

            }
        }

        override fun getItemCount(): Int {
            return array_image.size
        }
    }
    //2ndrecyler view adaptere class
    private inner class RecyclerViewAdapter2(private val array_image2: ArrayList<Int>) : RecyclerView.Adapter<RecyclerViewHolder>() {
        override fun onCreateViewHolder(parents: ViewGroup, viewType: Int): RecyclerViewHolder {
            val inflater = LayoutInflater.from(activity)
            return RecyclerViewHolder(inflater, parents)


        }

        override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
            holder.mImageView.setImageResource(array_image2[position])
            holder.itemView.setOnClickListener { v ->

            }
        }
         override fun getItemCount(): Int {
            return array_image2.size
        }
    }

    //3rd recyler view adaptere class
    private inner class RecyclerViewAdapter3(private val array_image3: ArrayList<Int>) : RecyclerView.Adapter<RecyclerViewHolder>() {
        override fun onCreateViewHolder(parents: ViewGroup, viewType: Int): RecyclerViewHolder {
            val inflater = LayoutInflater.from(activity)
            return RecyclerViewHolder(inflater, parents)


        }

        override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
            holder.mImageView.setImageResource(array_image3[position])
            holder.itemView.setOnClickListener { v ->

            }
        }

        override fun getItemCount(): Int {
            return array_image3.size
        }
    }
}
