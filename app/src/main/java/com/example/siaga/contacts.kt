package com.example.siaga

import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.ContactsContract.CommonDataKinds
import android.provider.ContactsContract.Contacts
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class contacts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contacts)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
       read()
    }
    fun read (){
        var cursor : Cursor? = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null)
        startManagingCursor(cursor)

        var from = arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER)

        var to  = intArrayOf(android.R.id.text1,android.R.id.text2)

        var simple : SimpleCursorAdapter = SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cursor,from,to)
        var list_contacts = findViewById<ListView>(R.id.list_contacts)
        list_contacts.adapter = simple

    }
}