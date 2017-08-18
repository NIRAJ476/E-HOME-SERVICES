package example.e_homeservices;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class Carpenter extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carpenter);
		String str=getIntent().getExtras().getString("user").toString();
		this.setTitle(str);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.carpenter, menu);
		TextView General_Carpentry_Work = (TextView)findViewById(R.id.textView2);
		TextView Furniture_Work = (TextView)findViewById(R.id.textView3);
		General_Carpentry_Work.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Carpenter.this,Carpenter1.class);
				intent.putExtra("user", Carpenter.this.getTitle().toString());
				startActivity(intent);
				finish();
			}
		});
		Furniture_Work.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Carpenter.this,Carpenter2.class);
				intent.putExtra("user", Carpenter.this.getTitle().toString()); 
				startActivity(intent);
	             finish();			
			}
		});
		return true;
		
	

}}

