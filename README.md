# SimpleFragmentActivity
Basic Activity that handles displaying a custom fragment.

## How to use it

Add SimpleFragmentActivity to your AndroidManifest
```xml
	<activity android:name="com.jt.activity.SimpleFragmentActivity" />
```

### Basic Usage
To launch your custom fragment in this wrapper activity simple use one of the intent factory methods and start the activity.

```java
	Intent testIntent = SimpleFragmentActivity.getActivityIntent(this, MyFragment.class);
	startActivity(testIntent);
```

### Advanced Options
```java
public static Intent getActivityIntent(Context context,
                                       Class<?> activityClass,
                                       Class<?> fragmentClass,
                                       String tag,
                                       int titleId,
                                       int themeId)
```
                                       
Returns an intent for the specified activity with with the specified title, theme, fragment, and fragment tag.

Parameters:
* context - The calling context being used to instantiate the activity.
* activityClass - Optional activity class (use for inherited classes), defaults to SimpleFragmentActivity.
* fragmentClass - The fragment class that is to be launched inside this activity.
* tag - Optional tag name for the fragment, defaults to fragment class name.
* titleId - Optional string resource for title to display for activity.
* themeId - Optional style resource describing the theme of the activity.

### Subclassing
You can also subclass this activty and then use one of the intent factory methods that takes in the subclass (this allows you to customize the subclass's style, label, usage restrictions, etc in AndroidManifest).

```java
	Intent testIntent = MySimpleFragmentActivity.getActivityIntent(this, MySimpleFragmentActivity.class, MyFragment.class);
	startActivity(testIntent);
```
