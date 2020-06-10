
public int countWays(int x, int y) {
        // write code here
        int[][] dp = new int[13][13];
        for (int i = 1; i < y; i++)
            dp[0][i] = 1;
         
        for (int i = 1; i < x; i++)
            dp[i][0] = 1;
         
        for (int i = 1; i < x; i++)
            for (int j = 1; j < y; j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
         
        return dp[x-1][y-1];
    }