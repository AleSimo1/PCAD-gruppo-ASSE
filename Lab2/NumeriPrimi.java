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
        Random rand = new Random();
        int n = rand.nextInt(100)+1;


        ArrayList<Integer> numberList = new ArrayList<>();

        for(int i=1; i<n; i++){
            numberList.add(i);
        }

        for(int i=0; i<numberList.size(); i++){
            System.out.print(numberList.get(i) + " ");
        }
        System.out.println("");

        MyThread my_t = new MyThread(numberList, 1);
        my_t.start();
    }
}