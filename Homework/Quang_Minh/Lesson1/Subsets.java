import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        System.out.println(Math.pow(2, size));
        for (int i = 0; i < Math.pow(2, size); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int position = 0; position < size; position++) {
                if (getBit(i, position) == 1) subset.add(nums[position]);
            }
            result.add(subset);
        }

        return result;
    }

    public static int getBit(int input, int position) {
        return input >> position & 1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        subsets(a);
    }
}
