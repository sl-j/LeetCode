package StackAndQueue;

import java.util.*;

class RandomizedSet {
    List<Integer> list;
    Map<Integer,Integer> map;
    Random rand;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;

        list.add(val);
        map.put(val,list.size() - 1);

        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int idx = map.get(val);
        int lastValue = list.get(list.size() - 1);
        list.set(idx,lastValue);
        list.remove(list.size() - 1);
        map.remove(val);
        map.put(lastValue,idx);
        return true;
    }
    
    public int getRandom() {
        return rand.nextInt(list.size());
    }
}