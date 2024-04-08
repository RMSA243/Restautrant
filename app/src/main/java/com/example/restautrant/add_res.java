package com.example.restautrant;

import android.os.Bundle;
import android.view.View;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class add_res extends AppCompatActivity {

    private EditText res_nameEditText;
    private EditText res_locEditText;
    private EditText res_phoneEditText;

    private EditText res_desEditText;
    private EditText res_ratEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_res);


        res_nameEditText = findViewById(R.id.res_nameEditText);
        res_locEditText = findViewById(R.id.res_locEditText);
        res_phoneEditText = findViewById(R.id.res_phoneEditText);
        res_desEditText = findViewById(R.id.res_desEditText);
        res_ratEditText = findViewById(R.id.res_ratEditText);

        Button signUpButton = findViewById(R.id.addBtn);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = res_nameEditText.getText().toString().trim();
                String location = res_locEditText.getText().toString().trim();
                String phone = res_phoneEditText.getText().toString().trim();
                String descrip = res_desEditText.getText().toString().trim();
                String rat = res_ratEditText.getText().toString().trim();


                // Check if any field is empty
                if (name.isEmpty() || location.isEmpty() || phone.isEmpty() || descrip.isEmpty() || rat.isEmpty())
                {

                    Toast.makeText(add_res.this,"Please fill in all the details", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    saveRestaurantData(name, location, phone, descrip, rat);

                    Intent intent = new Intent(add_res.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        });

        //for exit button
        Button exitButton = findViewById(R.id.exitBtn);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //close the app
                Intent intent = new Intent(add_res.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void saveRestaurantData(String name, String location, String phone, String description, String rating) {
        // Retrieve existing restaurant data list from SharedPreferences
        List<MyDataModel> restaurantList = loadRestaurantList();


        restaurantList.add(new MyDataModel(name, location, phone, description, rating));

        // Save updated restaurant data list to SharedPreferences
        saveRestaurantList(restaurantList);
    }

    private void saveRestaurantList(List<MyDataModel> restaurantList) {
        SharedPreferences preferences = getSharedPreferences("restaurant_data", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(restaurantList);
        editor.putString("restaurant_list", json);
        editor.apply();
    }

    private List<MyDataModel> loadRestaurantList() {
        SharedPreferences preferences = getSharedPreferences("restaurant_data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = preferences.getString("restaurant_list", null);
        Type type = new TypeToken<List<MyDataModel>>() {}.getType();
        List<MyDataModel> restaurantList = gson.fromJson(json, type);
        if (restaurantList == null) {
            restaurantList = new ArrayList<>();
        }
        return restaurantList;
    }
}