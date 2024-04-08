package com.example.restautrant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<MyDataModel> mData;
    private LayoutInflater mInflater;

    public MyAdapter(Context context, List<MyDataModel> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.fragment_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyDataModel item = mData.get(position);
        holder.textView1.setText(item.getText1());
        holder.textView2.setText(item.getText2());
        holder.textView3.setText(item.getText3());
        holder.textView4.setText(item.getText4());
        holder.textView5.setText(item.getText5());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2, textView3, textView4, textView5;
        CardView cardView;

        ViewHolder(View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
            textView4 = itemView.findViewById(R.id.textView4);
            textView5 = itemView.findViewById(R.id.textView5);

            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
