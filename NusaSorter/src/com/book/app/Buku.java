/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.book.app;

/**
 *
 * @author mamen
 */
public class Buku {
    private int idBuku;
    private String judul;
    private String author;
            
    public int getIdBuku() {
        return idBuku;
    }
 
    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }
 
    public String getJudul() {
        return judul;
    }
 
    public void setJudul(String judul) {
        this.judul = judul;
    }
 
    public String getAuthor() {
        return author;
    }
 
    public void setAuthor(String author) {
        this.author = author;
    }
}
