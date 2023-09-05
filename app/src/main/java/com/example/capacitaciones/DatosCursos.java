package com.example.capacitaciones;

public class DatosCursos {

    private String id_curso;
    private String nombre_curso;
    private String imagen_curso;
    private String link_video;
    private String documento1;
    private String documento2;
    private String documento3;
    private String documento4;

    public DatosCursos(String id_curso, String nombre_curso, String imagen_curso, String link_video, String documento1, String documento2, String documento3, String documento4) {
        this.id_curso = id_curso;
        this.nombre_curso = nombre_curso;
        this.imagen_curso = imagen_curso;
        this.link_video = link_video;
        this.documento1 = documento1;
        this.documento2 = documento2;
        this.documento3 = documento3;
        this.documento4 = documento4;

    }

    public String getId_curso() {
        return id_curso;
    }

    public void setId_curso(String id_curso) {
        this.id_curso = id_curso;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public String getImagen_curso() {
        return imagen_curso;
    }

    public void setImagen_curso(String imagen_curso) {
        this.imagen_curso = imagen_curso;
    }

    public String getLink_video() {
        return link_video;
    }

    public void setLink_video(String link_video) {
        this.link_video = link_video;
    }

    public String getDocumento1() {
        return documento1;
    }

    public void setDocumento1(String documento1) {
        this.documento1 = documento1;
    }

    public String getDocumento2() {
        return documento2;
    }

    public void setDocumento2(String documento2) {
        this.documento2 = documento2;
    }

    public String getDocumento3() {
        return documento3;
    }

    public void setDocumento3(String documento3) {
        this.documento3 = documento3;
    }

    public String getDocumento4() {
        return documento4;
    }

    public void setDocumento4(String documento4) {
        this.documento4 = documento4;
    }
}
