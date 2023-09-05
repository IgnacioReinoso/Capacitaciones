package com.example.capacitaciones;

import android.app.DownloadManager;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class Curso extends AppCompatActivity {
    VideoView vv1;
    Button play,retro,descargar;
    TextView tiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);

        vv1=findViewById(R.id.videoView);
        play=findViewById(R.id.btn_play);
        retro=findViewById(R.id.btn_retroceder);
        tiempo=findViewById(R.id.txt_tiempo);
        descargar=findViewById(R.id.btn_descargar);


        int orientation=getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE){
            getSupportActionBar().hide();
        }else{
            getSupportActionBar().show();
        }
        //ubicacion del video de la capacitacion
        vv1.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video));

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean pause = false;
                if(vv1.isPlaying()){
                    vv1.pause();
                    pause= true;
                } else if (pause == true) {
                    vv1.start();
                    pause=false;
                }else {
                    vv1.start();
                }
            }
        });

        retro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posicionActual=vv1.getCurrentPosition();
                vv1.seekTo(posicionActual-5000);
            }
        });

        descargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DescargarPDF();
            }
        });

    }
    public void DescargarPDF(){

        System.out.println("ENTRO AL METODO DESCARGA");

        String url= "https://drive.google.com/uc?id=1LECvRAQMgq9ffGu3mmEIEOqP7gNQl587&export=download";
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