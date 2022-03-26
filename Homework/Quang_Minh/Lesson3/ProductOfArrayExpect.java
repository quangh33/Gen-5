package HomeWorkLesson3;

public class ProductOfArrayExpect {
    public static int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] result = new int[nums.length];
        result[0] = 1;
        //first result is prefixSum left except i
        for (int i = 1; i < size; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int prefixRight = 1;
        // result = prefixLeft * prefixRight
        for (int i = size - 1; i >= 0; i--) {
            result[i] = result[i]* prefixRight;
            prefixRight = prefixRight * nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = productExceptSelf(a);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }
}
