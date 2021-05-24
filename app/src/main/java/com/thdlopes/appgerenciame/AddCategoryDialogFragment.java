package com.thdlopes.appgerenciame;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddCategoryDialogFragment extends AppCompatDialogFragment {

    private EditText editTextName;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_add_category_dialog, null);
        builder.setView(view)
                .setTitle("Cadastro de Categoria")
                .setPositiveButton("Enviar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                            String name = editTextName.getText().toString();
                            Toast.makeText(getContext(), name, Toast.LENGTH_SHORT).show();
                            Log.v("Neymar", name);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        AddCategoryDialogFragment.this.getDialog().cancel();
                    }
                });

        editTextName = view.findViewById(R.id.editTextName);
        return builder.create();
    }

}