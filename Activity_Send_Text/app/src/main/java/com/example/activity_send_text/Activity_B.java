package com.example.activity_send_text;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_B extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        TextView textView_output = findViewById(R.id.textView_Output);

        //檢查Intent是否有Extra，以判別是否是由Main_Activity跳轉過來
        if(this.getIntent().hasExtra("Input_Text")) {
            Bundle bundle = this.getIntent().getExtras();
            //接收自Main_Activity名為Input_Text的資料
            String Output_Text = bundle.getString("Input_Text");
            textView_output.setText(Output_Text);
        }
    }

    public void BTN_TRIG(View view) {
        EditText editText_input = findViewById(R.id.editText_Input);

        Intent intent = new Intent();
        intent.setClass(Activity_B.this, MainActivity.class);

        Bundle bundle = new Bundle();//建立Bundle以傳送資料
        String Input_Text = editText_input.getText().toString();//傳送給Main_Activity的字串設為輸入內容
        bundle.putString("Input_Text", Input_Text);//將字串put進Bundle
        intent.putExtras(bundle);//將Bundle物件put給intent

        startActivity(intent);

        Activity_B.this.finish();//結束目前 Activity
    }
}
