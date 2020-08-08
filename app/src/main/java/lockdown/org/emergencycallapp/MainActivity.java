package lockdown.org.emergencycallapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity
{
    Button btnPolice, btnFire, btnMedical;
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= 23)
        {
            if (ContextCompat.checkSelfPermission(MainActivity.this, "android.permission.CALL_PHONE") != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{"android.permission.CALL_PHONE"},1);
            }
        }
        btnPolice = findViewById(R.id.btnPolice);
        btnFire = findViewById(R.id.btnFire);
        btnMedical = findViewById(R.id.btnMedical);
        btnPolice.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i = new Intent("android.intent.action.CALL");
                i.setData(Uri.parse("tel:100"));
                startActivity(i);
            }
        });
        btnFire.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i = new Intent("android.intent.action.CALL");
                i.setData(Uri.parse("tel:101"));
                startActivity(i);
            }
        });
        btnMedical.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i = new Intent("android.intent.action.CALL");
                i.setData(Uri.parse("tel:108"));
                startActivity(i);
            }
        });
    }
}
