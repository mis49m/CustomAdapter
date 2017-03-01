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

public class SocialNetworkArrayAdapter2 extends ArrayAdapter<SocialNetwork> {

    int resourceId;

    public SocialNetworkArrayAdapter2(Context context, int resourceId, ArrayList<SocialNetwork> list) {
        super(context, resourceId, list);
        this.resourceId = resourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get current item from list
        final SocialNetwork socialNetwork = getItem(position);

        // if null, create list item view
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        }

        // Read references from layout
        CheckBox chk = (CheckBox) convertView.findViewById(R.id.checkbox);
        ImageView img = (ImageView) convertView.findViewById(R.id.image);
        TextView label = (TextView) convertView.findViewById(R.id.label);

        // Assign values from item to layout
        chk.setChecked(socialNetwork.isChecked());
        img.setImageResource(socialNetwork.getImage());
        label.setText(socialNetwork.getName());

        // Set operations &  Assign values from layout to item
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                socialNetwork.setChecked(isChecked);
            }
        });

        // Return created list item
        return convertView;
    }


}
