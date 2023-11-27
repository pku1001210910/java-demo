package top.moonstar.dp;

public class CanJump {
    public static void main(String[] args) {
        System.out.println(new CanJump().canJump(new int[]{2,3,1,1,4}));
    }

    public boolean canJump(int[] nums) {
        int rightMost = 0;
        for(int i=0;i<nums.length;i++){
            if( i <= rightMost){
                rightMost = Math.max(rightMost, nums[i] + i);

                if(rightMost >= nums.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
