package com.thdlopes.appgerenciame;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    List<CategoryModel> categoryList;
    Context context;

    public CategoryAdapter(List<CategoryModel> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_category, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CategoryModel categories = categoryList.get(position);
        holder.textViewName.setText(categories.getName());

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
        }


    }

}
