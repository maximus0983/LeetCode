package leet;

public class BestWay {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,1,1},
                                  {3,100,100}};
        int m = mat.length;
        int n = mat[0].length;
        int[][] f = new int[m][n];
        int ans = find(mat, m-1,n-1,0, f);
        for(int i=0;i<f.length;i++){
            for(int j=0;j<f[0].length;j++){
                System.out.print(f[i][j] +" ");
            }
            System.out.println();
        }
    }

    static int find(int[][] m, int i, int j, int sum, int[][] ar){
        if(i < 0 || j < 0){
            return 1000000;
        }
        if(i == 0 && j == 0){
            return m[i][j];
        }
        if(ar[i][j] !=0){
            return ar[i][j];
        }
        int m1 = m[i][j];
        int l =  m1+ find(m, i - 1, j,sum,ar);
        int r  = m[i][j] + find(m, i, j - 1,sum, ar);
        ar[i][j] = Math.min(l, r);
        System.out.println("i:"+i+" j:" +j +" "+ ar[i][j] +" l "+l+" r "+r);
        return ar[i][j];
    }
}
