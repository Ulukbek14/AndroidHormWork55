package com.example.androidhormwork55;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterBook adapterBook;
    private List<TaskModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        list = new ArrayList<>();
        list.add(new TaskModel("Java", "Особенности языка Java. ... Относится к объектно-ориентированным языкам программирования, к языкам с сильной типизацией. Java является объектно-ориентированным языком, относится к языкам программирования с сильной типизацией. Создатели реализовали принцип WORA: write once, run anywhere или «пиши один раз, запускай везде».",R.drawable.java));
        list.add(new TaskModel("C++", "Особенности C++ 1.Эфективность. Язык C++ позволяет писать программы, напрмямую работать с железом. 2.Стандарртированность.Спецификация языка Cявляется международным стандартном. 3.Относительная простота.Стандарт языка Cзанимает 230 страниц (против 670 для Java и 1340 для C++)",R.drawable.c));
        list.add(new TaskModel("JS", "Особенности JS 1.Полная интеграция с HTML/CSS 2.Подерживается всемираспространёнными браузерами и включён по умолцанию. 3.Нестрогая тилизация",R.drawable.js));
        list.add(new TaskModel("Python", "Особенности Python 1.Python - интерперетируемый язык программирование.Это значит, что исходный код частями преобразуется в машинный в процессе его чтения специальной программой - интерпретатором 2.Python характеризуется ясным синтаксиксом, т.к. в мало испольхуются такие вспомогательные синтаксические элементы как скобки точки с запятым 3.Правила языка заставляют программистов делать отступы для обозначения вложенных конструкций",R.drawable.python));
        adapterBook = new AdapterBook(list);
        recyclerView.setAdapter(adapterBook);
        adapterBook.setOnitemClickistener(new OnitemClickistener() {
            @Override
            public void itemClick(int position) {
                Intent intent = new Intent(MainActivity.this, ScondActivity.class);
                intent.putExtra("name",list.get(position).getName());
                intent.putExtra("description", list.get(position).getDescription());
                startActivity(intent);
            }
        });


    }
}