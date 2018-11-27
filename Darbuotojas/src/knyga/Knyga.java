/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knyga;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author rolandas
 */
public class Knyga {
     String leidykla;
     String pavadinimas;
     int leidimoMetai;
     double kaina;
     @Override
     public String toString() { 
    return " " + this.leidykla.toUpperCase() + " " + this.pavadinimas.toUpperCase() + " " + this.leidimoMetai + " " + Math.round(this.kaina* 100.0 ) /100.0  ;
    }
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
       String content = new Scanner(new File("C:\\Users\\rolandas\\Documents\\NetBeansProjects\\Knyga\\src\\duomenys.txt")).useDelimiter("\\Z").next();
                //System.out.println(content);
                int index=0;
            StringTokenizer st = new StringTokenizer(content, "/");
            List<Knyga> darbuotojas = new ArrayList<>();
            
                while (st.hasMoreTokens()&&index<5) {
                    Knyga tempknyga= new Knyga();
                    tempknyga.leidykla=st.nextToken();
                    //System.out.println(tempdarbuotojas.vardas);
                    tempknyga.pavadinimas=st.nextToken();
                    tempknyga.leidimoMetai=Integer.parseInt(st.nextToken());
                    tempknyga.kaina=Double.parseDouble(st.nextToken());
                    //System.out.println(tempdarbuotojas.atlygis);
                    darbuotojas.add(index, tempknyga);   
                    //System.out.println(darbuotojas.get(index).gim_met);
                    index++;
     }
     /* Collections.sort(darbuotojas,new KnygaComparator());
      for(int i=0;i<darbuotojas.size();i++){
          System.out.println(darbuotojas.get(i));
      }
      Scanner sc=new Scanner(System.in);
      int data=sc.nextInt();
      PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
      for(int i=0;i<index;i++){
          if(data==darbuotojas.get(i).gim_met)
              writer.println(darbuotojas.get(i));
      }
      writer.close();
*/
    }
    
}
