package se.juneday.systemetappbasic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import se.juneday.systemetappbasic.domain.Product;


public class Activity3_Favoritelist extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3_favoritelist);
    }


    public void onStart() {
        super.onStart();

        ArrayAdapter<Product> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Session.getInstance().favorites);

        ListView listView = findViewById(R.id.favorites_list);

        listView.setAdapter(adapter);

    }

}

