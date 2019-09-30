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
    	 //���������е�����֮����ڼ̳й�ϵ������Plate��Plate��������֮���ǲ����ڼ̳й�ϵ�ġ� 
    	//Plate<Fruit> p=new Plate<Apple>(new Apple());     
    	
    	//�½�ͨ���
    	Plate<? extends Fruit> p=new Plate<Apple>(new Apple());
    	
    	//<? extends Fruit>��ʹ��������Ŷ�����set()����ʧЧ����ȡ����get()��������Ч
    	//p.set(new Apple());  
    	Fruit fruit = p.get();
	}
    
    
}

