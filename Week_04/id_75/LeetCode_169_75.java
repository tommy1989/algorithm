/**
*分治法求解思路
*把数组分成左右两部分，再依次对分解的左右数组执行相同操作，直到分到个数为1的数组，开始返回值给上一层函数，上一层函数在自身范围内对左右两个子递归函数的返回值进行比较，
*取其中次数出现最多的数返回，如左右两个子递归函数的返回值出现次数相同，则取任意一个返回。依次执行，最后取的就是在数组中次数出现最多的数。
*这个题目难在对返回值的次数做比较，需要拿纸和笔做数学逻辑的归纳推导。
*/
class Solution {
    public int majorityElement(int[] nums) {
        int res = findMajorityElement(nums,0, nums.length - 1);
        return res;
    }
    
    private int findMajorityElement(int[] a, int p, int q){
        if(p == q) return a[p];
        int m = (p + q)/2;
        int left = findMajorityElement(a,p,m);
        int right = findMajorityElement(a,m+1,q);
        
        int leftCount = 0;
        int rightCount = 0;
        if(left == right) return left;
     
        for(int i = p; i <= q; i++){
            if(a[i] == left){
                leftCount++;
            } else if(a[i] == right) {
                rightCount++;
            }
        }
          
        if(leftCount >= rightCount){
            return left;
        } else {
            return right;
        }
        
    }
}