package com.example.beautifulprogramm;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText pass;
    private RadioGroup rg;
    private Button button1;
    private RadioButton r1;
    private RadioButton r2;
    private TextView t1;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button1);
        rg = (RadioGroup)findViewById(R.id.rg);
        pass = (EditText)findViewById(R.id.pass);
        t1 = (TextView)findViewById(R.id.t1);
        builder = new AlertDialog.Builder(this);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = pass.getText().toString();
                if (text.length() > 0) {
                    t1.setText(text);
                }
                else{
                    builder.setTitle("Attention!!!")
                            .setMessage("Please, don`t leave the string empty")
                            .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            })
                            .show();
                }
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.r1:
                        pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        break;
                    case R.id.r2:
                        pass.setTransformationMethod(PasswordTransformationMethod.getInstance());

                        break;
                }

            }
        });
    }
}