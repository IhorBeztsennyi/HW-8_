
import java.util.Arrays;

public class MyQueue {
    private int initialSize;
    private int size = 0;

    public MyQueue(int initialSize) {
        this.initialSize = initialSize;
        this.myQueueStorage = new Object[initialSize];
    }

    Object[] myQueueStorage;

    public boolean add(Object value) {
        if (size == initialSize) {
            System.out.println("Queue is overflow");
            return false;
        }
        myQueueStorage[size] = value;
        size++;
        return true;
    }

    public Object remove(int index) {
        Object returnObject = null;
        Object[] tempQueueStorage = new Object[initialSize];
        for (int i = 0; i < myQueueStorage.length; i++) {
            if (i < index) {
                tempQueueStorage[i] = myQueueStorage[i];
            } else if (i > index) {
                tempQueueStorage[i - 1] = myQueueStorage[i];
            } else {
                returnObject = myQueueStorage[i];
            }
        }
        myQueueStorage = Arrays.copyOf(tempQueueStorage, initialSize);
        size--;
        return returnObject;
    }

    public void clear() {
        Arrays.fill(myQueueStorage, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        Object resultObject = null;
        if (size == 0) {
            return resultObject;
        } else {
            resultObject = myQueueStorage[0];
        }
        return resultObject;
    }

    public Object poll() {
        Object result = null;
        if (size == 0) {
            return result;
        } else {
            result = myQueueStorage[0];
            Object[] tempMyQueueStorage = new Object[initialSize];
            for (int i = 1; i < size; i++) {
                tempMyQueueStorage[i - 1] = myQueueStorage[i];
            }
            myQueueStorage = Arrays.copyOf(tempMyQueueStorage, initialSize);
            size--;
        }
        return result;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            Object object = myQueueStorage[i];
            System.out.println(object);
        }
    }
}
