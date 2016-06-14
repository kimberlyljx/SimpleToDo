package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    Integer position;
    EditText etEditItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String itemText = getIntent().getStringExtra("item_text");
        position = getIntent().getIntExtra("position", 0);
        etEditItem = (EditText)findViewById(R.id.etEditItem);

        try {
            etEditItem.setText(itemText);
        }
        // what are the best practices for this?
        catch(NullPointerException e) {
            etEditItem.setText("");
        }

        // send cursor to back of text
        etEditItem.setSelection(etEditItem.getText().length());
    }

    public void onSubmit(View v) {
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        etEditItem = (EditText)findViewById(R.id.etEditItem);
        data.putExtra("item_text", etEditItem.getText().toString());
        data.putExtra("position", position);
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }
}