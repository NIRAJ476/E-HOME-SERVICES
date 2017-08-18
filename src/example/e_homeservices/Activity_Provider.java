package example.e_homeservices;

import com.example.loginregisterwithsqlite.LoginDataBaseAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Activity_Provider extends Activity {
	Button SignUp;
	EditText First_Name,Last_name,email_ID,Address,Username,Password,Contact;
	Spinner Occupation;
	String UserType;
	LoginDataBaseAdapter loginDatabaseAdapter;
   @Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_providersign_up);
   First_Name=(EditText)findViewById(R.id.editText1);
	Last_name=(EditText)findViewById(R.id.editText2);
	email_ID=(EditText)findViewById(R.id.editText3);
	Address=(EditText)findViewById(R.id.editText4);
	Username=(EditText)findViewById(R.id.editText5);
	Password=(EditText)findViewById(R.id.editText6);
	Contact=(EditText)findViewById(R.id.editText7);
	Occupation=(Spinner)findViewById(R.id.spinner1);
   SignUp=(Button)findViewById(R.id.button1);
   
   Occupation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1,
				int arg2, long arg3) {
		UserType=Occupation.getItemAtPosition(arg2).toString();
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	});

   
   SignUp.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
	
		try
		{
			String FirstName=First_Name.getText().toString();
			String Lastname=Last_name.getText().toString();
			String email=email_ID.getText().toString();
			String Add=Address.getText().toString();
			String userid=Username.getText().toString();
			String password=Password.getText().toString();
			String contact=Contact.getText().toString();
			if(UserType.equalsIgnoreCase("SelectCategory"))
			{
				Toast.makeText(getApplicationContext(), "Please Select provider", Toast.LENGTH_LONG).show();
				return;
			}
		  loginDatabaseAdapter=new LoginDataBaseAdapter(getApplicationContext());
		  loginDatabaseAdapter=loginDatabaseAdapter.open();
		 int a= loginDatabaseAdapter.insertProvider(FirstName, Lastname, 
				 email, Add, userid, password, contact, UserType);
		  if(a>0)
		  {
			 SmsManager smsManager = SmsManager.getDefault();
				smsManager.sendTextMessage(contact, null, "Congratulation! You have Successfully Registered With E- Home Services Your username: "+userid+" and Password: "+password, null, null);
				
			  Toast.makeText(getApplicationContext(), "Service Provider Register Successfully..", Toast.LENGTH_LONG).show();
               startActivity(new Intent(Activity_Provider.this,Login.class));	
               finish();
		  }
		}catch(Exception ex)
		{
		  Log.e("Exception : ","Exception "+ex);
		  
		}
		loginDatabaseAdapter.close();
		
	}
});
   
   }
}
