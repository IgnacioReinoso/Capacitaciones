package com.example.capacitaciones;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Menu extends AppCompatActivity {
    private RecyclerView rv1;
    ArrayList<DatosCursos> lista_cursos = new ArrayList<DatosCursos>();
    Adapter adapter = new Adapter(this ,lista_cursos);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Bundle datos=getIntent().getExtras();
        String rut_usuario=datos.getString("rut");

        System.out.println(rut_usuario);

        rv1 = findViewById(R.id.recyclerView);
        rv1.setLayoutManager(new GridLayoutManager(this,1));

        CargarCursos(rut_usuario);

        rv1.setAdapter(adapter);

    }

    private void CargarCursos(String rut_usuario){

        String url="https://capacitacioneseisesa.cl/APP/Consulta_curso.php";

        StringRequest stringRequest=new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONArray jsonArray = new JSONArray(response);
                    for(int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        DatosCursos datosCursos = new DatosCursos(
                                jsonObject1.getString("id_curso"),
                                jsonObject1.getString("nombre_curso"),
                                jsonObject1.getString("imagen_curso"),
                                jsonObject1.getString("link_video"),
                                jsonObject1.getString("link_documento"),
                                jsonObject1.getString("link_documento2"),
                                jsonObject1.getString("link_documento3"),
                                jsonObject1.getString("link_documento4"));
                        lista_cursos.add(datosCursos);
                    }
                    adapter.notifyDataSetChanged();

                }catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Menu.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String,String>();
                parametros.put("rut",rut_usuario);
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}