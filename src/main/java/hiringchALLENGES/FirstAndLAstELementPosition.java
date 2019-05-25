package hiringchALLENGES;

public class FirstAndLAstELementPosition {

    public static int[] searchRange(int[] nums, int target) {

        int lengthNums =nums.length;

        int mid = lengthNums/2;

        int left = 0;
        int right = lengthNums-1;
       return search(nums,target,left,right);
    }

    public static int[] search(int[]nums,int target,int left,int right){
        int mid= (left+ right)/2;

        if(left<=right){
            if(nums[mid]==target){
                int[] answer =new int[2];
                answer[0]=mid;
                 int n=mid;
                 while(n>0){
                     if(nums[n-1]==target){
                         n--;
                     }else{
                         break;
                     }
                 }
                 int m =mid;
                while(m<nums.length-1){
                    if(nums[m+1]==target){
                        m++;
                    }else{
                        break;
                    }
                }

                answer[0]=n;
                answer[1]=m;
                return answer;
            }
        if(nums[mid]>target){
            return search(nums,target,left,mid-1);
        }
        else if(nums[mid]<target){
            return  search(nums,target,mid+1,right);
        }

        }
        int[] answer2 = new int[2];
        answer2[0]=-1;
        answer2[1]=-1;
        return answer2;
    }

    public static void main(String[] args){

        int[] nums = {1};
        int target = 1;

        int ans[] =searchRange(nums,target);

        System.out.println(ans[0] + "  " + ans[1] );
    }
}
