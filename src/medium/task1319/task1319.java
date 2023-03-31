class Solution {
    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        int[] root = new int[n];
        for (int i = 0; i < n; i++){
            root[i] = i;
        }

        for (int[] currConnection : connections) {
            int cmp1 = findParent(root, currConnection[0]);
            int cmp2 = findParent(root, currConnection[1]);
            if (cmp1 != cmp2) {
                root[cmp1] = cmp2;
                --n;
            }
        }

        return n - 1;
    }

    public static int findParent(int[] computers, int currComputer) {
        while (currComputer != computers[currComputer]) {
            computers[currComputer] = computers[computers[currComputer]];
            currComputer = computers[currComputer];
        }
        return currComputer;
    }
}
