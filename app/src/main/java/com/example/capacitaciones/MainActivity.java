package com.example.capacitaciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText txt_rut,txt_pass;
    Button btn_iniciar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_rut = findViewById(R.id.txt_rut);
        txt_pass = findViewById(R.id.txt_pass);
        btn_iniciar = findViewById(R.id.btn_login);

        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rut = txt_rut.getText().toString();
                String pass = txt_pass.getText().toString();

                if(txt_rut.getText().length()==0 || txt_pass.getText().length()==0) {
                    Toast.makeText(MainActivity.this, "Llenar Campos vacios", Toast.LENGTH_SHORT).show();
                } else {
                    Login("https://capacitacioneseisesa.cl/APP/Validar_login.php");
                }
            }
        });


    }

    private void Login(String URL){

        StringRequest stringRequest=new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.isEmpty()){
                    Toast.makeText(MainActivity.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent=new Intent(getApplicationContext(),Menu.class);
                    String rut = txt_rut.getText().toString();
                    intent.putExtra("rut",rut);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                System.out.println(error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String,String>();
                parametros.put("rut",txt_rut.getText().toString());
                parametros.put("pass",txt_pass.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}