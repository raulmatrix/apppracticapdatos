package com.example.proyectopanaderia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DatosEstudiante extends AppCompatActivity {

    TextView nombre,apellido,fechanac,sexo,dire,dpto,carre,codes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_estudiante);
        getSupportActionBar().hide();

        nombre = (TextView) findViewById(R.id.txtnom2);
        apellido = (TextView)findViewById(R.id.txtape2);
        fechanac = (TextView)findViewById(R.id.txtfnac2);
        sexo = (TextView)findViewById(R.id.txtsexo2);
        dire = (TextView)findViewById(R.id.txtdir2);
        dpto = (TextView)findViewById(R.id.txtdpto2);
        carre = (TextView)findViewById(R.id.txtcarr2);
        codes = (TextView)findViewById(R.id.txtcodes2);

        //Desempaquetar los datos recibidos, deserializar datos
        Bundle objRecibido = getIntent().getExtras();
        Estudiante est = null;

            est = (Estudiante) objRecibido.getSerializable("datosest");
            //mostrar por pantalla
            nombre.setText(est.getNombre().toString());
            apellido.setText(est.getApellido().toString());
            fechanac.setText(est.getFechaNac().toString());
            sexo.setText(est.getSexo().toString());
            dire.setText(est.getDireccion().toString());
            dpto.setText(est.getDpto().toString());
            carre.setText(est.getCarrera().toString());
            codes.setText(est.getCodEst().toString());


    }
}