package example.e_homeservices;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class Plumber extends Activity {

	TextView t1,t2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_plumber);
		String str=getIntent().getExtras().getString("user").toString();
		this.setTitle(str);
		
		t1=(TextView)findViewById(R.id.textView2);
		t2=(TextView)findViewById(R.id.textView3);
		
		t1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Plumber.this,Plumber1.class);
				intent.putExtra("user", getTitle().toString());
					startActivity(intent);
					finish();
				
			}
		});
		
        t2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Plumber.this,Plumber1.class);
				intent.putExtra("user", getTitle().toString());
					startActivity(intent);
					finish();
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.plumber, menu);
		return true;
	}

}
