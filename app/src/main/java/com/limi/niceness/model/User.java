package com.limi.niceness.model;

public class User {

    private String id;
    private String username;
    private String imageURL;
    private String estado;
    private String buscar;

    public User(String id, String username, String imageURL, String estado, String buscar) {
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
        this.estado = estado;
        this.buscar = buscar;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }
}
