package user;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.royle.nofix.R;
import com.royle.nofix.SecondAuthenThread;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import helper.DataStore;
import movie3.MovieDetailActivity;
import movie3.MovieActivity;


public class SupportActivity extends Activity {
    //widget
//	private Button btnTranfer;
//	private Button btnTrueMoney;

    private Button WebMail;
    private Button QuickSupport;
    private Button Support;
    Intent intent;
    private DataStore dataStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_support);

        dataStore = new DataStore(SupportActivity.this);

        initWidget();

//		btnTranfer.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				Intent   intent = new Intent(RefillActivity.this,TransferActivity.class);
//				startActivity(intent);
//				finish();
//			}
//		});

//		btnTrueMoney.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				Intent   intent = new Intent(RefillActivity.this,CheckTrueMoneyActivity.class);
//				startActivity(intent);
//				finish();
//			}
//		});

        Support.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View v) {

                intent = new Intent(SupportActivity.this, HowtoActivity.class);
                intent.putExtra("id", "33");
                startActivity(intent);
            }
        });



//==============================================
//        Check Authen Before go to Service
//        =====================================
        WebMail.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (dataStore.checkUser()) {
                    secondAuthen();
                } else {

                    startActivity(new Intent(SupportActivity.this, LoginActivity.class));
                    finish();

                }   // if
            }   // onClick

        });






        QuickSupport.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                try {
                    if (appInstalledOrNot("com.teamviewer.quicksupport.market")) {

                        PackageManager manager = getPackageManager();
                        Intent qs = manager.getLaunchIntentForPackage("com.teamviewer.quicksupport.market");
                        qs.addCategory(Intent.CATEGORY_LAUNCHER);
                        startActivity(qs);

                    } else {
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://pnsat.com/mx/quicksupport.apk"));
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);


                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }   // Main Method

    private void secondAuthen() {

        String url = "http://2654k.com/Constant/secondPassword.php";
        try {

            SecondAuthenThread secondAuthenThread = new SecondAuthenThread(SupportActivity.this);
            secondAuthenThread.execute(url);
            String response = secondAuthenThread.get();

            Log.d("8MarV1", "response ==> " + response);

            JSONArray jsonArray = new JSONArray(response);
            final JSONObject jsonObject = jsonArray.getJSONObject(0);

            AlertDialog.Builder builder = new AlertDialog.Builder(SupportActivity.this);
            builder.setTitle("Second Authen");
            LayoutInflater layoutInflater = SupportActivity.this.getLayoutInflater();
            final View view = layoutInflater.inflate(R.layout.alert_dialog_second_authen, null);
            builder.setView(view);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    EditText editText = (EditText) view.findViewById(R.id.edtPasswordAuthen);
                    String password = editText.getText().toString().trim();

                    try {
                        if (password.equals(jsonObject.getString("Password"))) {
                            moveToServiceMovie();
                        } else {
                            Toast.makeText(SupportActivity.this, "Password False", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });
            builder.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

//        Success
//        moveToServiceMovie();

    }

    private void moveToServiceMovie() {
        Intent intent = new Intent(SupportActivity.this, MovieActivity.class);
        startActivity(intent);
        finish();
    }


    public void initWidget() {
//		btnTranfer = (Button) findViewById(R.id.btnTranfer);
//		btnTrueMoney = (Button) findViewById(R.id.btnTrueMoney);

        WebMail = (Button) findViewById(R.id.sendemail);
        QuickSupport = (Button) findViewById(R.id.QuickSupport);
        Support = (Button) findViewById(R.id.Support);
    }


    // check for the app if it exist in the phone it will lunch it otherwise, it will search for the app in google play app in the phone and to avoid any crash, if no google play app installed in the phone, it will search for the app in the google play store using the browser :

//	public static boolean openApp(Context context) {
//
//		PackageManager manager = context.getPackageManager();
//		Intent i = manager.getLaunchIntentForPackage("com.teamviewer.quicksupport.market");
//		if (i == null) {
//			return false;
//			// throw new PackageManager.NameNotFoundException();
//		}
//		i.addCategory(Intent.CATEGORY_LAUNCHER);
//		context.startActivity(i);
//		return true;
//	}

    private boolean appInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }


}
