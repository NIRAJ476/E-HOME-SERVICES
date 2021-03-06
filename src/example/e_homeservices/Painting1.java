package example.e_homeservices;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Painting1 extends Activity {
	CheckBox c1,c2,c3,c4,c5,c6,c7;
	String message;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_painting1);
		String str=getIntent().getExtras().getString("user").toString();
		this.setTitle(str);
		c1=(CheckBox)findViewById(R.id.checkBox1);
		c2=(CheckBox)findViewById(R.id.checkBox2);
		c3=(CheckBox)findViewById(R.id.checkBox3);
		c4=(CheckBox)findViewById(R.id.checkBox4);
		c5=(CheckBox)findViewById(R.id.checkBox5);
		c6=(CheckBox)findViewById(R.id.checkBox6);
		c7=(CheckBox)findViewById(R.id.checkBox7);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.painting1, menu);
		Button Continue = (Button)findViewById(R.id.button1);
		Continue.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String message="   ";
				if(c1.isChecked())
				{
					message+=c1.getText().toString();
				}
				 if(c2.isChecked())
				{
					message+=c2.getText().toString();
				}
				 if(c3.isChecked())
				{
					message=c3.getText().toString();
				}
				 if(c4.isChecked())
				{
					message=c4.getText().toString();
				}
				 if(c5.isChecked())
					{
						message+=c5.getText().toString();
					}
					 if(c6.isChecked())
					{
						message+=c6.getText().toString();
					}
					 if(c7.isChecked())
					{
						message=c7.getText().toString();
					}
					
					
					 if(!c1.isChecked()&&!c2.isChecked()&&!c3.isChecked()&&!c4.isChecked()&&!c5.isChecked()&&!c6.isChecked()&&!c7.isChecked())
				{
					Toast.makeText(getApplicationContext(), "Please Choose Any Service..", Toast.LENGTH_LONG).show();
					return;
				}
				
	           Intent intent = new Intent(Painting1.this,SendService.class);
	           intent.putExtra("user",Painting1.this.getTitle().toString());
	           intent.putExtra("service", message);
	           intent.putExtra("usertype", "Painter");
				startActivity(intent);

	                
			}
		});
		return true;
	}

}
