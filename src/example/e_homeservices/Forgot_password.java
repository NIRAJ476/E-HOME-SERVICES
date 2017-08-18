package example.e_homeservices;

import com.example.loginregisterwithsqlite.LoginDataBaseAdapter;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Forgot_password extends Activity {
Button sendPassword;
EditText et1;
LoginDataBaseAdapter loginDataBaseAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forgot_password);
		sendPassword=(Button)findViewById(R.id.button1);
		et1=(EditText)findViewById(R.id.editText1);
		
		sendPassword.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String email=et1.getText().toString().trim();
				if(email.equals(""))
				{
					Toast.makeText(Forgot_password.this, "please Enter email Id", Toast.LENGTH_LONG).show();
					return;
				}
				try
				{
					loginDataBaseAdapter=new LoginDataBaseAdapter(getApplicationContext());
					loginDataBaseAdapter=loginDataBaseAdapter.open();
					
					String str=loginDataBaseAdapter.getSinlgeEmail(email);
					String[] ss=str.split(",");
					
					if(!ss[0].equals("NOT EXIST"))
					{
					
						SmsManager sms=SmsManager.getDefault();
						sms.sendTextMessage(ss[1], null, "Dear User: "+ss[2]+" Your E-Home Service Account Password: "+ss[0]+"",null, null);
					
						
					{
						sendPassword.setText("Password Sent to Your Registered Mobile No\n Please Check.");
					}
					
					}
					else
					{
						Toast.makeText(getApplicationContext(), "User not Exists..", Toast.LENGTH_LONG).show();
						et1.setText("");
					}
					
				}catch(Exception ex)
				{
					Log.e("Exception: ","exception: "+ex);
					Toast.makeText(getApplicationContext(), "Exception: "+ex, Toast.LENGTH_LONG).show();
				}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.forgot_password, menu);
		return true;
	}

}
