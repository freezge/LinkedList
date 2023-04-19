public class Main {
    public static void main(String[] args) {
        MyArrayList a = new MyArrayList();
        a.add(1);
        a.add(2);
        a.add(99);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(0);
        a.sort();
        for(int i = 0; i < a.size(); i++){
            System.out.println(a.get(i));
        }
    }
}