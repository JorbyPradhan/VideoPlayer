# VideoPlayer
# Best for OnlineVideoPlayer
# usage

<h3>step 1</h3>
# Add it in your root build.gradle at the end of repositories:

 allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
  
 Step 2. Add the dependency
 
 dependencies {
	        implementation 'com.github.JorbyPradhan.VideoPlayer:mkvideoplayer:0.1.0'
	}

# In manifests 
 <activity android:name=".WatchMovieActivity"
    android:configChanges="keyboardHidden|orientation|screenSize"
    android:screenOrientation="sensor"
		 android:theme="@style/AppTheme.NoActionBar">

# In layout
 <?xml version="1.0" encoding="utf-8"?>
 <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".WatchMovieActivity">
    <include
        layout="@layout/mk_player"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
 </androidx.constraintlayout.widget.ConstraintLayout>

# In activity
 player = new MKPlayer(this);
        player.play("url");
