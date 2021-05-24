package com.thdlopes.appgerenciame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {

    public CategoryFragment() {

    }
    private FloatingActionButton buttonAddCategory;
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

        buttonAddCategory = view.findViewById(R.id.buttonAddCategory);
        buttonAddCategory.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void openDialog(){
        AddCategoryDialogFragment dialog = new AddCategoryDialogFragment();
        dialog.show(
                getChildFragmentManager(), "Add Category Dialog");
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
