package example.com.finaldatabaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etName, etMobile;
    private Button btSave, btView;

    private static final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ini();





    }

    private void ini() {
        etMobile = (EditText) findViewById(R.id.etMobilie);
        etName = (EditText) findViewById(R.id.et_name);
        btSave = (Button) findViewById(R.id.btSave);
        btView = (Button) findViewById(R.id.btView);

        btView.setOnClickListener(this);
        btSave.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case  R.id.btSave:
                Log.e(TAG, "onClick btSave: ");

                checkValidataionAndInsertData();

                break;

            case R.id.btView:

                Log.e(TAG, "onClick btView: ");

                openViewAcitivty();

                break;


        }

    }

    private void openViewAcitivty() {

        Intent intent = new Intent(getApplicationContext(), ViewActivity.class);
        startActivity(intent);

    }

    private void checkValidataionAndInsertData() {
        String userName = etName.getText().toString().trim();
        String userMobileNumber = etMobile.getText().toString().trim();

        if (userName.equals("") || userMobileNumber.equals("")){
            Toast.makeText(getApplicationContext(), "Please fill up all field", Toast.LENGTH_LONG).show();

        }else {



           Person person = new Person(userName, userMobileNumber);

           MyDatabase instans = MyDatabase.getInstans(getApplicationContext());
            long isInsert = instans.insertData(person);

            if (isInsert == -1){
              Toast.makeText(getApplicationContext(), "Somthings worng....Please try agian", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_LONG).show();

            }

        }



    }
}
