package com.example.restautrant;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;

public class top_frag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_top_frag, container, false);


        CardView cardView = view.findViewById(R.id.addbtn);

        // Set OnClickListener to the CardView
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action when the card is clicked

                // Start the new activity
                Intent intent = new Intent(getActivity(), add_res.class);
                startActivity(intent);

                if (getActivity() != null)
                {
                    getActivity().finish();
                }
            }
        });

        return view;
    }
}
