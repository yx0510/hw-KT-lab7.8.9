package com.example.lab7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val gridView = findViewById<GridView>(R.id.gridview)
        val listView = findViewById<ListView>(R.id.listview)

        val count = ArrayList<String>()                     //儲存購買數量資訊
        val item = ArrayList<Item>()                        //儲存水果資訊
        val priceRange = IntRange(10,100)                   //建立價格範圍
        val array =
            resources.obtainTypedArray(R.array.image_list)  //從R類別讀取圖檔
        for(i in 0 until array.length()){
            val photo = array.getResourceId(i,0)    //水果圖片id
            val name = "水果${i+1}"                          //水果名稱
            val price = priceRange.random()                 //亂數產生價格
            count.add("${i+1}個")                           //新增可購買數量資訊
            item.add(Item(photo,name,price))               //新增水果資訊
        }
        array.recycle()                                     //釋放圖檔資源
        spinner.adapter = ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1,count)
        gridView.numColumns = 3
        gridView.adapter = MyAdapter(this,item,R.layout.adapter_vertical)
        listView.adapter = MyAdapter(this,item,R.layout.adapter_horizontal)
    }
}