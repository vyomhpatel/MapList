package b12app.vyom.com.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by vyompatel on 3/27/18.
 */

public class MyAdapter extends BaseAdapter {

    int [] myImages;
    String[] myCountries;

    Context context;

    LayoutInflater layoutInflater;

    public MyAdapter(int[] myImages, String[] myCountries, Context context) {
        this.myImages = myImages;
        this.myCountries = myCountries;
        this.context = context;

        layoutInflater  = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return myCountries.length;
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
    public View getView(final int position, View view, ViewGroup viewGroup) {

        View v = layoutInflater.inflate(R.layout.list_layout, null);
        TextView item_tv = v.findViewById(R.id.tv_item);
        ImageView imageView = v.findViewById(R.id.image);

        item_tv.setText(myCountries[position]);  //set text from position of the array countries.
        imageView.setImageResource(myImages[position]); //set image from position of array images.

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"clicked: "+myCountries[position],Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}
