package kudwi.schoolex;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by harishananth on 15/06/17.
 */

public class Displaycred extends AppCompatActivity {
   TextView name;
    EditText email;
    EditText phonenumber;
    String uname,uemail,uphone;
    CircleImageView profpic;
    Button proceed;


    String url;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaycred);
        setTitle("Hello!");
        Bundle extras=getIntent().getExtras();
        if(extras!=null) {
            uname = extras.getString("username");
            uemail = extras.getString("email");


            url = extras.getString("url");
        }
        profpic=(CircleImageView)findViewById(R.id.profile_image);
        name=(TextView)findViewById(R.id.username);
        email=(EditText) findViewById(R.id.email);
        phonenumber=(EditText) findViewById(R.id.phonenum);

        proceed=(Button)findViewById(R.id.proceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uphone=phonenumber.getText().toString();
                uemail=email.getText().toString();
                sendEmail(uname,uemail,uphone);
                Intent intent=new Intent(Displaycred.this,WelcomeActivity.class);
                intent.putExtra("name",uname);
                intent.putExtra("email",uemail);
                intent.putExtra("url",url);
                startActivity(intent);


            }
        });

       // if(uname!=null && uemail!=null && uphone!=null && url!=null)
        {

            name.setText(uname);

            email.setText(uemail);

            Glide.with(Displaycred.this).load(url).into(profpic);
        }




    }
    private void sendEmail(String uname, String uemail, String uphone) {
        //Getting content for email
        String email =uemail;
        String subject = "Thank you for signing up - Paul Arun -Founder,SchooleX";
        String message = "Hello\t"+uname+"\n"+
                "\n" +
                "Hope you're doing fantastic! I noticed that you just signed up at SchooleX, and I wanted to personally thank you. I'm Paul Arun the founder/CEO and my goal is to offer the best experience possible to users. \n\n  Cheers \n paul Arun";

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }
}