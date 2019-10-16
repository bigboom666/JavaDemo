package thread;

public class TestJoin {
    private int i=0;
    public static void main(String[] args) throws InterruptedException {

        DataProcess myProcess = new DataProcess();

        Thread t =new Thread(myProcess);

        t.start();

        t.join();

        System.out.println(myProcess.getProcessData()); //如果没有t.join  输出为0

    }
}





//模拟等待一个类的数据处理结束才执行主任务的过程
class DataProcess implements Runnable {  //不能用throws抛出的原因：重写run，子类抛出的异常类型不能比父类抛出的异常类型更宽泛。

    private int i=0;

    public int iProcess(){
        while(i<10) i++;
        return i;
    }

    public int getI() {return i;}

    @Override
    public void run( ) {

        iProcess();
    }

    public int getProcessData(){return this.getI();}

}