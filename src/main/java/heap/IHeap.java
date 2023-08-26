package heap;

public interface IHeap {
    void siftUp(int[] arr, int v);

    void siftDown(int[] arr, int v);

    int[] build(int[] arr);
}
