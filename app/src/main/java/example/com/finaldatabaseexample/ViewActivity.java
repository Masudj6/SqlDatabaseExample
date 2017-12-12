package example.com.finaldatabaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {


    ArrayList<Person> allData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        MyDatabase instans = MyDatabase.getInstans(getApplicationContext());
         allData = instans.getAllTableData();




    }
}
