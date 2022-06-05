package HomeWorkLesson13_15;

public class DisjointSet {
    int[] root;
    int[] rank;

    public DisjointSet(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
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

        if (rank[nodeX] > rank[nodeY]) {
            root[nodeY] = nodeX;
        } else if (rank[nodeX] < rank[nodeY]) {
            root[nodeX] = nodeY;
        } else {
            root[nodeY] = nodeX;
            rank[nodeX]++;
        }
        return true;
    }
}
