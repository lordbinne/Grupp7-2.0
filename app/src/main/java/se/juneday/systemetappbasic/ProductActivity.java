package se.juneday.systemetappbasic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

import se.juneday.systemetappbasic.domain.Product;


public class ProductActivity extends AppCompatActivity {

    private static final String LOG_TAG = ProductActivity.class.getSimpleName();
    private Product currentProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_activity);


        // extract the Product pass in the bundle
        Bundle extras = getIntent().getExtras();
        currentProduct = (Product) extras.get("product");
        // display the product
        displayProduct();


    }

    private void setViewText(int viewId, String label, String text) {
        TextView tv = findViewById(viewId);
        tv.setText(Html.fromHtml("<b>" + label + "</b>: " + text));
        Log.d(LOG_TAG, " * " + label + " | " + text);
    }

    private void displayProduct() {
        setViewText(R.id.product_name, "Name", currentProduct.name());
        setViewText(R.id.product_volume, "Volume", String.valueOf(currentProduct.volume()));
        setViewText(R.id.product_alcohol, "Alcohol", String.valueOf(currentProduct.alcohol()));
        setViewText(R.id.product_price, "Price", String.valueOf(currentProduct.price()));
    }

    public void addToFavorite(View view) {
        Log.d(LOG_TAG, "addToFavorite");
        ToggleButton tb = (ToggleButton) view;
        if (tb.isChecked()) {
            Log.d(LOG_TAG, "addToFavorite: adding " + currentProduct);
            Session.getInstance().favorites.remove(currentProduct);
            Session.getInstance().favorites.add(currentProduct);
        } else {
            Log.d(LOG_TAG, "addTFavorite: removing " + currentProduct);
            Session.getInstance().favorites.remove(currentProduct);
        }
        Log.d(LOG_TAG, "addTFavorite: favorites: " + Session.getInstance().favorites);
    }
}