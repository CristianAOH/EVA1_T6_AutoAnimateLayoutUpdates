package com.example.cristian.eva1_tema6;

import android.animation.LayoutTransition;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtxt_texto;
    Button btn_add, btn_delete;
    LinearLayout container;
    TextView txtV_texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtxt_texto=(EditText)findViewById(R.id.edtxt_texto);
        btn_add=(Button)findViewById(R.id.btn_add);
        container=(LinearLayout)findViewById(R.id.container);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater=(LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView=inflater.inflate(R.layout.renglon,null);
                txtV_texto=(TextView)addView.findViewById(R.id.txtV_texto);
                txtV_texto.setText(edtxt_texto.getText().toString());
                btn_delete=(Button)addView.findViewById(R.id.btn_delete);
                edtxt_texto.setText("");
                btn_delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((LinearLayout)addView.getParent()).removeView(addView);
                    }
                });
                container.addView(addView);
            }
        });
        LayoutTransition transition=new LayoutTransition();
        container.setLayoutTransition(transition);
    }
}
