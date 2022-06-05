package HomeWorkLesson13_15;

public class DisjointSetUpdateSize {
    int[] root;
    int[] size;

    public DisjointSetUpdateSize(int size) {
        root = new int[size];
        this.size = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            this.size[i] = 1;
        }
    }

    public int find(int x) {
        while (x != root[x]) {
            root[x] = root[root[x]];
            x = root[x];
        }
        return x;
    }

    public boolean union(int x, int y) {
        int nodeX = find(x);
        int nodeY = find(y);

        if (nodeX == nodeY) {
            return false;
        }

        if (size[nodeY] > size[nodeX]) {
            root[nodeX] = nodeY;
            size[nodeY] += size[nodeX];
        } else {
            root[nodeY] = nodeX;
            size[nodeX] += size[nodeY];
        }
        return true;
    }
}
