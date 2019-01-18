package com.example.py;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import Util.CusUtil;

import static Util.CusUtil.getPinYin;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private TextView textView1;
    private TextView textView2;
    private EditText editText;
    private Button query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1=(TextView)findViewById(R.id.textView1);
        editText=(EditText)findViewById(R.id.editText);
        query=(Button)findViewById(R.id.button);
        query.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button:
                String text=editText.getText().toString();
                String result= null;
                try {
                    result = getPinYin(text);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                textView1.setText(result.toLowerCase());
                textView2.setText(result.toUpperCase());
                break;
            default:
                break;
        }
    }
}
