package Tugas01;

public class No01 {

    public static void main(String[] args) {
        int[][][] arrx = {
            {
                {10, 20, 30},
                {40, 50, 60}
            },
            {
                {11, 21, 31},
                {41, 51, 61}
            },
            {
                {12, 22, 32},
                {42, 52, 62}
            }
        };
        for (int i = 0; i < arrx.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arrx[i].length; j++) {
                System.out.print("[");
                for (int k = 0; k < arrx[i][j].length; k++) {
                    System.out.print(arrx[i][j][k]);
                    if (k < arrx[i][j].length - 1) {
                        System.out.print(",");
                    }
                }
                System.out.print("]");
                if (j < arrx[i].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i < arrx.length - 1) {
                System.out.print(",");
            }
        }
    }

}
