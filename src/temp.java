class Task implements Runnable {

    public void run() {

        synchronized (Task.class) {

            for (int x = 0; x < 10; x++)

                System.out.println(Thread.currentThread().getName() + "---" + x);

        }

    }

}


class temp {

    public static void main(String[] args) throws InterruptedException {

        synchronized (Task.class) {

            Task t = new Task();

            Thread t0 = new Thread(t);

            t0.start();

            t0.join();

            for (int x = 0; x < 10; x++)

                System.out.println(Thread.currentThread().getName() + "---" + x);

        }

    }

}

