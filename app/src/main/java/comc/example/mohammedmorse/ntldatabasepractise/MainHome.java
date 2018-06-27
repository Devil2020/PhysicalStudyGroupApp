package comc.example.mohammedmorse.ntldatabasepractise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainHome extends AppCompatActivity {
ContractClass contractClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        contractClass=new ContractClass();
        ContractClass contractClass = new ContractClass();
        Intent intent= getIntent();
        contractClass.setId(intent.getIntExtra(ContractClass.IdColum,0));
        contractClass.setName(intent.getStringExtra(ContractClass.FirstColum));
        contractClass.setPassword(intent.getStringExtra(ContractClass.SecondColum));
    }
}
