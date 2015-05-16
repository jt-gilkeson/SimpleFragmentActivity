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

###Launch with a title
```java
	Intent testIntent = SimpleFragmentActivity.getActivityIntent(this, MyFragment.class, R.string.custom_title);
	startActivity(testIntent);
```

### Subclassing
You can also subclass this activty and then use one of the intent factory methods that takes in the subclass (this allows you to customize the subclass's style, label, usage restrictions, etc in AndroidManifest).

```java
	Intent testIntent = MySimpleFragmentActivity.getActivityIntent(this, MySimpleFragmentActivity.class, MyFragment.class);
	startActivity(testIntent);
```
