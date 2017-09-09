package commonDemo;

import org.junit.Test;

import java.util.*;

public class TestMain {
    static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1,8);
        Collection<String> c2 = new ArrayList<String>(subList);
        try {
            c.retainAll(c2);
        }
        catch(Exception e) {
            System.out.println("retainAll(): " + e);
        }
        try { c.removeAll(c2); } catch(Exception e) {
            System.out.println("removeAll(): " + e);
        }
        try { c.clear(); } catch(Exception e) {
            System.out.println("clear(): " + e);
        }
        try { c.add("X"); } catch(Exception e) {
            System.out.println("add(): " + e);
        }
        try { c.addAll(c2); } catch(Exception e) {
            System.out.println("addAll(): " + e);
        }
        try { c.remove("C"); } catch(Exception e) {
            System.out.println("remove(): " + e);
        }
        // The List.set() 虽然改变了值但没有改变它的数据结构尺寸
        try {
            list.set(0, "X");
        } catch(Exception e) {
            System.out.println("List.set(): " + e);
        }
    }
    public static void main(String[] args) {
        //test arrays.arraylist
//        List<String> list =
//                Arrays.asList("A B C D E F G H I J K L".split(" "));
//        System.out.println(list.getClass());
//        test("Arrays.asList()", list);
//        // System.out.println(list1.getClass());
//        test("Modifiable Copy", new ArrayList<String>(list));
//        //test("unmodifiableList()",Collections.unmodifiableList(new ArrayList<String>(list)));


        //test Arraylist
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(100);

        LinkedList linkedList = new LinkedList();

        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        map.put("1", "2");
    }
}
