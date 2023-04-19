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
