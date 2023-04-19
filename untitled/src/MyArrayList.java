import java.util.ArrayList;
public class MyArrayList<T> implements MyList<T>{
    private T[] arr;
    private int size;
    MyArrayList(){
        this.arr = (T[]) new Object[5];;
        this.size = 0;
    }

    @Override
    public void check_index(int index){//checking if index is out of bounds
        if (index >= arr.length || index < 0){
            throw new IndexOutOfBoundsException();
        }
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < size(); i++){
            if (o.equals(arr[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T item) {
        if(size == arr.length){
            increaseSize();
        }
        arr[size++] = item;
    }

    @Override
    public void add(T item, int index) {
        check_index(index);
        if(size == arr.length){
            increaseSize();
        }
        T[] buff = (T[]) new Object[arr.length];
        int j = 0, s = size;
        for(int i = 0; i < s; i++){
            if(i == index){
                buff[j] = item;
                j++;
                size++;
            }
            buff[j] = arr[i];
            j++;
        }
        arr = buff;
    }


    public void increaseSize(){
        T[] buff = (T[]) new Object[arr.length*2];
        for(int i = 0; i < arr.length; i++){
            buff[i] = arr[i];
        }
        arr = buff;
    }

    @Override
    public boolean remove_elem(T item) {
        T[] buff = (T[]) new Object[arr.length];
        int s = size, j = 0;
        for(int i = 0; i < s; i++){
            if(arr[i] == item){
                size--;
                continue;
            }
            buff[j] = arr[i];
            j++;
        }
        arr = buff;
        return s != size;
    }
//    @Override
//    public boolean remove(Object item) {
//        int buff[] = new int[arr.length];
//        int s = size, j = 0;
//        for(int i = 0; i < s; i++){
//            if(arr[i] == Integer.parseInt((String) item)){
//                size--;
//                continue;
//            }
//            buff[j] = arr[i];
//            j++;
//        }
//        arr = buff;
//        return s != size;
//    }

    @Override
    public T remove(int index) {
        check_index(index);
        T[] buff = (T[]) new Object[arr.length];
        int s = size, j = 0;
        for(int i = 0; i < s; i++){
            if(i == index){
                size--;
                continue;
            }
            buff[j] = arr[i];
            j++;
        }
        arr = buff;
        return arr[index];
    }

    @Override
    public void clear() {
        this.arr = (T[]) new Object[arr.length];;
        this.size = 0;
    }

    @Override
    public T get(int index) {
        check_index(index);
        return arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++){
            if(o.equals(arr[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = size - 1; i >= 0; i--){
            if(o.equals(arr[i])){
                return i;
            }
        }
        return -1;
    }
    @Override
    public void sort() {}
//    @Override
//    public void sort() {
//        T[] buff = (T[]) new Object[arr.length];
//        int k = 0;
//        for(int i = 0; i < size - 1; i++){
//            for(int j = 0; j < size - i - 1; j++){
//                if(arr[j] > arr[j+1]){
//                    T temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//    }
}
