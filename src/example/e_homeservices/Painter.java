package example.e_homeservices;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class Painter extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_painter);
		String str=getIntent().getExtras().getString("user").toString();
		this.setTitle(str);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.painter, menu);
		TextView Interior_Painting = (TextView)findViewById(R.id.textView2);
		TextView Texture_Painting = (TextView)findViewById(R.id.textView3);
		TextView Wood_Polishing = (TextView)findViewById(R.id.textView5);
		TextView Door_Window_Painting = (TextView)findViewById(R.id.textView4);
		Interior_Painting.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Painter.this,Painting1.class);
			intent.putExtra("user", getTitle().toString());
				startActivity(intent);
				finish();
			}
		});
		Texture_Painting.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Painter.this,Painting1.class);
				intent.putExtra("user", getTitle().toString());	
				startActivity(intent);
				finish();
			}
		});
		Wood_Polishing.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	Intent intent = new Intent(Painter.this,Painting1.class);
	intent.putExtra("user", getTitle().toString());
				startActivity(intent);
				finish();
				
			}
		});
		Door_Window_Painting.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	Intent intent = new Intent(Painter.this,Painting1.class);
	intent.putExtra("user", getTitle().toString());
				startActivity(intent);
				finish();
				
			}
		});
		return true;
	}

}
