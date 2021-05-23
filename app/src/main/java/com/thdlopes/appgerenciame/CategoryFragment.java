package com.thdlopes.appgerenciame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {

    public CategoryFragment() {

    }

    private RecyclerView recyclerViewCategories;
    private List<CategoryModel> categoryList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_category, container, false);
        montarLista();

        recyclerViewCategories = view.findViewById(R.id.recycleViewCategories);

        CategoryAdapter categoryAdapter = new CategoryAdapter(categoryList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());

        recyclerViewCategories.setLayoutManager(layoutManager);
        recyclerViewCategories.setHasFixedSize(true);
        recyclerViewCategories.addItemDecoration(new DividerItemDecoration(view.getContext(), LinearLayout.VERTICAL));
        recyclerViewCategories.setAdapter(categoryAdapter);

        return view;

    }

    public void montarLista() {
        CategoryModel category = new CategoryModel("Água");
        categoryList.add(category);
        CategoryModel category2 = new CategoryModel("Luz");
        categoryList.add(category2);
        CategoryModel category3 = new CategoryModel("Gás");
        categoryList.add(category3);
    }

}
