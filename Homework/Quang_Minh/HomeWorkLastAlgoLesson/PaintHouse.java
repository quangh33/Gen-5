package HomeWorkLastAlgoLesson;

public class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;

        int red = 0, blue = 0, green = 0;

        for(int i = 0; i < costs.length; i++) {
            int r = red, b = blue, g = green;
            red = costs[i][0] + Math.min(b, g);
            blue = costs[i][1] + Math.min(r, g);
            green = costs[i][2] + Math.min(r, b);
        }

        return Math.min(red, Math.min(blue, green));
    }
}
