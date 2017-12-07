package com.example.gboo_.evaluacion3;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registro extends AppCompatActivity {

    EditText edtUser, edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        edtUser = (EditText)findViewById(R.id.edtUser);
        edtPass = (EditText)findViewById(R.id.edtPass);

    }

    public void agregar(View v) {

    if (edtUser.getText().toString().isEmpty() || edtPass.getText().toString().isEmpty()) {

        Toast.makeText(this, "Campos incompletos", Toast.LENGTH_SHORT).show();

        }
        else {

            BaseHelper helper = new BaseHelper(this, "DBUser", null, 1);
            SQLiteDatabase db = helper.getWritableDatabase();

            try {

                String name = edtUser.getText().toString();
                String pass = edtUser.getText().toString();

                ContentValues c = new ContentValues();
                c.put("name", name);
                c.put("pass", pass);
                db.insert("persona", null, c);
                db.close();
                Toast.makeText(this, "Registro agregado", Toast.LENGTH_SHORT).show();
                edtUser.setText("");
                edtPass.setText("");

            } catch (Exception e) {

                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();

            }

        }

    }

}
