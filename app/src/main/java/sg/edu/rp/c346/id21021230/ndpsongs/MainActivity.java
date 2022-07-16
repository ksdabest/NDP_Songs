package sg.edu.rp.c346.id21021230.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnShow;
    TextView tvTitle, tvSinger,tvYear,tvStar;
    EditText etTitle,etSinger, etYear,etStar;
    ArrayList<Song> al;
    ListView lv;
    ArrayAdapter<Song> aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShow);
        tvTitle = findViewById(R.id.tvTitle);
        tvSinger = findViewById(R.id.tvSinger);
        tvYear = findViewById(R.id.tvYear);
        tvStar = findViewById(R.id.tvStar);

    }


    btnInsert.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View v){
        String data = etTitle.getText().toString();
        DBHelper dbh = new DBHelper(MainActivity.this);
        long inserted_id = dbh.insertNote(data);

        if (inserted_id != -1) {
            al.clear();
            al.addAll(dbh.getAllNotes());
            aa.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "Insert successful",
                    Toast.LENGTH_SHORT).show();
        }
    }
    }
        btnShow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListVIew.class));
            }
        }
    }
