package Lab2;

import java.util.*;

public class MyThread extends Thread {
    private int n_threads, pivot = 1;                                                  //Numero del thread
    private int numPrime;                                                //Indice al numero primo
    private boolean isPrime = true;                                             //Flag per controllare se la lista è composta da numeri primi
    private ArrayList<Integer> arrayStart = new ArrayList<>();                  //ArrayList che il thread riceve
    private ArrayList<Integer> arrayPrimeEnd = new ArrayList<>();               //ArrayList che il thread restituisce
    private Thread t_next = new Thread();                                       //Thread successivo

    //Costruttori
    public MyThread(ArrayList<Integer> arrayStart) {
        this.arrayStart = arrayStart;
    }

    public MyThread(ArrayList<Integer> arrayStart, ArrayList<Integer> arrayPrimeEnd, int n_threads) {
        this.arrayStart = arrayStart;
        this.arrayPrimeEnd = arrayPrimeEnd;
        this.n_threads = n_threads;
    }

    //Metodo run
    public void run() {
        //Salvo il numero primo del thread
        numPrime = arrayStart.get(pivot);

        //Aggiunto il numero
        arrayPrimeEnd.add(numPrime);

        //Elimino i multipli del numero primo
        for(int i=0; i<arrayStart.size(); i++){
                if(arrayStart.get(i) % numPrime == 0 || arrayStart.get(i) == numPrime){
                    arrayStart.remove(i);
            }
        }

        //Stampa l'array di numeri dopo l'eliminazione dei multipli
        System.out.println("Thread " + n_threads + " - Lista start: ");
        for(int i=0; i<arrayStart.size(); i++){
            System.out.print(arrayStart.get(i) + " ");
        }

        //Stampa l'array di etichette dei thread
        System.out.println("");
        System.out.println("Lista numeri primi: ");
        for(int i=0; i<arrayPrimeEnd.size(); i++){
            System.out.print(arrayPrimeEnd.get(i) + " ");
        }
        System.out.print("\n\n");


        //Controllo se ho ancora numeri da controllare
        for(int i=1; i<arrayStart.size(); i++){
            for(int j = i+1; j<arrayStart.size(); j++){
                if(arrayStart.get(j) % arrayStart.get(i) == 0 ){
                    isPrime = false;
                    break;
                }
            }
        }

        //Se non ho nulla da controllare ancora
        if(isPrime){
            //Inserisco gli ultimi numeri primi
            System.out.println("...");
            for(int i=1; i<arrayStart.size(); i++){
                arrayPrimeEnd.add(arrayStart.get(i));
            }

            //Stampo l'array di numeri primi finale
            System.out.println("\nNumeri primi finale: ");
            for(int i=0; i<arrayPrimeEnd.size(); i++){
                System.out.print(arrayPrimeEnd.get(i) + " ");
            }
        }
        else{//altrimenti
            
            //Creo il thread successivo
            t_next = new MyThread(arrayStart, arrayPrimeEnd, n_threads+1);

            //Se ho ancora numeri da controllare, avvio il thread successivo
            t_next.start();
        }
    }
}