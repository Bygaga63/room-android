package com.example.googleroom;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase database = Room
                .databaseBuilder(this, AppDatabase.class, "mydb")
                .allowMainThreadQueries()
                .build();


        ItemDAO itemDAO = database.getItemDAO();
//        Item item = new Item();
//        item.setName("Item001");
//        item.setDescription("Item 001");
//        item.setQuantity(1000L);

//        itemDAO.insert(item);
        List<Item> items = itemDAO.getItems();
        System.out.println(items);
    }
}
