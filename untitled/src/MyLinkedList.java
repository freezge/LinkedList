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


    @Override
    public boolean remove_elem(E item) {
        Node <E> buff = head;
        while(buff != null){
            if(buff.value == item){
                if (buff.prev != null){
                buff.prev.next = buff.next;
                }
                else{
                    head = buff.next;
                }
                if(buff.next != null) {
                    buff.next.prev = buff.prev;
                }
                else {
                    tail = buff.prev;
                }
                size--;
                return true;
            }
            buff = buff.next;
        }
        return false;
    }

    @Override
    public E remove(int index) {
        check_index(index);
        Node <E> buff = head;
        while(index != 0){
            buff = buff.next;
            index--;
        }
        if (buff.prev != null){
            buff.prev.next = buff.next;
        }
        else{
            head = buff.next;
        }
        if(buff.next != null) {
            buff.next.prev = buff.prev;
        }
        else {
            tail = buff.prev;
        }
        size--;
        return buff.value;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public E get(int index) {
        check_index(index);
        Node <E> buff = head;
        while(index != 0){
            buff = buff.next;
            index--;
        }
        return buff.value;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node <E> buff = head;
        while(buff != null){
            if(buff.value == o){
                return index;
            }
            buff = buff.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size;
        Node <E> buff = tail;
        while(buff != null){
            if(buff.value == o){
                return index;
            }
            buff = buff.prev;
            index--;
        }
        return -1;
    }

    @Override
    public void sort() {
        Node <E> buff = head;
        int k = 0;
        while(buff != null){
            Node <E> buff2 = buff.next;
            while(buff2 != null){
                if(((Comparable)buff.value).compareTo(buff2.value) >= 0){
                    E temp = buff.value;
                    buff.value = buff2.value;
                    buff2.value = temp;
                }
                buff2 = buff2.next;
            }
            buff = buff.next;
        }
    }
}
