package easy;

public class CatalanNumber {
    public static void main(String[] args) {

        System.out.println(catalan(3));
        System.out.println(catalan(4));

        System.out.println(computeCatalanDynamic(3));
        System.out.println(computeCatalanDynamic(5));
    }

    public static int catalan(int n) {
        if (n <= 1)
            return 1;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += catalan(i) * catalan(n - i - 1);
        }
        return result;
    }

    public static int computeCatalanDynamic(int n) {
        int[] result = new int[n+1];
        result[0]=1;
        result[1]=1;

        for (int i = 2; i <= n; i++) {
            int temp=0;
            for(int j=0; j<i;j++){
                temp+= result[j] * result[i-j-1];
            }
            result[i]=temp;
        }
        return result[n];
    }

}
