package cn.sun.array2;
/**
 * 矩阵
 * @author Administrator
 *
 */
public class Matrix {
	/**
	 * 打印指定矩阵
	 * @param c
	 */
	//打印矩阵
	public static void print (int c [][]) {
		
		for (int i=0;i<c.length;i++) {
			
			for (int j=0;j<c.length;j++) {
			
				System.out.print(c[i][j]+"\t");
		}
			System.out.println();
	}
	}
	public static int[][] add(int a[][],int b[][]){
		/**
		 * 矩阵加法
		 */
		
		int c[][] = new int [a.length][a.length];
		
		for (int i=0;i<c.length;i++) {
			
			for (int j=0;j<c.length;j++) {
			
				c[i][j] = a[i][j] + b[i][j];
		}
	  }
		return c;
	}
	public static void main(String[] args) {
		int a[][] = {{1,3,3},{2,4,6},{6,4,9}};
		
		int b[][] = {{3,3,3},{2,4,7},{1,4,9}};
		
		int c[][] = add(a,b);
		
		print(c);
}
}
