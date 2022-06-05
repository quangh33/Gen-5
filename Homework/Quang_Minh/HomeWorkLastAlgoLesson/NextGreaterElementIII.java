package HomeWorkLastAlgoLesson;

public class NextGreaterElementIII {
    static int[] nums;

    public static <e> int nextGreaterElement(int n) {
        char[] arr = (n + "").toCharArray();
        nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i] + "");
        }
        int check = nums.length - 1;
        for (; check > 0; check--) {
            if (nums[check] > nums[check - 1]) break;
        }
        if (check == 0) return -1;
        int length = nums.length;
        if (length == 0) return -1;
        int canSwapPosition = length - 1;
        while (canSwapPosition > 0 && nums[canSwapPosition - 1] >= nums[canSwapPosition])
            canSwapPosition--;
        canSwapPosition--;
        // cout<<canSwapPosition;
        if (canSwapPosition == -1) {
            sortIncrease(nums, 0, length - 1);
        } else {
            for (int i = length - 1; i > canSwapPosition; i--)
                if (nums[i] > nums[canSwapPosition]) {
                    swap(i, canSwapPosition);
                    break;
                }
            sortIncrease(nums, canSwapPosition + 1, length - 1);
        }
        String res = "";
        for (int i : nums) {
            res += (i + "");
        }
        long longRes = Long.parseLong(res);
        return longRes <= Integer.MAX_VALUE ?  (int) longRes : -1;
    }

    static void sortIncrease(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
    }

    static void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int a = 2147483486;
        nextGreaterElement(a);
    }

}
