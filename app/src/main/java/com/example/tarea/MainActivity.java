package com.example.tarea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextView a;
    private AutoCompleteTextView autoCompleteTextView;
    private ToggleButton toggleButton;
    private TextInputLayout textInputLayout;
    private RadioButton bencina,diesel;
    private Button guardar;
    private EditText textoGuardado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Seccion autocompletetextView
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , getResources().getStringArray(R.array.listaPaises));
        autoCompleteTextView.setAdapter(adapter);

        //Serccion TogleButton
        toggleButton = findViewById(R.id.toggleButton);

        //Seccion TextInputLayout
        textInputLayout = findViewById(R.id.textInputLayout);

        //Seccion RadioButton
        bencina = findViewById(R.id.buttonBencina);
        diesel = findViewById(R.id.buttonDiesel);


        //TextoGuardado
        textoGuardado = findViewById(R.id.editTextTextMultiLine);
        textoGuardado.setEnabled(false);
        //Button Guardar

        guardar = findViewById(R.id.textGuardar);

    }
    public void mostrarGuardados(View v){
        textoGuardado.setText("");

        textoGuardado.append(autoCompleteTextView.getText()+"\n");

        if (toggleButton.isChecked()) textoGuardado.append("On"+"\n");
        else textoGuardado.append("Off"+"\n");

        textoGuardado.append(textInputLayout.getEditText().getText()+"\n");

        if (bencina.isChecked()) textoGuardado.append("Bencina"+"\n");
        if (diesel.isChecked()) textoGuardado.append("Diesel"+"\n");

    }

    public void selectionbuttonBencina(View view){
        if (bencina.isChecked() == true) diesel.setChecked(false);
    }
    public void selectionButtonDiesel(View view){
        if (diesel.isChecked() == true) bencina.setChecked(false);
    }
}