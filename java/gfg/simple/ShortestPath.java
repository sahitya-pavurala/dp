package gfg.simple;

class ShortestPath{

    public static int compute(int[][] arr, int m, int n){
        int[][] check =  new int[m+1][n+1];
        check[0][0] = arr[0][0];

        for(int i = 1; i < m + 1 ; i++)
            check[i][0] = check[i-1][0] + arr[i][0];

        for(int j = 1; j < n + 1; j++)
            check[0][j] = check[0][j-1] + arr[0][j];


        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n+1; j++ ){
                check[i][j] = arr[i][j] + min(check[i-1][j], check[i][j-1], check[i-1][j-1]);
            }
        }


        return check[m][n];
    }

    private static int min(int x, int y, int z) {

        if(x > y)
            return (y > z) ? z:y;
        else
            return (x < z) ? x:z;
    }

    public static void main(String args[]){
        int cost[][]= {{1, 2, 3},
                       {4, 8, 2},
                       {1, 5, 3}};
        System.out.println("minimum cost to reach (2,2) = " +
                                         compute(cost,2,2));
    }
}
