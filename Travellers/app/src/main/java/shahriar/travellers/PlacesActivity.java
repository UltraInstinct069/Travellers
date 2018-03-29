package shahriar.travellers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class PlacesActivity extends AppCompatActivity {

    public int pos;
    ListView lv;
    private List<Model> myVID = new ArrayList<Model>();

    ArrayAdapter<Model> adp;
    String[] items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        lv=(ListView)findViewById(R.id.listView_Place);

        Intent i=getIntent();
        pos =i.getIntExtra("positn",0);
        if(pos==0){
            myVID.add(new Model("Ahsan Monjil", R.drawable.document,"sadarghat"));
            myVID.add(new Model("LalBagh Kella", R.drawable.document,"Shat rouja"));

        }
        else if(pos==1){
            myVID.add(new Model("", R.drawable.document,"sadarghat"));
            myVID.add(new Model("LalBagh Kella", R.drawable.document,"Shat rouja"));
        }
        else if(pos==2){
            myVID.add(new Model("Madhobpur lake", R.drawable.document,"Srimongol"));
            myVID.add(new Model("Lauyachara National park", R.drawable.document,"Srimongol"));
        }
        else if(pos==3){
            myVID.add(new Model("Cox Bazar", R.drawable.document,"Cox Bazar"));
            myVID.add(new Model("Himchori", R.drawable.document,"Cox Bazar"));
        }
        else if(pos==4){
            myVID.add(new Model("Shundorban", R.drawable.document,"Khulna"));
            myVID.add(new Model("Shat gombuj Mosque", R.drawable.document,"Khulna"));
        }
        else if(pos==5){
            myVID.add(new Model("Borendro jadukor", R.drawable.document,"Rajshahi"));
            myVID.add(new Model("Birishiri", R.drawable.document,"Rajshahi"));
        }
        adp=new MyListadapter();
        lv.setAdapter(adp);


    }

    public class  MyListadapter extends ArrayAdapter<Model>{
        public MyListadapter(){
            super(PlacesActivity.this,R.layout.format,myVID);
        }

        public MyListadapter(Context context, int resource) {
            super(context, resource);
        }

        public View getView(int position,View convertView,ViewGroup parent){
            View itemView=convertView;
            if (itemView == null) {
                itemView=getLayoutInflater().inflate(R.layout.format,parent,false);
            }
            Model current=myVID.get(position);
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
