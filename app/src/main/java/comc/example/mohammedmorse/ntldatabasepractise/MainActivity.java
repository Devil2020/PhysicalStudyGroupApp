package comc.example.mohammedmorse.ntldatabasepractise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText Name , Password;
DataBaseClass baseClass;
 ContractClass contractClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    Name=findViewById(R.id.Name);
    Password=findViewById(R.id.id);
  contractClass=new ContractClass();
  contractClass.setName("morse");
  contractClass.setPassword("1234");
    baseClass=new DataBaseClass(this);
    baseClass.InsertRow(contractClass);
    }

    public void LoginPress(View view) {
     ContractClass contractClass=new ContractClass();
     contractClass.setName(Name.getText().toString());
     contractClass.setPassword(Password.getText().toString());
   boolean b=baseClass.CheckIfInDataBaseOrNot(contractClass);
   if(b==true){
       Intent intent=new Intent(this,MainHome.class);
       intent.putExtra(ContractClass.IdColum,"");
       intent.putExtra(ContractClass.FirstColum,"");
       intent.putExtra(ContractClass.SecondColum,"");
       startActivity(intent);
   }
   else
       Toast.makeText(this, "The User isn`t in Database", Toast.LENGTH_LONG).show();
    }
}
