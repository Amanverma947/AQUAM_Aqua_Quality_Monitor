package buttons.storytelleraman.com.aquam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class feedback_window extends AppCompatActivity {
    Button send_feedback;
    EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_window);

        send_feedback=findViewById(R.id.send_feedback_id);
        edittext=findViewById(R.id.edittext_feedback_id);
        send_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                int duration = Toast.LENGTH_SHORT;
                Context context = getApplicationContext();
                String text="Feedback sent Successfully";
                edittext.setText("");

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });




    }

}

