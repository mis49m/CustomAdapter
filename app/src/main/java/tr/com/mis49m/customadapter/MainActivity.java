package tr.com.mis49m.customadapter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ListView listView;
    private ArrayList<SocialNetwork> socialNetworks=new ArrayList<SocialNetwork>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        listView = (ListView) findViewById(R.id.listview);

        socialNetworks.add(new SocialNetwork("Facebook", R.drawable.facebook, false));
        socialNetworks.add(new SocialNetwork("Google+", R.drawable.googlep, false));
        socialNetworks.add(new SocialNetwork("Twitter", R.drawable.twitter, false));
        socialNetworks.add(new SocialNetwork("Linkedin", R.drawable.linkedin, false));

        //SocialNetworkArrayAdapter adapter=new SocialNetworkArrayAdapter(this, R.layout.list_item, socialNetworks);

        SocialNetworkBaseAdapter adapter = new SocialNetworkBaseAdapter(this, R.layout.list_item, socialNetworks);
        spinner.setAdapter(adapter);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view.findViewById(R.id.label);
                Toast.makeText(getApplicationContext(), tv.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
