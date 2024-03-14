package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val contactList = listOf(
            contactModel(R.drawable.image1,"Vimal"),
            contactModel(R.drawable.image2,"Rahul"),
            contactModel(R.drawable.image3,"Rakesh"),
            contactModel(R.drawable.image4,"Vijay"),
            contactModel(R.drawable.image5,"Shikhar"),
            contactModel(R.drawable.image6,"Gaurav")
        )

        val listView = findViewById<ListView>(R.id.listView)
        val adapter = ContactAdapter(this, contactList)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val item = contactList[position]
            val intent = Intent(this, MainActivity2::class.java).apply {
                putExtra("image", item.image)
                putExtra("name", item.name)
            }
            startActivity(intent)
        }
    }

    data class contactModel(var image: Int , var name: String)

    private class ContactAdapter(context: Context, contacts: List<contactModel>) :
        ArrayAdapter<contactModel>(context, 0, contacts) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            // Setting up the view
            val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false)

            // Finding views inside the inflated view
            val imageView = view!!.findViewById<ImageView>(R.id.imageView)
            val nameTextView = view.findViewById<TextView>(R.id.textView)

            // Binding data to views
            imageView.setImageResource(getItem(position)!!.image)
            nameTextView.text = getItem(position)!!.name

            // Returning the configured view
            return view
        }
    }
}
