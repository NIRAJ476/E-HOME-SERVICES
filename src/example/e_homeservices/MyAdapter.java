package example.e_homeservices;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    ArrayList<Provider> list;
    LayoutInflater inflate;
    public MyAdapter(Context ctx,ArrayList<Provider> list)
    {
        this.list=list;
       inflate=LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RelativeLayout layout=(RelativeLayout)inflate.inflate(R.layout.list_view,parent,false);

        TextView txtname=(TextView)layout.findViewById(R.id.textView1);
        TextView txtcontact=(TextView)layout.findViewById(R.id.textView2);
        

        Provider curr=list.get(position);
        txtname.setText(curr.getName());
        txtcontact.setText(curr.getContact());
        
        layout.setTag(curr.getID());
        return layout;
    }
}
