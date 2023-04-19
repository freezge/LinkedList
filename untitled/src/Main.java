import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> a = new MyArrayList<>();
        a.add(1);//testing
        a.add(2);//testing
        a.add(7);//testing
        a.add(99);//testing
        a.add(3);//testing
        a.add(4);//testing
        a.add(13,5);//testing
        a.add(5);//testing
        a.add(6);//testing
        a.add(7);//testing
        a.add(0);//testing
        System.out.println(a.indexOf(7));//testing
        a.remove_elem(1);
        System.out.println(a.lastIndexOf(7));//testing
        a.sort();//testing
        for(int i = 0; i < a.size(); i++){//cycle to output array
            System.out.print(a.get(i) + " ");//output of elem
        }
        a.clear();//testing
        for(int i = 0; i < a.size(); i++){//cycle to output array
            System.out.print(a.get(i) + " ");//output of elem
        }
    }
}