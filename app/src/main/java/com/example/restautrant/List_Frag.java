package com.example.restautrant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import static android.content.Context.MODE_PRIVATE;

public class List_Frag extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        List<MyDataModel> data = new ArrayList<>();

        data.add(new MyDataModel("Butt Sweets", "Township", "0330-2346789", "Bakery Items","3.9"));
        data.add(new MyDataModel("Bandu Khan", "Gulberg", "042-2348769", "Traditional food", "4.5"));
        data.add(new MyDataModel("Rizwan Burger", "Gulberg", "042-9998887", "Traditional & Fast food", "4.3"));
        data.add(new MyDataModel("Fast Cafe", "Faisal Town", "042-12348765", "Mix Items", "2.5"));
        data.add(new MyDataModel("Savour Foods", "Samnabad", "0333-9876542", "Rice", "4.7"));
        data.add(new MyDataModel("NY-212", "DHA", "0324-1234567", "Pizza", "4.9"));


        List<MyDataModel> restaurantList = loadRestaurantList();


        if (restaurantList != null && !restaurantList.isEmpty())
        {

            for (MyDataModel restaurant : restaurantList) {

                data.add(new MyDataModel(restaurant.getText1(), restaurant.getText2(), restaurant.getText3(), restaurant.getText4(), restaurant.getText5()));
            }
        }

        MyAdapter adapter = new MyAdapter(requireContext(), data);
        recyclerView.setAdapter(adapter);
    }

    private List<MyDataModel> loadRestaurantList() {
        SharedPreferences preferences = requireActivity().getSharedPreferences("restaurant_data", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = preferences.getString("restaurant_list", null);
        Type type = new TypeToken<List<MyDataModel>>() {}.getType();
        return gson.fromJson(json, type);
    }
}
