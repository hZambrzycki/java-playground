/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones;

import java.time.LocalDate;

/**
 *
 * @author huber
 */
public class Publicacion {
    private int codigo;
    private String titulo;
    private LocalDate año;

    @Override
    public String toString() {
        return "Publicacion{" + "codigo=" + codigo + ", titulo=" + titulo + ", a\u00f1o=" + año + '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getAño() {
        return año;
    }

    public void setAño(LocalDate año) {
        this.año = año;
    }

    public Publicacion(int codigo, String titulo, LocalDate año) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.año = año;
    }
}
