package com.example.gboo_.evaluacion3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class mensaje extends AppCompatActivity {

    EditText edtUser, edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mensaje);
    }

    public void exit(View view){

        Intent ven = new Intent(mensaje.this, index.class);
        startActivity(ven);

    }
}
