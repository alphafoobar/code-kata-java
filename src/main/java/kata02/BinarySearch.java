package kata02;

import static java.util.Arrays.copyOfRange;

public class BinarySearch {

    public int chop(int key, int[] array) {
        return chop(key, array, 0);
    }

    public int chop(int key, int[] array, int offset) {
        if (array.length == 0) {
            return -1;
        }
        if (array.length == 1) {
            return array[0] == key ? offset : -1;
        }
        int midPoint = Math.min(array.length - 1, array.length / 2);
        if (array[midPoint] == key) {
            return offset + midPoint;
        }
        if (array[midPoint] > key) {
            return chop(key, copyOfRange(array, 0, midPoint), offset);
        }
        return chop(key, copyOfRange(array, midPoint + 1, array.length), offset + midPoint + 1);
    }
}
