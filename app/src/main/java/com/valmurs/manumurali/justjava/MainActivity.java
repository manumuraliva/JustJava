package com.valmurs.manumurali.justjava;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {

        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.creamCheck);
        boolean checkStatus = whippedCreamCheckbox.isChecked();

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
//        Log.v("MainActivity","Whipped"+checkStatus);
        String message = "Thank You " + name + ".";
        if (checkStatus) {
            message += "\n\n You ordered for whipped cream coffee.";
        } else {
            message += "\n\n You ordered for normal coffee.";

        }

        displayPrice(quantity, message, checkStatus);

    }

    public void increment(View view) {

        quantity = quantity + 1;
        displayQuantity(quantity);

    }

    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);

    }


    private void displayQuantity(int noOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + noOfCoffees);
    }

    private void displayPrice(int quantity, String message, boolean checkStatus) {
        TextView orderSummaryTextView = (TextView) findViewById(
                R.id.order_summary_text_view);
        int cost = calculatePrice(quantity, checkStatus);
        orderSummaryTextView.setText("$" + cost + "\n" + "\n" + message);
    }

    private int calculatePrice(int quantity, boolean checkStatus) {

        int price;
        if (checkStatus) {
            price = quantity * (10 + 2);

        } else {
            price = quantity * 10;

        }
        return price;
    }


}
