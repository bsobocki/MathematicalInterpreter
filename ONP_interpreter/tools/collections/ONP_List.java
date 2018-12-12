package ONP_interpreter.tools.collections;

import java.util.ArrayList;
import java.util.Collections;

public class ONP_List {
    /**list to storage symbols as strings*/
    private ArrayList<String> list;

    /**constructor*/
    public ONP_List(){
        list = new ArrayList<>();
    }

    /** methods */
    public void add(String elem){
        list.add(elem);
    }
    public String remove(){
        return list.remove(0);

    }
    public void write(){
        for(String x:list){
            System.out.println(x);
        }
    }
    public void reverse(){
        Collections.reverse(list);
    }

    /**getter*/
    public ArrayList<String> getList(){
        return list;
    }

    /**predicate*/
    public boolean isEmpty(){
        return list.isEmpty();
    }
}
