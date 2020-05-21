package buttons.storytelleraman.com.aquam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Add_Device extends AppCompatActivity {
 Spinner city_spinner;
 Button set;
    Check_Quality cq =new Check_Quality();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__device);
        city_spinner=findViewById(R.id.city_spinner_add_id);
         List<String> spinnerArray = new ArrayList<>();

        spinnerArray.add("JABALPUR");
        spinnerArray.add("BHOPAL");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_spinner_item,spinnerArray

        );
        city_spinner.setAdapter(adapter);


        set=findViewById(R.id.set_device_id);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                int duration = Toast.LENGTH_SHORT;
                Context context = getApplicationContext();
                String text="Device Added Successfully";

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }
}
