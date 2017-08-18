package example.e_homeservices;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ServiceMyAdapter extends BaseAdapter {

    ArrayList<Service> list;
    LayoutInflater inflate;
    public ServiceMyAdapter(Context ctx,ArrayList<Service> list)
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
        RelativeLayout layout=(RelativeLayout)inflate.inflate(R.layout.servicelist_view,parent,false);

        TextView txtname=(TextView)layout.findViewById(R.id.textView1);
        TextView txtcontact=(TextView)layout.findViewById(R.id.textView2);
        TextView txtservice=(TextView)layout.findViewById(R.id.textView4);

        Service curr=list.get(position);
        txtname.setText(curr.getName());
        txtcontact.setText(curr.getContact());
        txtservice.setText(curr.getService());
        layout.setTag(curr.getID());
        return layout;
    }
}
