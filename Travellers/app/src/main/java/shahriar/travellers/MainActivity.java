package shahriar.travellers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button logInButton;
    Button signInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logInButton= (Button) findViewById(R.id.ButtonLogIn);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick (View v) {
                Intent intent=new Intent(MainActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });

        signInButton= (Button) findViewById(R.id.ButtonSignUp);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent=new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    


}
