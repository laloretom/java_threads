package Factorial;

import java.util.logging.Logger;

public class factorial implements Runnable{
    public static final String TAG = factorial.class.getSimpleName();
    public static final Logger LOGGER = Logger.getLogger(TAG);

    int entero;
    Thread t;

    public factorial(int entero) {
        this.entero = entero;
        t = new Thread(this,"Thread de " + entero);
        t.start();
    }

    @Override
    public void run() {
        LOGGER.info(Thread.currentThread().getName());
        long fact=1;
        for(int i=1;i<=entero;i++){
            fact=fact*i;
        }
        System.out.println(t.getName() + " - Factorial de "+entero+" es: "+fact);
    }

    public static void main(String[] args) {

        if (args.length == 0){
            System.exit(1);
        }

        for (String arg : args) {
            int x = Integer.parseInt(arg);
            if (x != 0) {
                factorial f = new factorial(x);
                try {
                    f.t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println(x);
            }
        }

    }


}
