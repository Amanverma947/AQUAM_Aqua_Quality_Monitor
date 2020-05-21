package buttons.storytelleraman.com.aquam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminOptions extends AppCompatActivity {
    Button add_city,add_device;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_options);

        add_city=findViewById(R.id.add_city_id);
        add_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(getApplicationContext(), Add_City.class);
                startActivity(i);
            }
        });
        add_device=findViewById(R.id.add_device_id);
        add_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(getApplicationContext(), Add_Device.class);
                startActivity(i);
            }
        });

    }
}
