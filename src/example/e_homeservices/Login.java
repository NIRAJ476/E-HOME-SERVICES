package example.e_homeservices;


import com.example.loginregisterwithsqlite.LoginDataBaseAdapter;

import example.e_homeservices.R;
import example.e_homeservices.R.id;
import example.e_homeservices.R.layout;
import example.e_homeservices.R.menu;


import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

public class Login<MainActivity> extends Activity {
	LoginDataBaseAdapter loginDataBaseAdapter;
	Button Sign_In;
	Button Sign_Up;
	Button Forgot_Password,Provider_SignUp,Provider_SignIn;
    EditText password;
    EditText username;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		Sign_In = (Button)findViewById(R.id.button1);
		Sign_Up = (Button)findViewById(R.id.button2);
		Forgot_Password = (Button)findViewById(R.id.button3);
		Provider_SignUp = (Button)findViewById(R.id.button4);
		Provider_SignIn = (Button)findViewById(R.id.providerLogin);
		password=(EditText)findViewById(R.id.editText2);
		username=(EditText)findViewById(R.id.editText1);
			
        Sign_Up.setOnClickListener(new View.OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Login.this,SignUp.class);
			    startActivity(intent);
			    
			   
			}
		});
       Sign_In.setOnClickListener(new OnClickListener() {

        	@Override
        	public void onClick(View v) {
        		try
        		{
        	// TODO Auto-generated method stub
        	String Username=username.getText().toString();	
        	String Password=password.getText().toString();
        	loginDataBaseAdapter = new LoginDataBaseAdapter(Login.this);
    		loginDataBaseAdapter=loginDataBaseAdapter.open();
        	String storedPassword=loginDataBaseAdapter.getSinlgeEntry(Username.trim());

        	if(Password.trim().equals(storedPassword))
        	{
        	Toast.makeText(Login.this, "Congrats: Login Successfully", Toast.LENGTH_LONG).show();
        	Intent ii=new Intent(Login.this,Home.class);
        	ii.putExtra("user", Username);
        	startActivity(ii);
        	}
        	else
        	if(Password.equals("")){
        	Toast.makeText(Login.this, "Please Enter Your Password", Toast.LENGTH_LONG).show();
        	}
        	else
        	{
        	Toast.makeText(Login.this, " Password Incorrect ", Toast.LENGTH_LONG).show();
        	}
        	//Intent ii= new Intent(Login.this,Home.class);
        	//startActivity(ii);
        	}
        	
        	catch(Exception ex)
        	{
        		Log.e("Exception:", ex.toString());
        		Toast.makeText(Login.this, " Exception "+ex.getMessage(), Toast.LENGTH_LONG).show();
        	}
        		loginDataBaseAdapter.close();
          }
      	});
Forgot_Password.setOnClickListener(new View.OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Login.this,Forgot_password.class);
				
				startActivity(intent);
			    
			   
			}
		});
		
Provider_SignIn.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		try
		{
		String Username=username.getText().toString();	
    	String Password=password.getText().toString();
    	loginDataBaseAdapter = new LoginDataBaseAdapter(Login.this);
		loginDataBaseAdapter=loginDataBaseAdapter.open();
    	String storedPassword=loginDataBaseAdapter.getSinlgeProvider(Username.trim());
        String str[]=storedPassword.split(",");
      
    	if(Password.trim().equals(str[0].trim()))
    	{
    	Toast.makeText(Login.this, "Congrats: Login Successfully", Toast.LENGTH_LONG).show();
    	
    	Intent ii=new Intent(Login.this,HomeProvider.class);
    	ii.putExtra("user", Username);
    	ii.putExtra("ID", str[1]);
    	startActivity(ii);
    	}
    	else
    	if(Password.equals("")){
    	Toast.makeText(Login.this, "Please Enter Your Password", Toast.LENGTH_LONG).show();
    	}
    	else
    	{
    	Toast.makeText(Login.this, " Password Incorrect ", Toast.LENGTH_LONG).show();
    	}

		}
		catch(Exception ex)
		{
			Log.e("Exception: ", "Exception: "+ex);
		}
		loginDataBaseAdapter.close();
	}
});
 
Provider_SignUp.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		
		startActivity(new Intent(Login.this,Activity_Provider.class));
	}
});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);

		return true;
	}

}
