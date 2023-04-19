import java.util.ArrayList;
public class MyArrayList<T> implements MyList<T>{
    private T[] arr;//array
    private int size;//to keep track of size
    MyArrayList(){//constructor for list
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    /*
     * @size() returns param size
     * @param size for tracking size
     */
    @Override
    public int size() {
        return size;
    }
    /*
     * @check_index() checks if index is valid
     * @param index the index we are checking
     * @throw throws error if index is out of bounds
     */
    @Override
    public void check_index(int index){//checking if index is out of bounds
        if (index >= arr.length || index < 0){
            throw new IndexOutOfBoundsException();
        }
    }
    /*
     * @contains() to check if element is in LinkedArray
     * @param o the element we are checking
     * @returns true if element is in LinkedArray, otherwise returns false
     */
    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < size(); i++){//loop
            if (o.equals(arr[i])){//checking for similarity
                return true;
            }
        }
        return false;
    }
    /*
     * @add() to add element to the end of LinkedArray
     * @param item the element we are adding
     */
    @Override
    public void add(T item) {
        if(size == arr.length){//checking if we are out of space for elements
            increaseSize();//increasing its size
        }
        arr[size++] = item;//adding new element
    }
    /*
     * @add() to add element to the end of LinkedArray
     * @param item the element we are adding
     * @param index to insert new element AFTER this index
     */
    @Override
    public void add(T item, int index) {
        check_index(index);//checking if index is valid
        if(size == arr.length){ //increasing size if needed
            increaseSize();
        }
        T[] buff = (T[]) new Object[arr.length];//buffer array
        int j = 0, s = size;
        for(int i = 0; i < s; i++){//cycle to copy elems of array to buff
            buff[j] = arr[i];//copying
            if(i == index){//checking if we reached index
                buff[j+1] = item;//adding elem to buff array
                j++;
                size++;//increasing size
            }
            j++;//to navigate inside buff
        }
        arr = buff;//buff is our new changed array
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
    public void sort() {
        T[] buff = (T[]) new Object[arr.length];
        int k = 0;
        for(int i = 0; i < size - 1; i++){
            for(int j = 0; j < size - i - 1; j++){
                if(((Comparable)arr[j]).compareTo(arr[j+1]) >= 0){
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
