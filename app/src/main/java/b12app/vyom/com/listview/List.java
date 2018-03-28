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

import java.util.ArrayList;
import java.util.Arrays;

public class List extends AppCompatActivity {

    String[] countries = {"India","United States","United Kingdom","China","Nepal","Japan"};

    Integer[] images ={R.drawable.india,R.drawable.usa,R.drawable.uk,R.drawable.china,R.drawable.nepal,R.drawable.japan} ;
    ListView listView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listView);
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,countries);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_layout,R.id.tv_item,countries);


//            listView.setAdapter(arrayAdapter);
        ArrayList<String> countries_list = new ArrayList<>(Arrays.asList(countries));
        ArrayList<Integer> images_list = new ArrayList<>(Arrays.asList(images));

        myAdapter = new MyAdapter(images_list,countries_list,List.this);
        listView.setAdapter(myAdapter);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {


                myAdapter.myCountries.remove(i);
                myAdapter.myImages.remove(i);
                myAdapter.notifyDataSetChanged();

                return true;
            }
        });

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
