package interpreter.collections;

import ONP_interpreter.ONPExpression;

import java.util.TreeMap;

public class Set {
    private TreeMap<String, Double> set;

    /**constructor*/
    public Set(){
        set = new TreeMap<>();
    }

    /**methods*/
    public void add(String name, Double val){
        set.put(name,val);
    }
    public void clear(String name){
        List list = ONPExpression.onp_symbols_prefix(name);
        if(list.isEmpty())
            set.clear();
        else
            for(String n: list.getList())
                set.remove(n);
    }
    public void write() {
        for(String key:set.keySet()){
            System.out.println(key+" -> "+set.get(key));
        }
    }

    /**getter*/
    public Double get(String name){
        return set.get(name);
    }
}
