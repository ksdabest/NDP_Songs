package sg.edu.rp.c346.id21021230.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListVIew extends AppCompatActivity {

    Button btnShowFiveStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        al = new ArrayList<ContactsContract.CommonDataKinds.Note>();
        aa = new ArrayAdapter<ContactsContract.CommonDataKinds.Note>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song data = al.get(position);
                Intent i = new Intent(MainActivity.this,
                        ListView.class);
                i.putExtra("data", data);
                startActivity(i);
            }
    }
                btnShowFiveStar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DBHelper dbh = new DBHelper(MainActivity.this);
                        al.clear();
                        String filterNumber = etStars.getText().toString().trim();
                        if (filterNumber.length() == 0) {
                            al.addAll(dbh.getAllNotes());
                        } else {
                            al.addAll(dbh.getAllNotes(filterNumber));
                        }
                        aa.notifyDataSetChanged();
                    }
}