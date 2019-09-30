package generic;

class Food{}

class Fruit extends Food {}
class Meat extends Food {}

class Apple extends Fruit {}
class Banana extends Fruit {}
class Pork extends Meat{}
class Beef extends Meat{}

class RedApple extends Apple {}
class GreenApple extends Apple {}



public class Plate<T>{
    T item;
    public Plate(T t){
        item=t;
    }
    
    public void set(T t) {
        item=t;
    }
    
    public T get() {
        return item;
    }
    
    public static void main(String[] args) {
    	 //就算容器中的类型之间存在继承关系，但是Plate和Plate两个容器之间是不存在继承关系的。 
    	//Plate<Fruit> p=new Plate<Apple>(new Apple());     
    	
    	//下界通配符
    	Plate<? extends Fruit> p=new Plate<Apple>(new Apple());
    	
    	//<? extends Fruit>会使往盘子里放东西的set()方法失效。但取东西get()方法还有效
    	//p.set(new Apple());  
    	Fruit fruit = p.get();
	}
    
    
}

