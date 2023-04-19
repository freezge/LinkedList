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
        if (index >= arr.length || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if(size == arr.length){
            increaseSize();
        }
        int j = 0;
        int[] buff = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(i == index){
                buff[j] = (int) item;
                j++;
            }
            buff[j] = arr[i];
            j++;
        }
        arr = buff;
    }
    public void increaseSize(){
        int[] buff = new int[arr.length*2];
        for(int i=0; i < arr.length; i++){
            buff[i]=arr[i];
        }
        arr = buff;
    }
    @Override
    public boolean remove(Object item) {
        //for ()
        return false;
    }

    @Override
    public Object remove(int index) {
        return null;
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
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }
}
