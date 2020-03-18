/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusasorter.app;

//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.book.app.Buku;
import com.dbutility.app.DbConnection;
import java.sql.PreparedStatement;
import java.util.Collections;
//import.com.dbutility.app.DbConnection;
//import java.util.ListIterator;

/**
 *
 * @author mamen
 */
public class NusaSorter {
    private ArrayList<Buku> nusaList;
    private Buku bk;
    private boolean sorted;
   
    public ArrayList<Buku> getList(){
       nusaList = new ArrayList<Buku>();
       try{
            PreparedStatement pst = DbConnection.getConnection().prepareStatement("SELECT * FROM buku");
//          Statement st = connection.createStatement();
            ResultSet srs = pst.executeQuery();
            while (srs.next()) {
                Buku bk = new Buku();
                bk.setJudul(srs.getString("judul"));
                bk.setAuthor(srs.getString("author"));
                bk.setIdBuku(srs.getInt("idBuku"));
                nusaList.add(bk);
            }
        
            pst.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
//      ListIterator <Buku> iterator;
//            iterator = nusalistAsc.listIterator();
//            while(iterator.hasNext()) {
//                Buku bk = iterator.next();
//                System.out.println("ID Mahasiswa    : "+bk.getIdBuku().toString());
//                System.out.println("Judul Buku      : "+bk.getJudul().toString());
//                System.out.println("Author Buku     : "+bk.getAuthor().toString());
//            }
  
       return nusaList;
    }
    
    public ArrayList<Buku> doBubbleSort(boolean Ascending){
        nusaList = getList();
        
        Buku temp = null;
        if (nusaList.size() > 1){
            for (int x = 0; x < nusaList.size(); x++) {
                sorted = true;
                for (int i = 0; i < (nusaList.size() - x - 1); i++) {
                    //Descending 
                    //for (int i = 0; i < (nusaList.size() - x - 1); i--) {
                    if ((nusaList.get(i).getJudul()).compareToIgnoreCase(nusaList.get(i+1).getJudul()) > 0) {
                        temp = (nusaList.get(i));
                        nusaList.set(i, nusaList.get(i + 1));
                        nusaList.set(i + 1, temp);
                    }

                }

            }
        
        }
        return nusaList;
    }
    
    public ArrayList<Buku> doSelectionSort() {
        Buku bk = new Buku();
        nusaList = getList();
        for (int x=0; x<nusaList.size();x++){
            int min = nusaList.get(x).getIdBuku();
            int minIndex = 1;
            
            for (int y = x+1; y < nusaList.size(); y++) {
                if (nusaList.get(y).getIdBuku() < min) {
                    min = nusaList.get(y).getIdBuku();
                }
            }
            if (x != minIndex) {
                Collections.swap(nusaList, x, minIndex);
            }
        }
        return nusaList;
    }
    
    public ArrayList<Buku> doInsertionSort(){
        nusaList = getList();
        
        for (int x = 1; x<nusaList.size(); x++) {
            Buku baru = new Buku();
            String judulBuku;
            baru.setJudul(nusaList.get(x).getJudul());
            baru.setIdBuku(nusaList.get(x).getIdBuku());
            judulBuku = baru.getJudul();
            int y = x - 1;
            while ((y >= 0) && (judulBuku.compareToIgnoreCase(nusaList.get(y).getJudul()) < 0)) {
                nusaList.set(y+1, nusaList.get(y));
                y--;
            }
            nusaList.set(y+1, baru);
        }
          
//        for (int x = 1; x<nusaList.size(); x++) {
//            Buku baru = new Buku();
//            baru.setJudul(nusaList.get(x).getJudul());
//            baru.setIdBuku(nusaList.get(x).getIdBuku());
//            
//            int y = x;
//            while ((y>=0) && (nusaList.get(y-1).getIdBuku() > baru.getIdBuku())) {
//                nusaList.set(x, nusaList.get(y-1));
//                y--;
//            }
//            nusaList.set(y, baru);
//        }
        return nusaList;
    }
    
    public ArrayList<Buku> doReversed() {
        nusaList = getList();
        ArrayList<Buku> reversedList = new ArrayList<Buku>();
        for (int x = nusaList.size() - 1; x>=0; x-- ) {
            reversedList.add(nusaList.get(x));
        }
        return reversedList;
    }
    
}