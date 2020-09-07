
public class Elemento<E extends Comparable<E>>{
    E data;
    public void set (E data){
        this.data = data;
    }
    public E get(){return data;}    
    @Override
    public String toString(){
        return  this.data.toString();
    }
}