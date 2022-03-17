namespace RangeSumQuery
{
    public class NumArray {
		int[] preFixSum;
		public NumArray(int[] nums) {
			preFixSum = new int[nums.Length+1];
			preFixSum[0]=0;
			for(int i=0;i<nums.Length;i++)  // O(n)
				preFixSum[i+1]=preFixSum[i]+nums[i];
		}
		
		public int SumRange(int i, int j) => preFixSum[j+1]-preFixSum[i];
	}
}
