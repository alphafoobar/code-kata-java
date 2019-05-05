package nz.kata02;

class BinarySearch {

    int chop(int key, int[] array) {
        return chop(key, array, 0, array.length);
    }

    private int chop(int key, int[] array, int offset, int length) {
        int remaining = length - offset;
        if (remaining == 0) {
            return -1;
        }
        int point = offset + remaining / 2;
        if (array[point] == key) {
            return point;
        }
        if (array[point] > key) {
            return chop(key, array, offset, point);
        }
        return chop(key, array, point + 1, length);
    }
}
