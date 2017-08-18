package example.e_homeservices;

import com.example.loginregisterwithsqlite.LoginDataBaseAdapter;

import example.e_homeservices.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends Activity {
	
	LoginDataBaseAdapter loginDataBaseAdapter;
	EditText First_Name,Last_name,email_ID,Address,Username,Password,Contact;
	Button Submit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		try{
		loginDataBaseAdapter = new LoginDataBaseAdapter(this);
		loginDataBaseAdapter=loginDataBaseAdapter.open();
		}catch(Exception ex){Log.e("SignUp Exception: ","Exception: "+ex);
		Toast.makeText(getApplicationContext(), "Exception: "+ex, Toast.LENGTH_LONG).show();
		}
		First_Name=(EditText)findViewById(R.id.editText1);
		Last_name=(EditText)findViewById(R.id.editText2);
		email_ID=(EditText)findViewById(R.id.editText3);
		Address=(EditText)findViewById(R.id.editText4);
		Username=(EditText)findViewById(R.id.editText5);
		Password=(EditText)findViewById(R.id.editText6);
		Contact=(EditText)findViewById(R.id.editText7);
		Submit=(Button)findViewById(R.id.button1);
		Submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub

			String FirstName=First_Name.getText().toString();
			String Lastname=Last_name.getText().toString();
			String email=email_ID.getText().toString();
			String Add=Address.getText().toString();
			String userid=Username.getText().toString();
			String password=Password.getText().toString();
			String contact=Contact.getText().toString();
			{
			// Save the Data in Database
		     int a=loginDataBaseAdapter.insertEntry(FirstName,Lastname,email,Add,userid,password,contact);

			// reg_btn.setVisibility(View.GONE);
			if(a>0)
			{
			Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(contact, null, "Congratulation! You have Successfully Registered With E- Home Services Your username: "+userid+" and Password: "+password, null, null);
			
			Intent i=new Intent(SignUp.this,Login.class);
			startActivity(i);
			finish();
			}
			else
			{
				Toast.makeText(getApplicationContext(), "Account Not Created Successfully \n Please Contact Your Admin..", Toast.LENGTH_LONG).show();
			}
			loginDataBaseAdapter.close();
			}
			}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_up, menu);
		return true;
	}

}
