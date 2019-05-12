/**
*���η����˼·
*������ֳ����������֣������ζԷֽ����������ִ����ͬ������ֱ���ֵ�����Ϊ1�����飬��ʼ����ֵ����һ�㺯������һ�㺯��������Χ�ڶ����������ӵݹ麯���ķ���ֵ���бȽϣ�
*ȡ���д����������������أ������������ӵݹ麯���ķ���ֵ���ִ�����ͬ����ȡ����һ�����ء�����ִ�У����ȡ�ľ����������д���������������
*�����Ŀ���ڶԷ���ֵ�Ĵ������Ƚϣ���Ҫ��ֽ�ͱ�����ѧ�߼��Ĺ����Ƶ���
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