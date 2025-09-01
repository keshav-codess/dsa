import java.util.*;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        
        for (int[] c : classes) {
            double gain = gain(c[0], c[1]);
            pq.offer(new double[]{gain, c[0], c[1]});
        }
        
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int p = (int) top[1];
            int t = (int) top[2];
            p++; t++;
            double gain = gain(p, t);
            pq.offer(new double[]{gain, p, t});
        }
        
        double sum = 0.0;
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            sum += cur[1] / cur[2];
        }
        
        return sum / classes.length;
    }
    
    private double gain(int p, int t) {
        return (double)(p + 1) / (t + 1) - (double)p / t;
    }
}
