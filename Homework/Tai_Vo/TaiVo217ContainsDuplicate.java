import java.util.HashSet;
import java.util.Set;

/**
 * @author taivt
 * @since 2022/03/08 17:58:29
 */
public class TaiVo217ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4};
        boolean result = new TaiVo217ContainsDuplicate().containsDuplicate(nums);
        System.out.println(result);
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }

        return false;
    }
}
