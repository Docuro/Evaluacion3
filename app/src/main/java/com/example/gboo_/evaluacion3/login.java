package com.example.gboo_.evaluacion3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class login extends AppCompatActivity {

    EditText edtUser, edtPass;
    private Cursor fila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edtUser = (EditText)findViewById(R.id.edtUser);
        edtPass = (EditText)findViewById(R.id.edtPass);

    }

    public void ingresar (View v){

        if (edtUser.getText().toString().isEmpty() || edtPass.getText().toString().isEmpty()) {

            Toast.makeText(this, "Campos incompletos", Toast.LENGTH_SHORT).show();

        }
        else {

            BaseHelper helper = new BaseHelper(this, "DBUser", null, 1);
            SQLiteDatabase db = helper.getWritableDatabase();
            String name = edtUser.getText().toString();
            String pass = edtPass.getText().toString();
            fila = db.rawQuery("select name,pass from persona where name = '" + name + "' and pass ='" + pass + "'", null);

            if (fila.moveToFirst()) {

                String names = fila.getString(0);
                String pas = fila.getString(1);

                if (name.equals(names) && pass.equals(pas)) {

                    Intent ven = new Intent(this, mensaje.class);
                    startActivity(ven);

                } else {

                    Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_SHORT).show();
                    edtUser.setText("");
                    edtPass.setText("");

                }

            }
            else {

                Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_SHORT).show();
                edtUser.setText("");
                edtPass.setText("");
            }
        }
    }

    public void salir (View v){

        finish();

    }

}
