package b12app.vyom.com.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by vyompatel on 3/27/18.
 */

public class MyAdapter extends BaseAdapter {

    ArrayList<Integer> myImages;
    ArrayList<String> myCountries;

    Context context;

    LayoutInflater layoutInflater;

//    View v ;

    public MyAdapter(ArrayList<Integer> myImages, ArrayList<String> myCountries, Context context) {
        this.myImages = myImages;
        this.myCountries = myCountries;
        this.context = context;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return myCountries.size();
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
        MyViewHolder myViewHolder;


        if (view == null) {

            myViewHolder = new MyViewHolder();
            view = layoutInflater.inflate(R.layout.list_layout, null);
            myViewHolder.itemTextView = view.findViewById(R.id.tv_item);
            myViewHolder.imageView = view.findViewById(R.id.image);

            view.setTag(myViewHolder);

        } else {

            myViewHolder = (MyViewHolder) view.getTag();

        }


//        TextView item_tv = v.findViewById(R.id.tv_item);
//        ImageView imageView = v.findViewById(R.id.image);

//        item_tv.setText(myCountries[position]);  //set text from position of the array countries.
//        imageView.setImageResource(myImages[position]); //set image from position of array images.
//
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context,"clicked: "+myCountries[position],Toast.LENGTH_SHORT).show();
//
//            }
//        });

        myViewHolder.itemTextView.setText(myCountries.get(position));

        myViewHolder.imageView.setImageResource(myImages.get(position));


        return view;
    }

    public class MyViewHolder {
        TextView itemTextView;
        ImageView imageView;


    }
}
