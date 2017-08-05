package com.angel_fere.mascotas;

/**
 * Created by Angel_Fere on 19/07/2017.
 */

public class Mascotas {

    private int foto;
    private String nombre;
    private int likes;
    private int id;

    public Mascotas(int foto, String nombre, int likes, int id) {
        this.foto = foto;
        this.nombre = nombre;
        this.likes = likes;


        this.id = id;
    }

    public Mascotas() {

    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
