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

		Intent testIntent = new SimpleFragmentActivity.IntentBuilder(this, Fragment.class).create();
		startActivity(testIntent);

		this.finish();
	}
}
