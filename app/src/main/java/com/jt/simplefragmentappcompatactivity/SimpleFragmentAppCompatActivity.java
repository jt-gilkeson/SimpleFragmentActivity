/*
 * Copyright (C) 2015 J.T. Gilkeson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jt.simplefragmentappcompatactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Basic Activity that handles displaying a custom fragment
 */
public class SimpleFragmentAppCompatActivity extends AppCompatActivity
{
	private static final String TITLE         = "ActivityTitle";
	private static final String FRAGMENT_NAME = "FragmentName";
	private static final String FRAGMENT_TAG  = "FragmentTag";

	/**
	 * Returns an intent for a SimpleFragmentAppCompatActivity with the specified fragment.
	 */
	public static Intent getActivityIntent(Context context, Class<?> fragmentClass)
	{
		return getActivityIntent(context, null, fragmentClass, null, 0);
	}

	/**
	 * Returns an intent for the specified activity with the specified fragment.
	 */
	public static Intent getActivityIntent(Context context, Class<?> activityClass, Class<?> fragmentClass)
	{
		return getActivityIntent(context, activityClass, fragmentClass, null, 0);
	}

	/**
	 * Returns an intent for a SimpleFragmentAppCompatActivity with the specified title and specified fragment.
	 */
	public static Intent getActivityIntent(Context context, Class<?> fragmentClass, int titleId)
	{
		return getActivityIntent(context, null, fragmentClass, null, titleId);
	}

	/**
	 * Returns an intent for a SimpleFragmentAppCompatActivity with the specified fragment and fragment tag.
	 */
	public static Intent getActivityIntent(Context context, Class<?> fragmentClass, String tag)
	{
		return getActivityIntent(context, null, fragmentClass, tag, 0);
	}

	/**
	 * Returns an intent for the specified activity with the specified fragment and fragment tag.
	 */
	public static Intent getActivityIntent(Context context, Class<?> activityClass, Class<?> fragmentClass, String tag)
	{
		return getActivityIntent(context, activityClass, fragmentClass, tag, 0);
	}

	/**
	 * Returns an intent for the specified activity with with the specified title, the specified fragment, and fragment tag.
	 */
	public static Intent getActivityIntent(Context context, Class<?> activityClass, Class<?> fragmentClass, String tag, int titleId)
	{
		Intent intent = new Intent(context, activityClass == null ? SimpleFragmentAppCompatActivity.class : activityClass);
		intent.putExtra(TITLE, titleId);
		intent.putExtra(FRAGMENT_NAME, fragmentClass.getName());
		intent.putExtra(FRAGMENT_TAG, tag == null ? fragmentClass.getName() : tag);
		return intent;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		Bundle extras = getIntent().getExtras();

		if (extras == null || !extras.containsKey(FRAGMENT_NAME) || !extras.containsKey(FRAGMENT_TAG))
		{
			throw new IllegalArgumentException("Missing Fragment Information");
		}

		// set title if specified
		int title = extras.getInt(TITLE);
		if (title > 0)
		{
			setTitle(title);
		}

		if (savedInstanceState == null)
		{
			Fragment frag = Fragment.instantiate(this, extras.getString(FRAGMENT_NAME), extras);

			getSupportFragmentManager()
					.beginTransaction()
					.add(android.R.id.content, frag, extras.getString(FRAGMENT_TAG))
					.commit();
		}
	}
}
