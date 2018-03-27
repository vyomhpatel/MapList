package b12app.vyom.com.listview;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class List extends AppCompatActivity {

    String[] countries = {"India","United States","United Kingdom","China","Nepal","Japan"};

    int[] images ={R.drawable.india,R.drawable.usa,R.drawable.uk,R.drawable.china,R.drawable.nepal,R.drawable.japan} ;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listView);
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,countries);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_layout,R.id.tv_item,countries);


//            listView.setAdapter(arrayAdapter);


        MyAdapter myAdapter = new MyAdapter(images,countries,List.this);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              String country = arrayAdapter.getItem(i);


                    Uri uri = Uri.parse("geo:0,0?q="+country);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);

                Toast.makeText(List.this,"Contry: "+country,Toast.LENGTH_SHORT).show();









            }
        });
    }
}
