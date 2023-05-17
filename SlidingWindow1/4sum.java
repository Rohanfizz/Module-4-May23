class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        //select i and j and do two sum for the remaining two pointers in the remaining array
        //By ensuring that whenever we move any pointer, that pointer should point to the next different value in the array, we are skipping the duplicate quadruplets
        List<List<Integer>> res = new  ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        int i = 0;
        while(i<n){
            int j = i+1;
            while(j<n){
                long remainingTarget = (long)(target - (long)arr[i] - (long)arr[j]);

                int l = j+1;
                int r = n-1;

                while(l<r){
                    long currSum = (long)(arr[l] + arr[r]);

                    if(currSum == remainingTarget){
                        List<Integer> currQuad = new ArrayList<>();
                        currQuad.add(arr[i]);
                        currQuad.add(arr[j]);
                        currQuad.add(arr[l]);
                        currQuad.add(arr[r]);
                        res.add(currQuad);

                        int prevL = arr[l];
                        while(l<r && arr[l] == prevL) l++;

                        int prevR = arr[r];
                        while(r>l && arr[r] == prevR) r--;

                    }else if(currSum > remainingTarget){
                        int prevR = arr[r];
                        while(r>l && arr[r] == prevR) r--;//decrement r until it comes onto new value
                    }else if(currSum < remainingTarget){
                        int prevL = arr[l];
                        while(l<r && arr[l] == prevL) l++;
                    }
                }
                int prevJ = arr[j];
                while(j<n && arr[j] == prevJ) j++; //im incrementing j until it comes onto the next val
            }
            int prevI = arr[i];
            while(i<n && arr[i] == prevI) i++;
        }
        return res;
    }
}