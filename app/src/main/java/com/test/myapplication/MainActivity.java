package com.test.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private TextView tv_result;
    private EditText ed_n;
    private Button btn_print;
    private MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        presenter = new MainPresenter(this);

        btn_print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if the input field is empty if not empty do the calculation
                if (!TextUtils.isEmpty(ed_n.getText().toString())) {
                    int n = Integer.parseInt(ed_n.getText().toString());
                    presenter.calculateSquare(n);


            }else {
                    ed_n.setError("Please enter valid number");
                }
            }
        });

    }

    @Override
    public void printSquare(String result) {
        tv_result.setText(result);
    }

    /**
     * initialize the screen views
     */
    private void initViews() {
        tv_result = (TextView) findViewById(R.id.tv_result);
        ed_n = (EditText) findViewById(R.id.ed_n);
        btn_print = (Button) findViewById(R.id.btn_print);
    }
}
