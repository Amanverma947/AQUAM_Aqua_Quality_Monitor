package buttons.storytelleraman.com.aquam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_City extends AppCompatActivity {

    Button set_city;
    EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__city);
        set_city=findViewById(R.id.set_city_id);
        edittext=findViewById(R.id.edittext_id);
        set_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                int duration = Toast.LENGTH_SHORT;
                Context context = getApplicationContext();
                String text="City added Successfully";
                edittext.setText("");
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

    }
}
