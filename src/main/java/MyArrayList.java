
import java.util.Arrays;

public class MyArrayList {

    private final static int DEFAULT_CAPACITY = 10;
    private final static double INCREASE_FACTOR = 2.5;

    private int size = 0;

    Object[] myArrayStorage = new Object[DEFAULT_CAPACITY];

    public boolean add(Object value) {
        if (myArrayStorage.length <= size) {
            myArrayStorage = Arrays.copyOf(myArrayStorage, (int) (myArrayStorage.length*INCREASE_FACTOR));
        }
        myArrayStorage[size] = value;
        size++;
        return true;
    }

    public boolean remove(int index) {
        Object[] tempMyArrayStorage = Arrays.copyOf(myArrayStorage, size());
        for (int i = 0; i < size(); i++) {
            if (i < index) {
                tempMyArrayStorage[i] = myArrayStorage[i];
            } else if (i > 1) {
                tempMyArrayStorage[i - 1] = myArrayStorage[i];
            }
        }
        size--;
        myArrayStorage = Arrays.copyOf(tempMyArrayStorage, size);
        return true;
    }

    public void clear() {
        Arrays.fill(myArrayStorage, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        Object tempObject = null;
        for (int i = 0; i < myArrayStorage.length; i++) {
            if (i == index) {
                tempObject = myArrayStorage[i];
            }
        }
        return tempObject;
    }


    public void print() {
        for (Object object : myArrayStorage) {
            if (object != null) {
                System.out.println(object);
            }
        }
    }


}
