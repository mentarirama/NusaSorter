/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.book.app;

import com.nusasorter.app.NusaSorter;
import java.util.ArrayList;

/**
 *
 * @author mamen
 */
public class MainClass {
    public static void main(String[] args){
        NusaSorter nusa = new NusaSorter();
        ArrayList<Buku> BubbleAscending = new ArrayList<Buku>();
        ArrayList<Buku> SelectionAscending = new ArrayList<Buku>();
        ArrayList<Buku> InsertionAscending = new ArrayList<Buku>();
        ArrayList<Buku> Reversed = new ArrayList<Buku>();
        
        BubbleAscending = nusa.doBubbleSort(true);
        System.out.println("BubbleSort by Title of Book ");
        System.out.println("===============");
        for(int x=0;x<BubbleAscending.size();x++){
            System.out.println("Id Buku  "+BubbleAscending.get(x).getIdBuku()+"\t"+BubbleAscending.get(x).getJudul());
        }
        
        System.out.println("\n");
        SelectionAscending = nusa.doSelectionSort();
        System.out.println("SelectionSort by Title of Book");
        System.out.println("===============");
        for(int x=0;x<SelectionAscending.size();x++){
            System.out.println("Id Buku  "+SelectionAscending.get(x).getIdBuku()+"\t"+SelectionAscending.get(x).getJudul());
        }
        
        System.out.println("\n");
        InsertionAscending = nusa.doInsertionSort();
        System.out.println("InsertionSort by Title of Book");
        System.out.println("===============");
        for(int x=0;x<InsertionAscending.size();x++){
            System.out.println("Id Buku  "+InsertionAscending.get(x).getIdBuku()+"\t"+InsertionAscending.get(x).getJudul());
        }
        
        System.out.println("\n");
        Reversed = nusa.doReversed();
        System.out.println("ReversedSort by Id of Book");
        System.out.println("===============");
        for(int x=0;x<Reversed.size();x++){
            System.out.println("Id Buku  "+Reversed.get(x).getIdBuku()+"\t"+Reversed.get(x).getJudul());
        }
    }
}
