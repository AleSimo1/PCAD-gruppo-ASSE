/*
	Gruppo 18: Un viaggio
	Componenti:
		* Alessandro Simoni S5029301
		* Simone Lutero S4801326
		* Eleonora Fabbri S4842235
		* Samuele Osti S4816869
*/

package Lab2;

import java.util.*;

public class NumeriPrimi {
    public static void main(String[] args) {
        //Genero numero random tra 1 e 100
        Random rand = new Random();
        int n = rand.nextInt(100)+1;

        //Controllo che il numero non sia 1
        if(n == 1){
            //Se lo è, stampo solo 1
            System.out.println("1");
        }else{
            //Altrimenti, creo un ArrayList di numeri da 1 a n
            ArrayList<Integer> numberList = new ArrayList<>();

            for(int i=1; i<n; i++){
                numberList.add(i);
            }
    
            //Stampo l'ArrayList
            System.out.println("Lista iniziale:");
            for(int i=0; i<numberList.size(); i++){
                System.out.print(numberList.get(i) + " ");
            }
            System.out.println("");
            System.out.println("");
    
            //Creo il primo thread e lo avvio
            MyThread my_t = new MyThread(numberList, 1);
            my_t.start();
        }
    }
}