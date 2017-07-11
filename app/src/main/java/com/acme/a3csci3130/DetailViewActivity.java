package com.acme.a3csci3130;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Used when a user edits/views a single business from the list.
 * User is able to edit or delete the entry from the database.
 */
public class DetailViewActivity extends Activity {

    private MyApplicationData appState;
    private EditText nameField, businessNumberField, primaryBusinessField, addressField, provinceField;
    Business receivedBusinessInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        appState = ((MyApplicationData) getApplicationContext());
        receivedBusinessInfo = (Business)getIntent().getSerializableExtra("Business");

        nameField = (EditText) findViewById(R.id.name);
        businessNumberField = (EditText) findViewById(R.id.businessNumber);
        primaryBusinessField = (EditText) findViewById(R.id.primaryBusiness);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedBusinessInfo != null){
            nameField.setText(receivedBusinessInfo.name, TextView.BufferType.EDITABLE);
            businessNumberField.setText(String.valueOf(receivedBusinessInfo.businessNumber), TextView.BufferType.EDITABLE);
            primaryBusinessField.setText(receivedBusinessInfo.primaryBusiness, TextView.BufferType.EDITABLE);
            addressField.setText(receivedBusinessInfo.address, TextView.BufferType.EDITABLE);
            provinceField.setText(receivedBusinessInfo.province, TextView.BufferType.EDITABLE);
        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality
        receivedBusinessInfo.name = nameField.getText().toString();
        receivedBusinessInfo.primaryBusiness = primaryBusinessField.getText().toString();
        receivedBusinessInfo.businessNumber = Integer.parseInt(businessNumberField.getText().toString());
        receivedBusinessInfo.address = addressField.getText().toString();
        receivedBusinessInfo.province = provinceField.getText().toString();

        appState.firebaseReference.child(receivedBusinessInfo.uid).setValue(receivedBusinessInfo.toMap());

        finish();

    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Delete Confirmation");
        builder.setMessage("Are you sure you want to delete " + receivedBusinessInfo.name+"?\n" +
                "This cannot be undone.");
        builder.setPositiveButton("Confirm",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        appState.firebaseReference.child(receivedBusinessInfo.uid).removeValue();
                        finish();
                    }
                });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
