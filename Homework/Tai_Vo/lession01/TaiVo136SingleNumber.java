package lession01;

/**
 * @author taivt
 * @since 2022/03/13 23:16:24
 */
public class TaiVo136SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        int singleNum = new TaiVo136SingleNumber().singleNumber(nums);
        System.out.println(singleNum);
    }

    public int singleNumber(int[] nums) {
        int singleNum = 0;
        for (int num : nums) {
            singleNum ^= num;
        }
        return singleNum;
    }
}
