

import sun.rmi.runtime.Log;

import java.util.Random;
import java.util.Vector;
import java.util.logging.Logger;

/**
 * 坦克游戏 成员 主要包含 坦克， 子弹等
 * Created by admin on 2017/7/29.
 */
// 坦克的基类,主要有以下属性, 坦克的x 轴 y 轴 坐标 坦克的方向
class Tanks {
    // 定义坦克的横坐标， 纵坐标
    int x = 0;
    int y = 0;
    boolean isLive = true;

    final int width = 20;
    final int length = 30;
    //int isTouch = -1;

    // 坦克的方向 0 表示向上 1 表示向右 2 表示 下 3 表示左
    private int direct = 0;
    // 设置坦克的速度
    int speed = 2;
    // 坦克的颜色
    private int color;

    // 定义一个集合类，可以访问到Panel上所有坦克，这样才能知道每一辆坦克在哪，保证不会重叠
    Vector<Tanks> allTank = new Vector<Tanks>();

    public Tanks(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //判断是否遇到别的坦克
    public int isTouchOther() {
        int isTouch = -1;
        for (int i = 0; i < allTank.size(); i++) {
            Tanks tank = allTank.get(i);                          //用Tanks更好，以便加入自己的坦克
            // 取出面板上所有的坦克,并把自己排除掉
            // this 代表自己
            if (tank != this) {
                // 自己竖着
                if (this.getDirect() == 0 || this.getDirect() == 2) {
                    //自己竖着   对方坦克竖着
                    if (tank.getDirect() == 0 || tank.getDirect() == 2) {
                        if (!((tank.getX() + width < this.getX()) || (tank.getX() > this.getX() + width) || (tank.getY() + length < this.getY()) || (tank.getY() > this.getY() + length))) {
                            isTouch = this.getDirect();
                            return isTouch;

                        }
                    }
                    //自己竖着  对方坦克横着
                    else if (tank.getDirect() == 1 || tank.getDirect() == 3) {
                        if (!((tank.getX() + length < this.getX()) || (tank.getX() > this.getX() + width) || (tank.getY() + width < this.getY()) || (tank.getY() > this.getY() + length))) {
                            isTouch = this.getDirect();
                            return isTouch;
                        }
                    }
                }
                // 对自己横着
                if (this.getDirect() == 3 || this.getDirect() == 1) {

                    //自己横着 对面竖着
                    if (tank.getDirect() == 0 || tank.getDirect() == 2) {
                        if (!((tank.getX() + width < this.getX()) || (tank.getX() > this.getX() + length) || (tank.getY() + length < this.getY()) || (tank.getY() > this.getY() + width))) {
                            isTouch = this.getDirect();
                            return isTouch;
                        }
                    }
                    //自己横着 对方坦克横着
                    else if (tank.getDirect() == 1 || tank.getDirect() == 3) {
                        if (!((tank.getX() + length < this.getX()) || (tank.getX() > this.getX() + length) || (tank.getY() + width < this.getY()) || (tank.getY() > this.getY() + width))) {
                            isTouch = this.getDirect();
                            return isTouch;
                        }
                    }

                }
            }
        }

        return isTouch;

    }


}

// 敌人的坦克类, 每个敌人坦克类都是一个线程，都可以自己活动
class EneMyTank extends Tanks implements Runnable {

    // 敌人坦克是否死亡
    private int times = 0;  //子弹数量吗？？？？
    // 定义一个集合可以保存敌人的子弹
    Vector<Shot> fire = new Vector<Shot>();
    // 敌人发射子弹，应该是在刚刚创建敌人子弹时,或者是敌人子弹销毁时

    // 初始化 并调用父类的构造方法
    public EneMyTank(int x, int y) {
        super(x, y);
    }

    public void setAllTank(Vector<Tanks> v) {

        this.allTank = v;
    }


    private void addFire(){
        // 当敌人没有子弹时给他添加子弹
        if (isLive && fire.size() < 2) {                                           //&& times % 2 == 0
            Shot s = null;
            switch (this.getDirect()) {
                case 0:
                    // 子弹向上
                    s = new Shot(this.getX() + 10, this.getY(), 0);
                    // 将子弹放到集合中
                    fire.add(s);
                    break;
                case 1:
                    // 子弹向右
                    s = new Shot(this.getX() + 30, this.getY() + 10, 1);
                    // 将子弹放到集合中
                    fire.add(s);
                    break;
                case 2:
                    // 子弹向下
                    s = new Shot(this.getX() + 10, this.getY() + 30, 2);
                    // 将子弹放到集合中
                    fire.add(s);
                    break;
                case 3:
                    // 子弹向左
                    s = new Shot(this.getX(), this.getY() + 10, 3);
                    // 将子弹放到集合中
                    this.fire.add(s);
                    break;
            }
            // 子弹也是一个线程.记得要启动子弹线程
            Thread ShotYou = new Thread(s);
            ShotYou.start();
        }
    }

    private void moveUp() {
        for (int i = 0; i < 15; i++) {
            if (y > 0) {
                if (this.isTouchOther() == 0) {                      //重叠后方向反向
                    //this.setDirect(2);
                    break;
                } else {
                    y -= speed;
                }
            }


            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        y += speed;
    }


    private void moveRight() {
        // 向右 x 轴 变大
        for (int i = 0; i < 15; i++) {
/*                        if ((x < 365) && (this.isTouchOther() != 1)) { //&& ! this.isTouchOther()
                            x += speed;
                         //   System.out.println(Thread.currentThread().getName()+"Right");
                        }*/

            if (x < 365) {
                if (this.isTouchOther() == 1) {                      //重叠后方向反向
                    //this.setDirect(3);
                    break;
                } else {
                    x += speed;
                }
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        x -= speed;
    }


    private void moveDown() {
        for (int i = 0; i < 15; i++) {          //30*50=1500，需要1.5秒来完成这个循环
/*                        if ((y < 245) && (this.isTouchOther() != 2)) { //&& ! this.isTouchOther()   这个数字 咋算出来的？？还是调试出来的？？？
                            y += speed;
                          //  System.out.println(Thread.currentThread().getName()+"Down");
                        }*/

            if (y < 245) {
                if (this.isTouchOther() == 2) {                      //重叠后方向反向
                    //this.setDirect(0);
                    break;
                } else {
                    y += speed;
                }
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        y -= speed;
    }

    private void moveLeft() {
        for (int i = 0; i < 15; i++) {
/*                        if (x > 0 && (this.isTouchOther() != 3)) {  //&& ! this.isTouchOther()
                            x -= speed;
                           // System.out.println(Thread.currentThread().getName()+"Left");
                        }*/

            if (x > 0) {
                if (this.isTouchOther() == 3) {                      //重叠后方向反向  解bug
                    //this.setDirect(1);
                    break;
                } else {
                    x -= speed;
                }
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        x += speed;    //bug消除大法
    }


    @Override
    public void run() {

        //365  245

        while (true) {
            // 让敌人的坦克可以移动, 每隔一段时间修改敌人的坐标
            // 根据敌人的方向来决定敌人如何移动, 方向有随机的变化
            int temp = this.getDirect();
            // System.out.println(Thread.currentThread().getName()+"direct:"+temp);
            switch (temp) {
                case 0:
                    // 敌人的方向向上 y 轴减小
                    // System.out.println(Thread.currentThread().getName()+"case 0 :"+"isTouch:\t"+this.isTouchOther());
                    moveUp();
                    addFire();
                    moveUp();
                    break;
                case 1:
                    //  System.out.println(Thread.currentThread().getName()+"case 1 :"+"isTouch:\t"+this.isTouchOther());
                    moveRight();
                    addFire();
                    moveRight();
                    break;
                case 2:
                    // 向下
                    // System.out.println(Thread.currentThread().getName()+"case 2 :"+"isTouch:\t"+this.isTouchOther());
                    moveDown();
                    addFire();
                    moveDown();
                    break;
                case 3:
                    // 左
                    // System.out.println(Thread.currentThread().getName()+"case 3 :"+"isTouch:\t"+this.isTouchOther());
                    moveLeft();
                    addFire();
                    moveLeft();
                    break;
            }
            //times++;
            //System.out.println(Thread.currentThread().getName()+"times"+times);

            // 让坦克随机产生一个新的方向, Math.random() 产生0-1的随机数。*4 代表生成0-3的随机数
            this.setDirect((int) (Math.random() * 4));
            if (!this.isLive) {
                // 让坦克死亡后退出线程
                break;
            }
        }
    }

}

// 定义一个我的坦克类, 继承坦克类
class MyTank extends Tanks {
    private Shot shot;
    // 创建一个子弹的集合
    Vector<Shot> shots = new Vector<Shot>();

    // 初始化 并调用父类的构造方法
    public MyTank(int x, int y) {
        super(x, y);
    }

    // 发射子弹
    public void shotting() {

        switch (this.getDirect()) {

            case 0:
                // 子弹向上
                shot = new Shot(x + 10, y, 0);   //为什么x+10???+++++++++++++
                // 将子弹放到集合中
                shots.add(shot);
                break;
            case 1:
                // 子弹向右
                shot = new Shot(x + 30, y + 10, 1);
                // 将子弹放到集合中
                shots.add(shot);
                break;
            case 2:
                // 子弹向下
                shot = new Shot(x + 10, y + 30, 2);
                // 将子弹放到集合中
                shots.add(shot);
                break;
            case 3:
                // 子弹向左
                shot = new Shot(x, y + 10, 3);
                // 将子弹放到集合中
                shots.add(shot);
                break;
        }
        // 启动子弹
        Thread thread = new Thread(shot);
        thread.start();


    }

    // 控制坦克向上移动, 向上移动, 应该是 y 轴 的值 减小
    public void moveUp() {
        if ((this.y >= 0) && (this.isTouchOther() != 0)) {
            this.y -= this.speed;
            //System.out.println("isTouch:\t" + this.isTouchOther() + "\tx:\t" + this.x + ",y:\t" + this.y);
        }          //自己坦克可以出界bug
        //System.out.println("x:\t"+this.x+",y:\t"+this.y);
    }

    // 控制坦克向右移动, 向右移动 应该是 x 轴的值 加大
    public void moveRight() {
        if ((this.x <= 365) && (this.isTouchOther() != 1)) {
            this.x += this.speed;
            //System.out.println("isTouch:\t" + this.isTouchOther() + "\tx:\t" + this.x + ",y:\t" + this.y);
        }        //坦克向右 向下 原点在哪，怎么画的
        //System.out.println("x:\t"+this.x+",y:\t"+this.y);
    }

    // 控制坦克向下移动 向下移动 应该是 y 轴的值 加大
    public void moveDown() {
        if ((this.y <= 245) && (this.isTouchOther() != 2)) {
            this.y += speed;
            //System.out.println("isTouch:\t" + this.isTouchOther() + "\tx:\t" + this.x + ",y:\t" + this.y);
        }
        //System.out.println("x:\t"+this.x+",y:\t"+this.y);
    }

    // 控制坦克向左移动, 向左移动应该是 x 轴 减小
    public void moveLeft() {
        if ((this.x >= 0) && (this.isTouchOther() != 3)) {
            this.x -= this.speed;
            //System.out.println("isTouch:\t" + this.isTouchOther() + "\tx:\t" + this.x + ",y:\t" + this.y);
        }
        //System.out.println("x:\t"+this.x+",y:\t"+this.y);
    }
}

class Shot implements Runnable {
    // 子弹的坐标, 方向, 速度
    int x;
    int y;
    private int direct;
    private int speed = 5;
    // 子弹是否已经销毁, 子弹打到边缘位置，或者是打到敌人子弹时就要对子弹进行销毁处理
    boolean isLive = true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (this.direct) {
                case 0:
                    // 子弹向上
                    y -= speed;
                    break;
                case 1:
                    // 子弹向右
                    x += speed;
                    break;
                case 2:
                    // 子弹向下
                    y += speed;
                    break;
                case 3:
                    // 子弹向左
                    x -= speed;
                    break;
            }
            // 需要处理子弹销毁问题
            // 如果子弹到达x 轴 0 的位置 或者 子弹到达 y 轴 0的位置
            // 或者子弹大于 我们定义的JFrame的x 轴 y 轴大小 则子弹不再前进
            if (x < 0 || y < 0 || x > 400 || y > 300) {
                this.isLive = false;
                break;
            }
        }
    }
}

class Bomb {
    // 炸弹爆炸类
    // 定义炸弹的坐标
    int x;
    int y;
    // 炸弹的生命
    int life = 9;     //相当于走9遍画tank的函数，有三张爆炸的图，能爆炸有一个爆炸范围从大到小的效果
    boolean isLive = true;


    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown() {
        if (life > 0) {
            life--;
        } else {
            this.isLive = false;
        }
    }
}

class Reward implements Runnable {

    // 定义坦克的横坐标， 纵坐标
    int x = 0;
    int y = 0;
    boolean isLive = false;
    int size = 20;
    int type = 0;

    // 定义一个集合类，可以访问到Panel上所有坦克，这样才能知道谁得到奖励
    Vector<Tanks> allTank = new Vector<Tanks>();


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public Reward(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Reward() {
    }


    public void randomPosition() {
        this.x = (int) (Math.random() * 365);
        this.y = (int) (Math.random() * 245);
        if(getReward()!=null){
            this.x = (int) (Math.random() * 365);
            this.y = (int) (Math.random() * 245);
        }

    }

    public void getAllTank(Vector<Tanks> v) {

        this.allTank = v;
    }


    //出现间隔10S;
    int timeInterval = 10000;    //用存活与否来控制

    public void rewardType(Tanks tank) {
        tank.speed++;


       // System.out.println("Reward got  +3");
       // System.out.println(this.isLive );

    }


    //判断是否遇到坦克
    public Tanks getReward() {
        for (int i = 0; i < allTank.size(); i++) {
            Tanks tank = allTank.get(i);                          //用Tanks更好，以便加入自己的坦克
            // 取出面板上所有的坦克,并把自己排除掉
            // this 代表自己
            if (tank.isLive && this.isLive) {
                //自己竖着   对方坦克竖着
                if (tank.getDirect() == 0 || tank.getDirect() == 2) {
                    if (!((tank.getX() + tank.width < this.getX()) || (tank.getX() > this.getX() + this.size) || (tank.getY() + tank.length < this.getY()) || (tank.getY() > this.getY() + this.size))) {
                        //rewardType(tank);
                        //this.isLive = false;
                        return tank;
                    }
                }
                //自己竖着  对方坦克横着
                else if (tank.getDirect() == 1 || tank.getDirect() == 3) {
                    if (!((tank.getX() + tank.length < this.getX()) || (tank.getX() > this.getX() + this.size) || (tank.getY() + tank.width < this.getY()) || (tank.getY() > this.getY() + this.size))) {
                        //rewardType(tank);
                        //this.isLive = false;
                        return tank;
                    }
                }
            }
        }
        return null;
    }


    public void rewardGot() {
        if(this.isLive) {    //如果奖励存在  才能得到奖励
            Tanks tank = this.getReward();
            if (tank != null) {
                this.rewardType(tank);
                this.isLive = false;
            }
        }
    }


    @Override
    public void run() {
/*
        while(true) {

*//*            try {
                Thread.sleep(this.timeInterval/2);//线程等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*//*

            //Logger.getGlobal().info(String.valueOf(this.isLive));

            if (this.isLive == false) {
                try {
                    Thread.sleep(this.timeInterval/2);//线程等待
                    this.randomPosition();//刷新位置
                    this.isLive = true;
                    System.out.println("refresh star!");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }*/


    }
}
