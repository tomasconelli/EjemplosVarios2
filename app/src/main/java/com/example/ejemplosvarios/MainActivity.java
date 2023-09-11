package com.example.ejemplosvarios;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.Toolbar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private Button btn1, btn2, btn3;
    private ImageButton imgbtn1;
    private RadioButton rb1, rb2;
    private ProgressBar pb1;
    private CheckBox cb1, cb2, cb3;
    private RatingBar rbar1;
    private ToggleButton tb1;
    private Toolbar toolbar;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.et1);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        imgbtn1 = (ImageButton) findViewById(R.id.imgbtn1);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        pb1 = (ProgressBar) findViewById(R.id.pb1);
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        rbar1 = (RatingBar) findViewById(R.id.rbar1);
        tb1 = (ToggleButton) findViewById(R.id.tb1);


        capturarID();
        comprobarRB1();
        comprobarRB2();
        prog();
        cambiaEstado();
    }
    public void setSupportActionBar( Toolbar toolbar){

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return true;
    }

    public void capturarID(){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et1.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "El ID esta vacío!!!", Toast.LENGTH_SHORT).show();
                }else{
                    int id = Integer.parseInt(et1.getText().toString());
                    Toast.makeText(MainActivity.this, "El ID es : "+id, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void  comprobarRB1(){
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo = rb1.getText().toString();
                Toast.makeText(MainActivity.this, "El RadioButton seleccionado es: "+tipo, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void  comprobarRB2(){
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo = rb2.getText().toString();
                Toast.makeText(MainActivity.this, "El RadioButton seleccionado es: "+tipo, Toast.LENGTH_SHORT).show();
            }
        });
    }
    //Metodo para comprobar radio button con un boton
    public void comprobarRadioButton(View v){
        String tipo = "";
        if (rb1.isChecked()){
            tipo = rb1.getText().toString();
        }else{
            tipo = rb2.getText().toString();
        }
        Toast.makeText(MainActivity.this, "El RadioButton seleccionado es: "+tipo, Toast.LENGTH_SHORT).show();
    }

    public  void prog(){
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Timer t = new Timer();
                TimerTask tt = new TimerTask() {
                    @Override
                    public void run() {
                        contador++;
                        pb1.setProgress(contador);
                        if (contador==100)
                            t.cancel();
                    }
                };
                t.schedule(tt, 0, 100);
            }
        });
    }
    public void comprobarCbox(View v){
        String comprobarCB1 = "";
        String comprobarCB2 = "";
        String comprobarCB3 = "";
        String etiqueta = null;
        if (cb1.isChecked()==true)
            comprobarCB1 = cb1.getText().toString();
        if (cb2.isChecked()==true)
            comprobarCB2 = cb2.getText().toString();
        if (cb3.isChecked()==true)
            comprobarCB3 = cb3.getText().toString();
        if (comprobarCB1=="" && comprobarCB2=="" && comprobarCB3=="") {
            Toast.makeText(MainActivity.this, "Usted no ha seleccionado ninguna opción!!!", Toast.LENGTH_SHORT).show();
        }else {
            etiqueta = (comprobarCB1+" "+comprobarCB2+" "+comprobarCB3);
            Toast.makeText(MainActivity.this, "Lo opciones seleccionadas son: "+etiqueta, Toast.LENGTH_SHORT).show();
        }

    }

    public  void  cuantasEstrellas(View v){
        Toast.makeText(MainActivity.this, "Usted ha otorgado: "+rbar1.getRating()+" estrellas!!!", Toast.LENGTH_SHORT).show();

    }

    public void cambiaEstado(){
        et1.setEnabled(false);
        btn1.setEnabled(false);
        tb1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (tb1.isChecked()){
                    et1.setEnabled(true);
                    btn1.setEnabled(true);
                }else{
                    et1.setEnabled(false);
                    btn1.setEnabled(false);
                }
            }
        });
    }
// prueba
    //prueba2


}