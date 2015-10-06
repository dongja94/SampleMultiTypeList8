package com.example.dongja94.samplemultitypelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ChattingAdapter mAdapter;
    RadioGroup category;
    EditText messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        mAdapter = new ChattingAdapter();
        listView.setAdapter(mAdapter);
        category = (RadioGroup)findViewById(R.id.radioGroup);
        messageView = (EditText)findViewById(R.id.edit_message);
        Button btn = (Button)findViewById(R.id.btn_input);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageView.getText().toString();
                switch (category.getCheckedRadioButtonId()) {
                    case R.id.radio_send : {
                        if (!TextUtils.isEmpty(message)) {
                            SendData data = new SendData();
                            data.message = message;
                            mAdapter.add(data);
                        }
                        break;
                    }
                    case R.id.radio_receive : {
                        if (!TextUtils.isEmpty(message)) {
                            ReceiveData data = new ReceiveData();
                            data.message = message;
                            data.resId = R.mipmap.ic_launcher;
                            mAdapter.add(data);
                        }
                        break;
                    }
                    case R.id.radio_date : {
                        DateData data = new DateData();
                        data.date = new Date().toString();
                        mAdapter.add(data);
                        break;
                    }
                }
                messageView.setText("");
            }
        });
    }
}
