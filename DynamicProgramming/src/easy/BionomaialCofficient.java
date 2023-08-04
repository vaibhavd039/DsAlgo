package easy;

public class BionomaialCofficient {
    public static void main(String[] aergs) {
        int x = getBionomicalCoff(10,5);
        int y = x/ (5+1);
        System.out.print(y);
    }

    public static int getBionomicalCoff(int n, int k) {
        if(k>n-k){
            k=n-k;
        }
        int result =1;
        for(int i =0;i<k;i++){
            result *= (n-i);
            result /= (i+1);
        }
        return result;
    }
}
