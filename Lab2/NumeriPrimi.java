package Lab2;

import java.util.*;

public class NumeriPrimi {
    public static void main(String[] args) {
        //Random rand = new Random();
        int n = 10;


        ArrayList<Integer> numberList = new ArrayList<>();

        for(int i=0; i<n; i++){
            numberList.add(i);
        }

        for(int i=0; i<numberList.size(); i++){
            System.out.print(numberList.get(i));
        }

        //Thread t1 = new Thread(new Threads());
    }
}