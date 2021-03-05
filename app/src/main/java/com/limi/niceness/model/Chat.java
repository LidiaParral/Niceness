package com.limi.niceness.model;

public class Chat {

    private String enviado;
    private String recibido;
    private String message;
    private boolean visto;

    public Chat(String enviado, String recibido, String message, boolean visto) {
        this.enviado = enviado;
        this.recibido = recibido;
        this.message = message;
        this.visto = visto;
    }

    public Chat() {

    }

    public String getEnviado() {
        return enviado;
    }

    public void setEnviado(String enviado) {
        this.enviado = enviado;
    }

    public String getRecibido() {
        return recibido;
    }

    public void setRecibido(String recibido) {
        this.recibido = recibido;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }
}
