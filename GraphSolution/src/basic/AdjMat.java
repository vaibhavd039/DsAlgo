package basic;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class AdjMat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int edge = sc.nextInt();
        int [][] matrix = new int[nodes][nodes];
        for(int  i=0;i<edge;i++){
            int first = sc.nextInt();
            int second = sc.nextInt();
            matrix[first][second]=1;
            matrix[second][first]=1;
        }

        for (int i=0;i<nodes;i++){
            for(int j=0;j<nodes;j++){
                if(matrix[i][j]==1){
                    System.out.println("there is connection: "+i+"\t and: "+j);
                }
            }
        }
    }
}
