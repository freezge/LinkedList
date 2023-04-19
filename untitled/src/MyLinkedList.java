public class MyLinkedList<E> implements MyList<E>{
    private class Node <E> {
        private E value;
        private Node<E> next, prev;
        public Node(E value){
            this.value = value;
        }
    }
    private Node <E> head, tail;
    private int size;
    MyLinkedList(){ //constructor
        size = 0;
        head = null;
        tail = null;
    }
    @Override
    public int size() {//function to get size
        return size;
    }
    @Override
    public void check_index(int index){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
    }
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

    @Override
    public void add(E item) {
        Node <E> newNode = new Node<E>(item);
        if(tail == null){
            head = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    @Override
    public void add(E item, int index) {
        check_index(index);
        Node <E> buff = head;
        while(index != 0){
            buff = buff.next;
            index--;
        }
        Node <E> newNode = new Node<E>(item);
        newNode.prev = buff;
        newNode.next = buff.next;
        buff.next.prev = newNode;
        buff.next = newNode;
        size++;
    }

//    @Override
//    public boolean remove(Object item) {
//        return false;
//    }


    @Override
    public boolean remove_elem(E item) {
        Node <E> buff = head;
        while(buff != null){
            if(buff.value == item){
                buff.prev.next = buff.next;
                buff.next.prev = buff.prev;
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
        buff.prev.next = buff.next;
        buff.next.prev = buff.prev;
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

    }
}
