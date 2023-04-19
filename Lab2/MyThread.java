package Lab2;

import java.util.*;

public class MyThread extends Thread {
    private int n_prime;
    private ArrayList<Integer> numberStart = new ArrayList<>();
    private ArrayList<Integer> numberNext = new ArrayList<>();
    private Thread t_next = new Thread();

    public MyThread(ArrayList<Integer> numberStart, int n_prime) {
        this.numberStart = numberStart;
        this.n_prime = n_prime;
    }

    public void run() {
        for(int i=0; i<numberStart.size(); i++){
                if(numberStart.get(i) % numberStart.get(n_prime) != 0 || numberStart.get(n_prime) == numberStart.get(i)){
                    numberNext.add(numberStart.get(i));
            }
        }
        n_prime++;
        t_next = new MyThread(numberNext, n_prime);
        if(numberNext.size() != n_prime){
            t_next.start();
        }
        else{
            for(int i=0; i<numberNext.size(); i++){
                System.out.print(numberNext.get(i) + " ");
            }
        }
    }
}
