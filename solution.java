class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int merge [] = new int[nums1.length + nums2.length];
		int balance = nums1.length, j=0;
		for(int i=0; i<merge.length; i++) {
			if(balance<=i) {
				merge[i] = nums2[j++];
			}
			else {
			merge[i] = nums1[i];
			}
		}
		int mid = 0, mid2 = 0;
		double  ans=0;
		Arrays.sort(merge);
		if(merge.length%2 == 1) {
			mid = merge.length/2;
			ans = merge[mid];
		}
		else if(merge.length%2 == 0) {
			mid = merge.length/2;
			mid2 = mid - 1;
			ans = ((double)(merge[mid]) + (double)(merge[mid2]))/2;
		}
		
		return ans;
    }
}