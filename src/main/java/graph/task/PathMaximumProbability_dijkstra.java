package graph.task;

import java.util.*;

public class PathMaximumProbability_dijkstra {


    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<Node>[] graph = new List[n];
        double[] dist = new double[n];

        dist[start_node] = 1;

        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0, len = edges.length; i < len; ++i) {
            int[] edge = edges[i];
            double weight = succProb[i];
            graph[edge[0]].add(new Node(edge[1], weight));
            graph[edge[1]].add(new Node(edge[0], weight));
        }

        PriorityQueue<Node> maxPQ = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));
        Node startNode = new Node(start_node, dist[start_node]);
        maxPQ.add(startNode);

        boolean[] visited = new boolean[n];

        while (!maxPQ.isEmpty()) {
            Node cur = maxPQ.poll();
            int currNode = cur.dst;
            double currProb = cur.probability;

            if (currNode == end_node) {
                return currProb;
            }

            if (visited[currNode]) {
                continue;
            }

            visited[currNode] = true;

            for (Node adj : graph[cur.dst]) {
                double storedWeight = dist[adj.dst];
                double newWeight = dist[cur.dst] * adj.probability;
                if (newWeight > storedWeight) {
                    dist[adj.dst] = newWeight;
                    maxPQ.add(new Node(adj.dst, dist[adj.dst]));
                }
            }
        }
        return 0.0;
    }

    static class Node {
        int dst;
        double probability;

        public Node(int dst, double probability) {
            this.dst = dst;
            this.probability = probability;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return dst == node.dst && Double.compare(probability, node.probability) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(dst, probability);
        }
    }

    static class PriorityQueue<T> {
        private final Comparator<? super T> comparator;
        private int size;
        private Object[] heap;

        PriorityQueue() {
            this(null);
        }

        PriorityQueue(int heapSize) {
            this(heapSize, null);
        }

        PriorityQueue(Comparator<? super T> comparator) {
            this(16, comparator);
        }

        PriorityQueue(int heapSize, Comparator<? super T> comparator) {
            this.heap = new Object[heapSize];
            this.comparator = comparator;
        }

        int getSize() {
            return this.size;
        }

        boolean isEmpty() {
            return this.size == 0;
        }

        boolean add(T val) {
            return offer(val);
        }

        boolean offer(T val) {
            int s = size++;
            if (s >= heap.length) {
                grow();
            }
            siftUp(val, s);
            return true;
        }

        @SuppressWarnings("unchecked")
        T poll() {
            if (size == 0) {
                return null;
            }
            int s = --size;
            T returnVal = (T) heap[0];
            T movedVal = (T) heap[s];
            heap[s] = null;
            if (s != 0) {
                siftDown(movedVal, 0);
            }
            return returnVal;
        }

        private void siftDown(T val, int pos) {
            if (comparator != null) {
                siftDownComparator(val, pos);
            } else {
                siftDownComparable(val, pos);
            }
        }

        private void siftUp(T val, int pos) {
            if (comparator != null) {
                siftUpComparator(val, pos);
            } else {
                siftUpComparable(val, pos);
            }
        }

        @SuppressWarnings("unchecked")
        private void siftDownComparator(T val, int pos) {
            int half = size >>> 1;
            while (pos < half) {
                int child = (pos << 1) + 1;
                int r = child + 1;
                Object childVal = heap[child];
                if (r < size && comparator.compare((T) heap[r], (T) childVal) < 0) {
                    childVal = heap[child = r];
                }
                if (comparator.compare(val, (T) childVal) <= 0) {
                    break;
                }
                heap[pos] = childVal;
                pos = child;
            }
            heap[pos] = val;
        }

        @SuppressWarnings("unchecked")
        private void siftDownComparable(T val, int pos) {
            Comparable<? super T> valC = (Comparable<? super T>) val;
            int half = size >>> 1;
            while (pos < half) {
                int child = (pos << 1) + 1;
                int r = child + 1;
                Object childVal = heap[child];
                Comparable<? super T> childValC = (Comparable<? super T>) childVal;
                if (r < size && childValC.compareTo((T) heap[r]) > 0) {
                    childVal = heap[child = r];
                }
                if (valC.compareTo((T) childVal) <= 0) {
                    break;
                }
                heap[pos] = childVal;
                pos = child;
            }
            heap[pos] = val;
        }

        @SuppressWarnings("unchecked")
        private void siftUpComparable(T val, int pos) {
            Comparable<? super T> valC = (Comparable<? super T>) val;
            while (pos > 0) {
                int parent = (pos - 1) >>> 1;
                Object pVal = heap[parent];
                if (valC.compareTo((T) pVal) >= 0) {
                    break;
                }
                heap[pos] = pVal;
                pos = parent;
            }
            heap[pos] = val;
        }

        @SuppressWarnings("unchecked")
        private void siftUpComparator(T val, int pos) {
            while (pos > 0) {
                int parent = (pos - 1) >>> 1;
                Object pVal = heap[parent];
                if (comparator.compare(val, (T) pVal) >= 0) {
                    break;
                }
                heap[pos] = pVal;
                pos = parent;
            }
            heap[pos] = val;
        }

        private void grow() {
            int size = heap.length;
            int newSize = (size >>> 1) + size;
            heap = Arrays.copyOf(heap, newSize);
        }
    }
}
