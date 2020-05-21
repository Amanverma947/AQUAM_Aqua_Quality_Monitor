package buttons.storytelleraman.com.aquam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Admin_panel_login extends AppCompatActivity {
    Button admin_login_button_in;
    EditText user_id,password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel_login);
        admin_login_button_in=findViewById(R.id.login_admin_panel_button);
        admin_login_button_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(getApplicationContext(), AdminOptions.class);
                startActivity(i);
            }
        });
    }
    }

