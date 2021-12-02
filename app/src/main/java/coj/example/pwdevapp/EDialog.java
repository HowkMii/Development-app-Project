package coj.example.pwdevapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

import coj.example.pwdevapp.R;

public  class EDialog extends DialogFragment {

    private final View.OnClickListener exitListener;
    ArrayList<CharSequence> arrayListCollection = new ArrayList<>();
    ArrayAdapter<CharSequence> adapter;
    EditText txt;

    public EDialog(View.OnClickListener exitListener) {
        this.exitListener = exitListener;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        final EditText editTextName1 = new EditText(requireContext());

        builder.setTitle("Add Evaluation");
        builder.setMessage("Enter the student Note ");
        builder.setMessage("Enter the student Note ");
        builder.setView(editTextName1);
        builder.setPositiveButton("Valide",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface var1, int var2){
                exitListener.onClick(null);
            }
        });
        builder.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface var1, int var2){
                dismiss();
            }
        });

        return builder.create();



    }


}