package tr.com.mis49m.customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SocialNetworkArrayAdapter extends ArrayAdapter<SocialNetwork> {

    int resourceId;

    public SocialNetworkArrayAdapter(Context context, int resourceId, ArrayList<SocialNetwork> list) {
        super(context, resourceId, list);
        this.resourceId = resourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final SocialNetwork socialNetwork = getItem(position);
        ViewHolder viewHolder;

        if(convertView==null){
            // inflate the layout
            convertView = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

            // set up the ViewHolder
            viewHolder = new ViewHolder();
            viewHolder.tvLabel = (TextView) convertView.findViewById(R.id.label);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.chk = (CheckBox) convertView.findViewById(R.id.checkbox);

            // store the holder with the view.
            convertView.setTag(viewHolder);
        }else{
            // not call findViewById everytime, call viewholder
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // assign values
        if(viewHolder!=null) {
            viewHolder.tvLabel.setText(socialNetwork.getName());
            viewHolder.image.setImageResource(socialNetwork.getImage());
            viewHolder.chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                    socialNetwork.setChecked(arg1);
                }
            });
        }

        return convertView;
    }

    static class ViewHolder{
        TextView tvLabel;
        ImageView image;
        CheckBox chk;
    }
}
