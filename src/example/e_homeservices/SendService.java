package example.e_homeservices;

import java.util.ArrayList;

import com.example.loginregisterwithsqlite.LoginDataBaseAdapter;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class SendService extends Activity {
  ListView lv;
  ArrayList<Provider> providerList;
  LoginDataBaseAdapter loginDatabaseAdapter;
MyAdapter mdp;
String service;
String user;
String userType;
  @Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.send_service);
	Bundle b=getIntent().getExtras();
	service=b.getString("service");
	user=b.getString("user");

	userType=b.getString("usertype");
			
	
	lv=(ListView)findViewById(R.id.listView1);
	providerList=new ArrayList<Provider>();
	try
	{
		loginDatabaseAdapter=new LoginDataBaseAdapter(SendService.this);
		loginDatabaseAdapter=loginDatabaseAdapter.open();
		providerList=loginDatabaseAdapter.getProviders(userType.trim()); 
	
	}catch(Exception ex)
	{
		Log.e("Exception", "Exception "+ex);
		Toast.makeText(getApplicationContext(), "Exception "+ex,Toast.LENGTH_LONG).show();
	}
	
	 mdp=new MyAdapter(getApplicationContext(),providerList);
	 lv.setAdapter(mdp);
	
  lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
		
		  try{
			  int id=Integer.parseInt(v.getTag().toString());
		  LoginDataBaseAdapter ll=new  LoginDataBaseAdapter(getApplicationContext());
		  ll=ll.open();
		 String cc= ll.getSinlgeUserContact(user);
		 String ccc= ll.getSinlgeProviderContact(id+"");
		  int a=ll.insertCalling(user, cc, service,id);
		  if(a>0)
		  {
			  SmsManager sm=SmsManager.getDefault();
			  sm.sendTextMessage(cc, null,"Thank You for Using E- Home Service\n  Your Request has been sent.", null, null);
			  sm.sendTextMessage(ccc, null,"This Message from E-Home Service: Customer "+user+" request for "+service+" contact No: "+cc, null, null);
			  Toast.makeText(getApplicationContext(), "Your Request Send Successfully..", Toast.LENGTH_LONG).show();
			  Intent intent=new Intent(SendService.this,Thanks.class);
			  intent.putExtra("user", user);
			  startActivity(intent);
			  finish();
		  }
		  }
		  catch(Exception ex)
		  {
			Toast.makeText(getApplicationContext(), "Exception: "+ex,Toast.LENGTH_LONG).show();  
		  }
	}
});
  
  }
  
  
  
}


