package example.e_homeservices;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class Electrical extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_electrical);
		String str=getIntent().getExtras().getString("user").toString();
		this.setTitle(str);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.electrical, menu);
		TextView Fans = (TextView)findViewById(R.id.textView2);
		TextView Switches = (TextView)findViewById(R.id.textView3);
		TextView Wiring = (TextView)findViewById(R.id.textView4);
		TextView Tube_Light = (TextView)findViewById(R.id.textView5);
		Fans.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Electrical.this,Electrical1.class);
			
				intent.putExtra("user", Electrical.this.getTitle().toString());
			
				 startActivity(intent);
				finish();
			}
		});
		Switches.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Electrical.this,Electrical1.class);
				
				intent.putExtra("user", Electrical.this.getTitle().toString());
			
				 startActivity(intent);
				 finish();
			}
		});
		Wiring.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Electrical.this,Electrical2.class);
				
				intent.putExtra("user", Electrical.this.getTitle().toString());
			
				 startActivity(intent);
				 finish();
			}
		});
		Tube_Light.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Electrical.this,Electrical2.class);
				
				intent.putExtra("user", Electrical.this.getTitle().toString());
			
				 startActivity(intent);
				 finish();
			}
		});
		return true;
	}

}
