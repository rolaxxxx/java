/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darbuotojas;

import java.util.Comparator;
/**
 *
 * @author rolandas
 */
public class DarbuotojasComparator implements Comparator<Darbuotojas> {
        @Override
        public int compare(Darbuotojas r1, Darbuotojas r2) {
           if(r1.atlygis==r2.atlygis)
           {
               if(r1.pareigos.equals(r2.pareigos))
               {
                   if(r1.gim_met==r2.gim_met){
                       
                   } 
                   else return Integer.compare(r1.gim_met, r2.gim_met);
               }
               else return r1.pareigos.compareTo(r2.pareigos);
           }
            return Double.compare(r1.atlygis, r2.atlygis);
}
}