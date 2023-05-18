public class MyThread extends Thread {

    private int analizedNumber = 0;
    private int primeNumber = 0;

    MyLinkedList<Integer> listPrec = new MyLinkedList<Integer>();
    MyLinkedList<Integer> listSucc = new MyLinkedList<Integer>();
    MyThread nextThread;

    public MyThread(MyLinkedList<Integer> listPrec) {
        super();
        this.listPrec = listPrec;
    }

   
    @Override
    public void run() {
        while (true) {
            synchronized (listPrec) {
                if (listPrec.isEmpty()) {
                    if (listPrec.isFinished()) {

                        if (listSucc.isNull()) {
                            break;
                        }

                        if (!listSucc.isNull())
                            listSucc.setFinished(true);
                        break;
                    }
                }
                try {
                    analizedNumber = listPrec.take().intValue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (primeNumber == 0) {
                    primeNumber = analizedNumber;
                    if (primeNumber == -1) {
                        break;
                    } else {
                        System.out.println("Numero " + primeNumber + " e' primo!");
                    }
                }

                if (analizedNumber % primeNumber != 0) {
                    if (listSucc.isNull())
                        listSucc = new MyLinkedList<Integer>();

                    if (nextThread == null) {
                        nextThread = new MyThread(listSucc);
                        nextThread.start();
                    }

                    synchronized (listSucc) {
                        try {
                            listSucc.put(analizedNumber);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
