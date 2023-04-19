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

    /*
     * @increaseSize() to increase length of array
     * @param item the element we are adding
     */
    public void increaseSize(){
        T[] buff = (T[]) new Object[arr.length*2];//doubling length of an array and creating buff array for copying
        for(int i = 0; i < arr.length; i++){//loop for copying
            buff[i] = arr[i];//copying
        }
        arr = buff;//buff is new array
    }
    /*
     * @remove_elem() to remove element from the LinkedArray
     * @param item the element we are removing
     */
    @Override
    public boolean remove_elem(T item) {
        T[] buff = (T[]) new Object[arr.length];//buffer
        int s = size, j = 0;
        for(int i = 0; i < s; i++){//loop
            if(arr[i] == item){//if we found our elem we are not copying it to buff array
                size--;
                continue;//to skip copy
            }
            buff[j] = arr[i];//copy
            j++;
        }
        arr = buff;
        return s != size;//returning true if size changed, false otherwise
    }

    /*
     * @remove() to remove element from the LinkedArray
     * @param index the index of element we are removing
     */
    @Override
    public T remove(int index) {
        check_index(index);// checking index for validity
        T[] buff = (T[]) new Object[arr.length];//buffer
        int s = size, j = 0;
        for(int i = 0; i < s; i++){//loop
            if(i == index){//if we are at index we are not copying it to buff array
                size--;
                continue;//skipping copy
            }
            buff[j] = arr[i];//copy
            j++;
        }
        arr = buff;
        return arr[index];//returning new value on this index
    }
    /*
     * @clear() to clear LinkedArray
     */
    @Override
    public void clear() {
        this.arr = (T[]) new Object[arr.length];;
        this.size = 0;
    }
    /*
     * @get() to get element from LinkedArray
     * @param index index of element
     */
    @Override
    public T get(int index) {
        check_index(index);// checking index for validity
        return arr[index];//returning value of this index
    }
    /*
     * @indexOf() to find index of element in LinkedArray
     * @param o element we are comparing
     */
    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++){//loop
            if(o.equals(arr[i])){//comparing o and elem
                return i;//returning index
            }
        }
        return -1;//returning -1 if no such element
    }
    /*
     * @lastindexOf() to find index of last element in LinkedArray
     * @param 0 element we are comparing
     */
    @Override
    public int lastIndexOf(Object o) {
        for(int i = size - 1; i >= 0; i--){//loop from end to beginning
            if(o.equals(arr[i])){//comparing o and elem
                return i;//returning index
            }
        }
        return -1;//returning -1 if no such element
    }
    /*
     * @sort() for sorting
     * i used bubble sorting method
     */
    @Override
    public void sort() {
        T[] buff = (T[]) new Object[arr.length];
        int k = 0;
        for(int i = 0; i < size - 1; i++){//loop
            for(int j = 0; j < size - i - 1; j++){//loop
                if(((Comparable)arr[j]).compareTo(arr[j+1]) >= 0){//checking if it is comparable type, 0 if equals, 1 if higher
                    T temp = arr[j];//changing values between 2 elems
                    arr[j] = arr[j+1];//changing values between 2 elems
                    arr[j+1] = temp;//changing values between 2 elems
                }
            }
        }
    }
}
