package Lab2;

import java.util.*;

public class MyThread extends Thread {
    private int n_prime;                                                //Indice al numero primo
    private ArrayList<Integer> numberStart = new ArrayList<>();         //ArrayList che il thread riceve
    private ArrayList<Integer> numberNext = new ArrayList<>();          //ArrayList che il thread restituisce
    private Thread t_next = new Thread();                               //Thread successivo

    //Costruttore
    public MyThread(ArrayList<Integer> numberStart, int n_prime) {
        this.numberStart = numberStart;
        this.n_prime = n_prime;
    }

    //Metodo run
    public void run() {
        //Ciclo che crea l'ArrayList da passare al thread successivo
        for(int i=0; i<numberStart.size(); i++){
                if(numberStart.get(i) % numberStart.get(n_prime) != 0 || numberStart.get(n_prime) == numberStart.get(i)){
                    numberNext.add(numberStart.get(i));
            }
        }

        //Stampo l'ArrayList del n thread
        System.out.println("Lista del " + n_prime + " thread:");
        for(int i=0; i<numberNext.size(); i++){
            System.out.print(numberNext.get(i) + " ");
        }
        System.out.println("");

        /*
         * boolean isPrime = true;
         * for (int i=2; i<numberNext.size(); i++){

            if(i%numberNext.get(i)==0){
                isPrime = false;
                break;
                }
            }
            if(isPrime){
                n_prime++;
                t_next = new MyThread(numberNext, n_prime);
                t_next.start();
            }else{
                //Se non ho più numeri da controllare, stampo l'ArrayList
                System.out.println("Lista finale:");
                for(int i=0; i<numberNext.size(); i++){
                System.out.print(numberNext.get(i) + " ");
            }
            }
         */

        //Sposto l'indice al numero primo successivo
        n_prime++;

        //Creo il thread successivo
        t_next = new MyThread(numberNext, n_prime);

        //Controllo se ho ancora numeri da controllare
        if(numberNext.size() != n_prime){
            //Se ho ancora numeri da controllare, avvio il thread successivo
            t_next.start();
        }
        else{
            //Se non ho più numeri da controllare, stampo l'ArrayList
            System.out.println("Lista finale:");
            for(int i=0; i<numberNext.size(); i++){
                System.out.print(numberNext.get(i) + " ");
            }
        }
    }
}

