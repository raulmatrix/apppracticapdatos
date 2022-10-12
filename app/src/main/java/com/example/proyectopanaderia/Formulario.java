package com.example.proyectopanaderia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Formulario extends AppCompatActivity {


    EditText nombre,apellido,codEst,fechaNac,direccion;
    RadioButton sexo;
    Spinner departamento;
    Spinner carrera;
    //datos cuando la app esta funcionando
    RadioGroup radioGroup;
    String datoSexo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        getSupportActionBar().hide();

        nombre = (EditText) findViewById(R.id.txtnombre);
        apellido = (EditText) findViewById(R.id.txtapellidos);
        codEst = (EditText) findViewById(R.id.txtcodest);
        fechaNac = (EditText) findViewById(R.id.txtfechanac);
        direccion = (EditText) findViewById(R.id.txtdire);
        departamento = (Spinner)findViewById(R.id.listadpto);
        carrera = (Spinner)findViewById(R.id.listacarrera);
        sexo = (RadioButton) findViewById(R.id.rbsexo);


        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rgsexo1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbsexo){
                    datoSexo = "Hombre";
                } else {
                    datoSexo = "Mujer";
                }
            }
        });
    }


    public void registrarEstudiante(View v){

        String nombre1 = nombre.getText().toString();
        String apellido1 = apellido.getText().toString();
        String codEst1 = codEst.getText().toString();
        String fechaNac1 = fechaNac.getText().toString();
        String dire = direccion.getText().toString();
        String sexo1 = datoSexo;
        String itemDpto = departamento.getSelectedItem().toString();

        String itemCarrera = carrera.getSelectedItem().toString();
        //insertando en el objeto Estudiante creado
        Estudiante est = new Estudiante(nombre1,apellido1,fechaNac1,codEst1,sexo1,dire,itemDpto,itemCarrera);
        //paso de valor al otro activity
        Intent it = new Intent(getApplicationContext(),DatosEstudiante.class);
        //empaquetar datos, datos serializados
        Bundle bun = new Bundle();
        bun.putSerializable("datosest",est);
        //enviar hacia el otro activity
        it.putExtras(bun);
        startActivity(it);


    }
}