/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darbuotojas;

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
public class Darbuotojas {
     String vardas;
     String pareigos;

   
     int gim_met;
     double atlygis;
     @Override
     public String toString() { 
    return " " + this.vardas.toUpperCase() + " " + this.pareigos.toUpperCase() + " " + this.gim_met + " " + Math.round(this.atlygis* 100.0 ) /100.0  ;
    }
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
       String content = new Scanner(new File("C:\\Users\\rolandas\\Documents\\NetBeansProjects\\Darbuotojas\\src\\darbuotojas\\duomenys.txt")).useDelimiter("\\Z").next();
                //System.out.println(content);
                int index=0;
            StringTokenizer st = new StringTokenizer(content, "/ ");
            List<Darbuotojas> darbuotojas = new ArrayList<>();
            
                while (st.hasMoreTokens()&&index<5) {
                    Darbuotojas tempdarbuotojas= new Darbuotojas();
                    tempdarbuotojas.vardas=st.nextToken();
                    //System.out.println(tempdarbuotojas.vardas);
                    tempdarbuotojas.pareigos=st.nextToken();
                    tempdarbuotojas.gim_met=Integer.parseInt(st.nextToken());
                    tempdarbuotojas.atlygis=Double.parseDouble(st.nextToken());
                    //System.out.println(tempdarbuotojas.atlygis);
                    darbuotojas.add(index, tempdarbuotojas);   
                    System.out.println(darbuotojas.get(index).gim_met);
                    index++;
     }
      Collections.sort(darbuotojas,new DarbuotojasComparator());
      System.out.println(darbuotojas.get(0));
      for(int i=0;i<index;i++){
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
    }
    
}
