package DP;

public class UnboundedKnapsackTopDown {
    public static void main(String[] args){
        int[] val = {1,3,4,5};
        int[] weight = {1,4,5,7};
        int W = 10;
        System.out.println("Maximum value : " + unboundedKnapsack(val,weight,val.length,W));
    }

    private static int unboundedKnapsack(int[] val, int[] weight, int n, int w) {
        int[][] t = new int[n+1][w+1];
        for(int i = 0 ; i < n+1 ; i++){
            for(int j = 0 ; j < w+1 ; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }
            }
        }
        for(int i = 1 ; i < n+1 ; i++){
            for(int j = 1 ; j < w+1 ; j++){
                if(weight[i-1] <= j){
                    t[i][j] = Math.max(val[i-1] + t[i][j - weight[i-1]],t[i-1][j]);
                } else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][w];
    }
}
