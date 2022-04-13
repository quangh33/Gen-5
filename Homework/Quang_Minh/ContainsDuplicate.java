import java.util.HashMap;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i :nums){
            if (freq.get(i) != null){
                return true;
            }else{
                freq.put(i, 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,1};
        System.out.println(containsDuplicate(a));
    }
}
