package com.jt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Test Activity that launches SimpleFragmentActivity
 */
public class MainActivity extends AppCompatActivity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		Intent testIntent = new SimpleFragmentActivity.IntentBuilder(this, Fragment.class)
				.setFragmentTag("MyTag")
				.setTheme(R.style.Base_Theme_AppCompat_Light)
				.setTitle(R.string.app_name)
				.create();

		testIntent.putExtra("MyExtra", "MyValue");

		startActivity(testIntent);

		this.finish();
	}
}
