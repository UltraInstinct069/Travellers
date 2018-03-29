package shahriar.travellers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {

    protected EditText mUsername;
    //protected  EditText mEmail;
    protected  EditText mPassword;
    protected Button mRegisterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        mUsername=(EditText)findViewById(R.id.editTextSignUpName);
        mPassword=(EditText)findViewById(R.id.editTextSignUpPassword);
        mRegisterButton=(Button)findViewById(R.id.createBtn);


        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                String username=mUsername.getText().toString().trim();
                String password=mPassword.getText().toString().trim();
                //String email=mEmail.getText().toString().trim();



                ParseUser user = new ParseUser();
                user.setUsername(username);
                user.setPassword(password);
                //user.setEmail(email);



                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            // Hooray! Let them use the app now.
                            Toast.makeText(RegisterActivity.this, "Success! Welcome.", Toast.LENGTH_LONG).show();

                            Intent takeusertoHome = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(takeusertoHome);
                        } else {
                            // Sign up didn't succeed. Look at the ParseException
                            // to figure out what went wrong
                            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                            builder.setMessage(e.getMessage());
                            builder.setTitle("Sorry");
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    }
                });
            }
        });


    }
}
