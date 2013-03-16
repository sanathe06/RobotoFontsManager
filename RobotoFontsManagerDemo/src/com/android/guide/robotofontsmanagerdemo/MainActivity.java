package com.android.guide.robotofontsmanagerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.ViewGroup;

import com.android.guide.robotofontsmanager.RobotoFontManager;
import com.android.guide.robotofontsmanager.RobotoFontManager.RobotoType;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 ViewGroup root = (ViewGroup) this.getWindow().getDecorView();
		 /*you can set Roboto font any where you want*/
		 
		 /*if you need not to set specific element you can set it in root view like this 
		  * it will apply font for all it's child views*/
		 RobotoFontManager.setFont(this, root, RobotoType.RobotoRegular);
		 
		 /*you can set font element by element*/
		 RobotoFontManager.setFont(this, root.findViewById(R.id.checkBox1), RobotoType.RobotoThin);
		 RobotoFontManager.setFont(this, root.findViewById(R.id.button2), RobotoType.RobotoLight);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
