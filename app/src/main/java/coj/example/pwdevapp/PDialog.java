package coj.example.pwdevapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import coj.example.pwdevapp.R;

public  class PDialog extends DialogFragment {

        private final View.OnClickListener exitListener;


        public PDialog(View.OnClickListener exitListener) {
            this.exitListener = exitListener;
        }


        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());


            builder.setTitle("Alert");
            builder.setMessage("This user is already exist, Do you want to update?");
            builder.setPositiveButton("Update",new DialogInterface.OnClickListener(){
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