package quanta;

import com.google.zxing.client.android.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;

public class CMainActivity extends Activity {
	final private int LAUNCH_GAME = 0;
	private static final String TAG = CMainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cmain);
		Log.d(TAG, "CMainActivity onCreate");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		Log.d(TAG, "onCreateOptionsMenu onCreate");
		menu.add(0, 0, 0, "xxxx");
		menu.add(0, 1, 1, "YYYY");
		
		Button btnPreview = (Button)findViewById(R.id.button1);
		btnPreview.setOnClickListener(btnPreviewOnClkLis);
		
		return super.onCreateOptionsMenu(menu);
	}
	
	private Button.OnClickListener btnPreviewOnClkLis = new Button.OnClickListener() {
        public void onClick(View v) {
        	Log.d(TAG, "enter btnPreviewOnClkLis onClick!");
            Intent it = new Intent();
            it.setClass(CMainActivity.this, com.google.zxing.client.android.CaptureActivity.class);
            startActivityForResult(it, LAUNCH_GAME);
        }
    };
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent  data) {
        if (requestCode != LAUNCH_GAME)
            return;

        switch (resultCode) {
        case RESULT_OK:
        	Log.d(TAG, "RESULT_CANCELED");
            Bundle bundle = data.getExtras();

            int iCountSet = bundle.getInt("KEY_COUNT_SET");
            int iCountPlayerWin = bundle.getInt("KEY_COUNT_PLAYER_WIN");
            int iCountComWin = bundle.getInt("KEY_COUNT_COM_WIN");
            int iCountDraw = bundle.getInt("KEY_COUNT_DRAW");

//            mTxtResult.setText(s);
            break;
        case RESULT_CANCELED:
        	Log.d(TAG, "RESULT_CANCELED");
        }
    }
}
