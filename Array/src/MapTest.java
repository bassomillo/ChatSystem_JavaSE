import com.Student;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Student> map= new HashMap<>();
        map.put("001",new Student("a",20));
        map.put("002",new Student("b",20));
        map.put("003",new Student("c",20));
        map.put("004",new Student("d",20));
        System.out.println(map);
//        System.out.println("map.keySet() = " + map.keySet());
        Set<String> strings = map.keySet();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
            System.out.println(map.get(next));
        }

        Set<Map.Entry<String, Student>> entries = map.entrySet();
        Iterator<Map.Entry<String, Student>> iterator1 = entries.iterator();
        while (iterator1.hasNext()){
            Map.Entry<String, Student> next = iterator1.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }


        for(Map.Entry<String, Student> entry:map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
