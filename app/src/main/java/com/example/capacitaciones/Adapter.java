package com.example.capacitaciones;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {

    Context context;
    List<DatosCursos> lista_cursos;

    public Adapter(Context context, List<DatosCursos>lista_cursos){
        this.context = context;
        this.lista_cursos = lista_cursos;
    }

    @NonNull
    @Override
    public Adapter.AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cursos,viewGroup,false);
        return new AdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.AdapterViewHolder adapterViewHolder, int i) {

        adapterViewHolder.txt_curso.setText(lista_cursos.get(i).getNombre_curso());
        adapterViewHolder.id_curso = lista_cursos.get(i).getId_curso();
        adapterViewHolder.imagen_curso = lista_cursos.get(i).getImagen_curso();
        adapterViewHolder.link_video = lista_cursos.get(i).getLink_video();
        adapterViewHolder.documento1 = lista_cursos.get(i).getDocumento1();
        adapterViewHolder.documento2 = lista_cursos.get(i).getDocumento2();
        adapterViewHolder.documento3 = lista_cursos.get(i).getDocumento3();
        adapterViewHolder.documento4 = lista_cursos.get(i).getDocumento4();


    }

    @Override
    public int getItemCount() {
        return lista_cursos.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        TextView txt_curso;
        String id_curso,imagen_curso,link_video,documento1,documento2,documento3,documento4;
        Button iniciar;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_curso = itemView.findViewById(R.id.txt_curso);
            iniciar = itemView.findViewById(R.id.btn_curso);

        }
    }

}
