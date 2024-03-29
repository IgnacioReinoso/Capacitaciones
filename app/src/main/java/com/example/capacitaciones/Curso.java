package com.example.capacitaciones;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Curso extends AppCompatActivity {
    VideoView vv1;
    ImageButton descargar,descargar2,descargar3,descargar4;
    EditText txt_documento1,txt_documento2,txt_documento3,txt_documento4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);

        vv1=findViewById(R.id.videoView);
        descargar=findViewById(R.id.btn_descargar);
        descargar2=findViewById(R.id.btn_descargar2);
        descargar3=findViewById(R.id.btn_descargar3);
        descargar4=findViewById(R.id.btn_descargar4);
        txt_documento1=findViewById(R.id.txt_documento1);
        txt_documento2=findViewById(R.id.txt_documento2);
        txt_documento3=findViewById(R.id.txt_documento3);
        txt_documento4=findViewById(R.id.txt_documento4);

        Bundle datos=getIntent().getExtras();
        String id_curso=datos.getString("id_curso");
        String nombre_curso=datos.getString("nombre_curso");
        String link_video=datos.getString("link_video");
        String documento1=datos.getString("documento1");
        String documento2=datos.getString("documento2");
        String documento3=datos.getString("documento3");
        String documento4=datos.getString("documento4");

        System.out.println(id_curso);
        System.out.println(nombre_curso);
        System.out.println(link_video);
        System.out.println(documento1);
        System.out.println(documento2);
        System.out.println(documento3);
        System.out.println("Documnento numero 4" + ""+documento4);


        vv1.setVideoURI(Uri.parse(link_video));

        MediaController mediaController = new MediaController(this);
        vv1.setMediaController(mediaController);
        mediaController.setAnchorView(vv1);


        if(documento1.length()==0){
            txt_documento1.setVisibility(View.INVISIBLE);
            descargar.setVisibility(View.INVISIBLE);
        }
        if (documento2.length()==0) {
            txt_documento2.setVisibility(View.INVISIBLE);
            descargar2.setVisibility(View.INVISIBLE);
        }
        if (documento3.length()==0) {
            txt_documento3.setVisibility(View.INVISIBLE);
            descargar3.setVisibility(View.INVISIBLE);
        }
        if (documento4.length()==0) {
            txt_documento4.setVisibility(View.INVISIBLE);
            descargar4.setVisibility(View.INVISIBLE);
        }


        descargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DescargarPDF(documento1);
            }
        });
        descargar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DescargarPDF(documento2);
            }
        });
        descargar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DescargarPDF(documento3);
            }
        });
        descargar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DescargarPDF(documento4);
            }
        });




    }
    public void DescargarPDF(String url){

        System.out.println("ENTRO AL METODO DESCARGA");

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Descargando Archivo");
        request.setDescription("Descargar archivo......");

        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"" + System.currentTimeMillis());

        DownloadManager manager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
        Toast.makeText(Curso.this, "Descargando Archivo...", Toast.LENGTH_SHORT).show();
        System.out.println("FINALIZO EL METODO DESCARGA");

    }
}