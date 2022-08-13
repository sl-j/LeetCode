package Array;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ShowMeBug {
  public static void main(String[] args) {
        List<String> list = getList();
        // TODO
        Map<String,Map<String,Integer>> res = new HashMap<>();
        List<String> date = new ArrayList<>();
        List<String> countries = new ArrayList<>();
    
        for(String str : list){
          String[] strs = str.split(";");
          String country = strs[0];
          String time = strs[1];
          if(!date.contains(time)) date.add(time);
          if(!countries.contains(country)) countries.add(country);
          int count = Integer.parseInt(strs[2]);
          
          if(res.containsKey(time)){
            Map<String,Integer> map = res.get(time);
            if(map.containsKey(country))map.put(country,map.get(country) + count);
            else map.put(country,count);
          }else{
              Map<String,Integer> map = new HashMap<>();
              map.put(country,count);
              res.put(time,map);
          }
        }
    
        Collections.sort(date,(o1,o2) -> o1.compareTo(o2));
    
        for(String time : date){
          System.out.print(time.split(" ")[0] + " ");
        }
    
        System.out.print("总奖牌数");

      System.out.println();
        
    
      for(String country : countries){
          System.out.print(country + " ");
          for(String time : date){
              Map<String,Integer> countryAndCount = res.get(time);
              if(countryAndCount.containsKey(country)) System.out.print(countryAndCount.get(country) + " ");
              else System.out.print(0 + " ");
            }
          System.out.println();
          }

       
          
        
         
        
    
    }

    static List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("CHN;2022-01-28 00:00:00;5");
        list.add("RUS;2022-01-30 00:00:00;2");
        list.add("CHN;2022-01-31 00:00:00;3");
        list.add("USA;2022-01-31 00:00:00;5");
        list.add("IND;2022-01-28 00:00:00;4");
        list.add("RUS;2022-01-28 00:00:00;2");
        list.add("CHN;2022-01-29 00:00:00;7");
        list.add("IND;2022-01-30 00:00:00;4");
        list.add("KR;2022-01-31 00:00:00;5");
        list.add("CHN;2022-02-01 00:00:00;5");
        list.add("USA;2022-01-28 00:00:00;1");
        list.add("KR;2022-01-28 00:00:00;3");
        list.add("JP;2022-01-28 00:00:00;2");
        list.add("USA;2022-02-01 00:00:00;3");
        list.add("KR;2022-02-01 00:00:00;5");
        list.add("JP;2022-02-01 00:00:00;1");
        list.add("IND;2022-02-01 00:00:00;3");
        list.add("RUS;2022-02-01 00:00:00;2");
        list.add("KR;2022-01-29 00:00:00;2");
        list.add("RUS;2022-01-29 00:00:00;2");
        list.add("CHN;2022-01-30 00:00:00;1");
        list.add("USA;2022-01-30 00:00:00;3");
        list.add("KR;2022-01-30 00:00:00;5");
        list.add("JP;2022-01-30 00:00:00;5");
        list.add("IND;2022-02-02 00:00:00;4");
        list.add("RUS;2022-02-02 00:00:00;5");
        return list;
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i = 0;i < groupSizes.length;i++){
            if(map.containsKey(groupSizes[i])){
                map.get(groupSizes[i]).add(i);
            }else{
                map.put(groupSizes[i],new ArrayList<>());
            }
        }

        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            int num = entry.getKey();
            List<Integer> value = entry.getValue();
            for(int i = 0; i < value.size(); i+=num){
                res.add(value.subList(i,num));
            }
        }

        return res;
    }

}