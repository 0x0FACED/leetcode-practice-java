class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int smallestDistance = Integer.MAX_VALUE; 
        int resIndex = -1;
        for(int i = 0; i < points.length; ++i){
            int[] currPoint = points[i];
            if(currPoint[0] == x && currPoint[1] == y){
                return i;
            } else if(currPoint[0] == x){
                if(Math.abs(currPoint[1] - y) < smallestDistance){
                    smallestDistance = Math.abs(currPoint[1] - y);
                    resIndex = i;
                }
            } else if(currPoint[1] == y){
                if(Math.abs(currPoint[0] - x) < smallestDistance){
                    smallestDistance = Math.abs(currPoint[0] - x);
                    resIndex = i;
                }
            }
        }
        return resIndex;
    }
}
