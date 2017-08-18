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

public class HomeProvider extends Activity {

ListView lv;
ArrayList<Service> providerList;
LoginDataBaseAdapter loginDatabaseAdapter;
ServiceMyAdapter mdp;
String service;
String user;
String userType;
String UID;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_provider);
		Bundle b=getIntent().getExtras();
		user=b.getString("user");
		UID=b.getString("ID");
		this.setTitle(user);
		
		
		lv=(ListView)findViewById(R.id.listView1);
		providerList=new ArrayList<Service>();
		try
		{
			loginDatabaseAdapter=new LoginDataBaseAdapter(HomeProvider.this);
			loginDatabaseAdapter=loginDatabaseAdapter.open();
			
		   providerList=loginDatabaseAdapter.getServices(UID); 
		
		}catch(Exception ex)
		{
			Log.e("Exception", "Exception "+ex);
			Toast.makeText(getApplicationContext(), "Exception "+ex,Toast.LENGTH_LONG).show();
		}
		
		 mdp=new ServiceMyAdapter(getApplicationContext(),providerList);
		 lv.setAdapter(mdp);
		
	  lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
			
			  try{
				  int id=Integer.parseInt(v.getTag().toString());
				  
			  LoginDataBaseAdapter ll=new  LoginDataBaseAdapter(getApplicationContext());
			  ll=ll.open();
			 String cc= ll.getCallingContact(id+"");
			 
			  int a=ll.updateCalling(id+"");
			  if(a>0)
			  {
				  SmsManager sm=SmsManager.getDefault();
				  sm.sendTextMessage(cc, null,"Thank You Sir\n  We will Contact to You Soon .", null, null);
				  
				  Toast.makeText(getApplicationContext(), "Message Sent to Customer", Toast.LENGTH_LONG).show();
				  Intent intent=new Intent(HomeProvider.this,HomeProvider.class);
				  intent.putExtra("user", user);
				  intent.putExtra("ID", UID);
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
