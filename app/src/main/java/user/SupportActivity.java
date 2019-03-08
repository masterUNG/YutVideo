package user;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.royle.nofix.R;

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
                    moveToServiceMovie();
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
