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
    
    public static final int MAX = 100;

    public static void main(String[] args) {
        MyLinkedList<Integer> inputList = new MyLinkedList<Integer>();

        for (int i = 0; i < MAX; i++) {
            if (i == MAX - 1)
                inputList.add(-1);
            else
                inputList.add(i + 2);
        }

        Object[] arrayInput = inputList.toArray();
        System.out.println("Input list: ");
        for (int i = 0; i < MAX; i++)
            System.out.print(arrayInput[i] + " ");

        System.out.println();

        MyThread thread = new MyThread(inputList);
        thread.start();
        inputList.setFinished(true);
    }
}