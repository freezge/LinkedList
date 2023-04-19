# ADS Assignment 2
### Assignment 2 | MyArrayList and MyLinkedList
### Interface for implementation
```
public interface MyList<T>{
    int size();
    public void check_index(int index);
    boolean contains(Object o);
    void add(T item);
    void add(T item, int index);
    boolean remove_elem(T item);
    T remove(int index);
    void clear();
    T get(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    void sort();
}
```
### MyArrayList:
```
. Create a new class called MyArrayList that implements the List interface.
. Define a private instance variable of type Object[] to hold the elements of the list.
. Define an int variable called size to keep track of the number of elements in the list.
  Implement the add(E element) method by first checking if the size of the array is large enough to accommodate the new element. 
  If it is not, create a new array with double the size of the original array, copy over the elements from the original array, 
  and then add the new element. 
  Otherwise, simply add the new element to the end of the array and increment the size variable.
. Implement the get(int index) method by returning the element at the specified index.
. Implement the remove(int index) method by removing the element at the specified index, shifting all subsequent elements to the left 
  by one position, and decrementing the size variable.
. Implement the size() method by returning the size variable.
. Implement any other methods specified by the List interface.
. Test all methods of MyArrayList
```
### Code for MyArrayList with explanation:
```
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
```
### MyLinkedList:
```
. Create a new class called MyLinkedList that implements the List interface.
. Define a private inner class called Node that contains an element of type E and references to the next and previous nodes in the list.
. Define a private instance variable called head that references the first node in the list.
. Define a private instance variable called tail that references the last node in the list.
. Define an int variable called size to keep track of the number of elements in the list.
. Implement the add(E element) method by creating a new Node with the specified element, setting its next reference to null (since it will be the new tail), 
  and its. previous reference to the current tail. If the list is empty, set both the head and tail references to the new node. 
  Otherwise, set the next reference of the current tail to the new node and update the tail reference to the new node. 
  Finally, increment the size variable.
. Implement the get(int index) method by traversing the list from the head (or tail, depending on which is closer to the specified index) 
  and returning the element at the specified index.
. Implement the remove(int index) method by first traversing the list to the node at the specified index. 
  Then, update the next and previous references of the surrounding nodes to remove the node from the list, and decrement the size variable.
. Implement the size() method by returning the size variable.
. Implement any other methods specified by the List interface.
. Test all methods of MyLinkedList
```
### Code for MyLinkedList with explanation:
```
public class MyLinkedList<E> implements MyList<E>{
    private class Node <E> {
        private E value; //for value
        private Node<E> next, prev;//next connected element and previous connected element
        public Node(E value){//constructor for new values
            this.value = value;
        }
    }
    private Node <E> head, tail;//head - first element, tail - last element
    private int size;//size for size
    MyLinkedList(){ //constructor for new list
        size = 0;
        head = null;
        tail = null;
    }
    /*
    * @size() returns param size
    * @param size for tracking size
    */
    @Override
    public int size() {//function to get size
        return size;
    }
    /*
     * @check_index() checks if index is valid
     * @param index the index we are checking
     * @throw throws error if index is out of bounds
     */
    @Override
    public void check_index(int index){
        if(index > size || index < 0){
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
        Node <E> buff = head;
        while(buff != null){
            if(buff.value == o){
                return true;
            }
            buff = buff.next;
        }
        return false;
    }
    /*
     * @add() to add element to the end of LinkedArray
     * @param item the element we are adding
     */
    @Override
    public void add(E item) {
        Node <E> newNode = new Node<E>(item);
        if(tail == null){ //checking if list is empty
            head = newNode; //value for first elem
        }
        else {
            tail.next = newNode; //if list is not empty adding new vale to the end of list
            newNode.prev = tail;//changing connected value for new elem
        }
        tail = newNode;//changing last value
        size++;//size is changed, so we increase the number to track size
    }
    /*
     * @add() to add element to the end of LinkedArray
     * @param item the element we are adding
     * @param index to insert new element AFTER this index
     */
    @Override
    public void add(E item, int index) {
        check_index(index);//checking if index is valid
        Node <E> buff = head;
        while(index != 0){//loop to find our element
            buff = buff.next;//next elem
            index--;
        }
        Node <E> newNode = new Node<E>(item); //creating new connection
        newNode.prev = buff;//connecting new element to previous
        newNode.next = buff.next;//connecting new element to next
        if(buff.next != null){//checking if we are on the last element already
            buff.next.prev = newNode;//changing connection between nexts' previous element
        }
        else{
            tail = newNode;//changing last elem
        }
        buff.next = newNode;
        size++;//insreasing size
    }

    /*
     * @remove_elem() to remove element from the LinkedArray
     * @param item the element we are removing
     */
    @Override
    public boolean remove_elem(E item) {
        Node <E> buff = head; //buffer
        while(buff != null){ // checking if we are not at the end already
            if(buff.value == item){//checking for similarity
                if (buff.prev != null){//checking if we are not removing head
                buff.prev.next = buff.next;
                }
                else{
                    head = buff.next;
                }
                if(buff.next != null) {//checking if we are not removing tail
                    buff.next.prev = buff.prev;
                }
                else {
                    tail = buff.prev;
                }
                size--;//decreasing the size
                return true;//returning true if item was in array and was deleted
            }
            buff = buff.next;//next element
        }
        return false;//returning false if item wasn't in array
    }
    /*
     * @remove() to remove element from the LinkedArray
     * @param index the index of element we are removing
     */
    @Override
    public E remove(int index) {
        check_index(index);// checking index for validity
        Node <E> buff = head;//buffer
        while(index != 0){//to find our element
            buff = buff.next;//next elem
            index--;
        }
        if (buff.prev != null){//checking if we are not removing head
            buff.prev.next = buff.next;
        }
        else{
            head = buff.next;
        }
        if(buff.next != null) {//checking if we are not removing tail
            buff.next.prev = buff.prev;
        }
        else {
            tail = buff.prev;
        }
        size--;//decreasing size
        return buff.value;//returning removed item
    }
    /*
     * @clear() to clear LinkedArray
     */
    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }
    /*
     * @get() to get element from LinkedArray
     * @param index index of element
     */
    @Override
    public E get(int index) {
        check_index(index);//checking index for validity
        Node <E> buff = head;
        while(index != 0){//fiding our element
            buff = buff.next;
            index--;
        }
        return buff.value;//returning element
    }
    /*
     * @indexOf() to find index of element in LinkedArray
     * @param o element we are comparing
     */
    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node <E> buff = head;
        while(buff != null){//loop
            if(buff.value == o){//comparing values
                return index;//returning index
            }
            buff = buff.next;//next element
            index++;
        }
        return -1;//returning -1 if it does not exist
    }
    /*
     * @lastindexOf() to find index of last element in LinkedArray
     * @param 0 element we are comparing
     */
    @Override
    public int lastIndexOf(Object o) {
        int index = size;
        Node <E> buff = tail;
        while(buff != null){//loop
            if(buff.value == o){//comparing values
                return index;//returning index
            }
            buff = buff.prev;//previous element
            index--;
        }
        return -1;//returning -1 if it does not exist
    }
    /*
     * @sort() for sorting
     * i used bubble sorting method
     */
    @Override
    public void sort() {
        Node <E> buff = head;
        while(buff != null){//loop
            Node <E> buff2 = buff.next;
            while(buff2 != null){//loop
                if(((Comparable)buff.value).compareTo(buff2.value) >= 0){//checking if it is comparable type, 0 if equals, 1 if higher
                    E temp = buff.value;//changing values between 2 elems
                    buff.value = buff2.value;//changing values between 2 elems
                    buff2.value = temp;//changing values between 2 elems
                }
                buff2 = buff2.next;//next element
            }
            buff = buff.next;//next element
        }
    }
}
```
