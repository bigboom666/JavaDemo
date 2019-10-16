package thread;

public class TestSynchronized {

    public static void main(String[] args) {
        final InsertData insertData = new InsertData();
        new Thread() {
            @Override
            public void run() {
                insertData.insert();
                System.out.println("im 0");
            }
        }.start();
/*        new Thread() {
            @Override
            public void run() {
                insertData.insert1();
            }
        }.start();*/

        final InsertData insertData2 = new InsertData();
        new Thread() {
            @Override
            public void run() {
                insertData2.insert();
                System.out.println("im 2");
            }
        }.start();
    }
}

class InsertData {
    public synchronized  void insert() {
        System.out.println("ִ��insert");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ִ��insert���");
    }

    public synchronized static void insert1() {
        System.out.println("ִ��insert1");
        System.out.println("ִ��insert1���");
    }
}
