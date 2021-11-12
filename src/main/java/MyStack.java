import java.util.Arrays;

public class MyStack {

    private int initialSize;
    private int size = 0;

    public MyStack(int initialSize) {
        this.initialSize = initialSize;
        this.myStackStorage = new Object[initialSize];
    }

    Object[] myStackStorage;

    public Object push (Object value) {
        if (size == initialSize) {
            System.out.println("Stack is overflow");
            return null;
        }
        myStackStorage[size] = value;
        size++;
        return value;
    }

    public Object remove(int index) {
        Object returnObject = null;
        Object[] tempStackStorage = new  Object[initialSize];
        for (int i = 0; i < myStackStorage.length; i++) {
            if (i < index) {
                tempStackStorage[i] = myStackStorage[i];
            } else if (i > index) {
                tempStackStorage[i - 1] = myStackStorage[i];
            } else {
                returnObject = myStackStorage[i];
            }
        }
        myStackStorage = Arrays.copyOf(tempStackStorage, initialSize);
        size--;
        return returnObject;
    }

    public void clear() {
        Arrays.fill(myStackStorage, null);
        size = 0;
    }

    public int size(){
        return size;
    }

    public Object peek(){
        return myStackStorage[size-1];
    }
    public Object pop(){
        Object removedObject = myStackStorage[size-1];
        myStackStorage[size-1] = null;
        size--;
        return removedObject;
    }
    public void print() {
        for (Object object : myStackStorage) {
            if (object != null) {
                System.out.println(object);
            }
        }
    }
}

