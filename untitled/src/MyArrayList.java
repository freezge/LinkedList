import java.util.ArrayList;

public class MyArrayList implements MyList{
    private int[] arr;
    private int size;
    MyArrayList(){
        this.arr = new int[5];
        this.size = 0;
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
    public void add(Object item) {
        if(size == arr.length){
            increaseSize();
        }
        arr[size++] = (int)item;
    }

    @Override
    public void add(Object item, int index) {
        if(size == arr.length){
            increaseSize();
        }
        int buff[] = new int[arr.length];
        int j = 0, s = size;
        for(int i = 0; i < s; i++){
            if(i == index){
                buff[j] = (int)item;
                j++;
                size++;
            }
            buff[j] = arr[i];
            j++;
        }
        arr = buff;
    }
    public void increaseSize(){
        int[] buff = new int[arr.length*2];
        for(int i = 0; i < arr.length; i++){
            buff[i] = arr[i];
        }
        arr = buff;
    }
    @Override
    public boolean remove(Object item) {
        int buff[] = new int[arr.length];
        int s = size, j = 0;
        for(int i = 0; i < s; i++){
            if(arr[i] == Integer.parseInt((String) item)){
                size--;
                continue;
            }
            buff[j] = arr[i];
            j++;
        }
        arr = buff;
        return s != size;
    }

    @Override
    public Object remove(int index) {
        int buff[] = new int[arr.length];
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
        return s != size;
    }

    @Override
    public void clear() {
        this.arr = new int[5];
        this.size = 0;
    }

    @Override
    public Object get(int index) {
        if (index >= arr.length || index < 0){
            throw new IndexOutOfBoundsException();
        }
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
    public void sort() {
        int buff[] = new int[arr.length];
        int k = 0;
        for(int i = 0; i < size - 1; i++){
            for(int j = 0; j < size - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
