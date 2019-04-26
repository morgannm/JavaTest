package Collections;
import java.util.HashSet;
import java.util.Iterator;

// Source : https://openclassrooms.com/courses/java-et-les-collections/l-interface-set-e

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Double> set = new HashSet<Double>();
        set.add(12.52d);
        set.add(-5d);
        set.add(102.56d);
        set.add(75d);
        set.add(-52d);
        set.add(10d);
        System.out.println(set);

        Iterator<Double> it = set.iterator();
        while(it.hasNext()){
            Double d = it.next();
        }
    }
}