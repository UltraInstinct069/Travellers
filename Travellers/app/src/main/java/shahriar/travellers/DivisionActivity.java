package shahriar.travellers;

        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.ListView;
        import android.widget.TextView;

        import java.io.File;
        import java.util.ArrayList;
        import java.util.List;

public class DivisionActivity extends AppCompatActivity {
    ListView lv;
    private List<Model> myVIDS = new ArrayList<Model>();
    public static ArrayList<File> myvids;
    ArrayAdapter<Model> adp;
    String[] items={"Dhaka","Barishal","Syhlet","Chittagong","Khulna","RAjshahi"};

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);
        lv = (ListView) findViewById(R.id.listView);


        myVIDS.add(new Model(items[0], R.drawable.dhaka, items[0]));
        myVIDS.add(new Model(items[1], R.drawable.barishal, items[1]));
        myVIDS.add(new Model(items[2], R.drawable.sylhet, items[2]));
        myVIDS.add(new Model(items[3], R.drawable.ctg, items[3]));
        myVIDS.add(new Model(items[4], R.drawable.khunla, items[4]));
        myVIDS.add(new Model(items[5], R.drawable.rajshahi, items[5]));


        adp = new MyListadapter();
        lv.setAdapter(adp);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getBaseContext(), PlacesActivity.class).putExtra("positn", position));
            }
        });
    }


    public class  MyListadapter extends ArrayAdapter<Model>{
        public MyListadapter(){
            super(DivisionActivity.this,R.layout.format,myVIDS);
        }

        public MyListadapter(Context context, int resource) {
            super(context, resource);
        }

        public View getView(int position,View convertView,ViewGroup parent){
            View itemView=convertView;
            if (itemView == null) {
                itemView=getLayoutInflater().inflate(R.layout.format,parent,false);
            }
            Model current=myVIDS.get(position);
            ImageView imageview=(ImageView)itemView.findViewById((R.id.imageView));
            imageview.setImageResource(current.getIconID());
            TextView maketext=(TextView)itemView.findViewById(R.id.textView_disname);
            maketext.setText(current.getName());
            TextView sizee=(TextView)itemView.findViewById(R.id.textView_detail);
            sizee.setText(current.getSize());

            return itemView;
            //    return super.getView(position,convertView,parent);
        }
    }

}

