package Lab2;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;


public class lab2 {
    public static void main(String[] args) {
        Random rand = new Random();
        int prime = 0; 
        int n = 10;


        ArrayList<Integer> numberList = new ArrayList<>();

        for(int i=0; i<n; i++){
            prime++;
            if(isPrime(prime)){
                numberList.set(i, prime);
            }
        }

        for(int i=0; i<numberList.size(); i++){
            System.out.println(numberList.toString());
        }

        //Thread t1 = new Thread(new Threads());

        





    }

    private static boolean isPrime(int i) {
        return false;
    }
}