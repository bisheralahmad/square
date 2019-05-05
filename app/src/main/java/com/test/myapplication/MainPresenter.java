package com.test.myapplication;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        mView = view;
    }

    @Override
    public void calculateSquare(int n) {
        String result = "";
        int magic[][] = new int[n][n];

        int row = 0;
        int col = n / 2;
        int i, j;
        int square = n*n;

        for (i = 1; i <= square; i++) {
            if(row<n&&col<n){
                magic[row][col] = i;

            }
            if (i % n == 0) {
                row++;
            } else {
                if (row == 0) {
                    row = n - 1;
                } else {
                    row--;
                }
                if (col == (n - 1)) {
                    col = 0;
                } else {
                    col++;
                }
            }

        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                result = result + "" + magic[i][j] + "    ";
            }
            result = result + "\n";
        }
        mView.printSquare(result);
    }
}
