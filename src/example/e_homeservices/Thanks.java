package example.e_homeservices;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Thanks extends Activity {

	TextView t1;
Button b1,b2;
String userrr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thanks);
		String user=getIntent().getExtras().getString("user").toUpperCase();
		userrr=user;
		t1=(TextView)findViewById(R.id.textView1);
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		t1.setText("Thanks ! "+user+" for using E-HomeServices.");
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(Thanks.this,Home.class);
				intent.putExtra("user", userrr);
				startActivity(intent);
				finish();
			}
		});
		
		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(Thanks.this,Login.class);
				
				startActivity(intent);
				finish();
			}
		});

		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.thanks, menu);
		return true;
	}

}
