package example.e_homeservices;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class Home extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		Bundle bb=getIntent().getExtras();
		this.setTitle(bb.getString("user").toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		ImageView ImageView1 = (ImageView)findViewById(R.id.imageView1);
		ImageView ImageView2 = (ImageView)findViewById(R.id.imageView2);
		ImageView ImageView3 = (ImageView)findViewById(R.id.imageView3);
		ImageView ImageView4 = (ImageView)findViewById(R.id.imageView4);
		ImageView1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Home.this,Carpenter.class);
				intent.putExtra("user", Home.this.getTitle().toString());
				startActivity(intent);
				finish();
				
			}
		});
		ImageView2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Home.this,Painter.class);
				intent.putExtra("user", Home.this.getTitle().toString());
				 startActivity(intent);
				finish();
			}
		});
		ImageView3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Home.this,Electrical.class);
				intent.putExtra("user", Home.this.getTitle().toString());
				 startActivity(intent);
				
				finish();
			}
		});
		ImageView4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Home.this,Plumber.class);
				intent.putExtra("user", Home.this.getTitle().toString());
				 startActivity(intent);
				
				finish();
			}
		});
		return true;
	}

}
