package com.example.activity_send_text;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView_output = findViewById(R.id.textView_Output);

        //檢查Intent是否有Extra，以判別是否是由ActivityB跳轉過來
        if(this.getIntent().hasExtra("Input_Text")) {
            Bundle bundle = this.getIntent().getExtras();
            //接收自ActivityB名為Input_Text的資料
            String Output_Text = bundle.getString("Input_Text");
            textView_output.setText(Output_Text);
        }
    }

    public void BTN_TRIG(View view) {
        EditText editText_input = findViewById(R.id.editText_Input);

        Intent intent = new Intent();
        intent.setClass(MainActivity.this, Activity_B.class);

        Bundle bundle = new Bundle();//建立Bundle以傳送資料
        String Input_Text = editText_input.getText().toString();//傳送給ActivityB的字串設為輸入內容
        bundle.putString("Input_Text", Input_Text);//將字串put進Bundle
        intent.putExtras(bundle);//將Bundle物件put給intent

        startActivity(intent);

        MainActivity.this.finish();//結束目前 Activity
    }
}