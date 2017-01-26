package com.example.bruno.fabspeeddial;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPropertyAnimatorListener {
  private static final String TAG = MainActivity.class.getSimpleName();
  private FloatingActionButton mFab;
  private FloatingActionButton mFabMiniA;
  private FloatingActionButton mFabMiniB;
  private FloatingActionButton mFabMiniC;
  private FloatingActionButton mFabMiniD;
  private FloatingActionButton mFabMiniE;
  private AccelerateDecelerateInterpolator mInterpolator;

  private static final int DURATION_ROTATION = 500;
  private static final int DURATION_TRANSLATION = 800;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    mFab = (FloatingActionButton) findViewById(R.id.fab);
    mFab.setOnClickListener(this);

    mFabMiniA = (FloatingActionButton) findViewById(R.id.fabMiniA);
    mFabMiniB = (FloatingActionButton) findViewById(R.id.fabMiniB);
    mFabMiniC = (FloatingActionButton) findViewById(R.id.fabMiniC);
    mFabMiniD = (FloatingActionButton) findViewById(R.id.fabMiniD);
    mFabMiniE = (FloatingActionButton) findViewById(R.id.fabMiniE);

    mInterpolator = new AccelerateDecelerateInterpolator();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onClick(View v) {
    int id = v.getId();
    if (id == R.id.fab) {
      toggleFabMinis();
    }
  }

  private void toggleFabMinis(){
    if (mFabMiniA.getVisibility() == View.GONE) {
      showFabMinis();
    }else {
      hideFabMinis();
    }
  }

  private void showFabMinis(){
    Log.i(TAG, "ShowFabMinis");
    ViewCompat.animate(mFab).rotation(45f).withLayer().setDuration(DURATION_ROTATION).setInterpolator(mInterpolator).start();

    mFabMiniA.setVisibility(View.VISIBLE);
    mFabMiniB.setVisibility(View.VISIBLE);
    mFabMiniC.setVisibility(View.VISIBLE);
    mFabMiniD.setVisibility(View.VISIBLE);
    mFabMiniE.setVisibility(View.VISIBLE);

    ViewCompat.animate(mFabMiniA).translationY(-getResources().getDimensionPixelOffset(R.dimen.fab_mini_a_bottom_margin)).setDuration(DURATION_TRANSLATION).setListener(null).setInterpolator(mInterpolator).start();
    ViewCompat.animate(mFabMiniB).translationY(-getResources().getDimensionPixelOffset(R.dimen.fab_mini_b_bottom_margin)).setDuration(DURATION_TRANSLATION).setListener(null).setInterpolator(mInterpolator).start();
    ViewCompat.animate(mFabMiniC).translationY(-getResources().getDimensionPixelOffset(R.dimen.fab_mini_c_bottom_margin)).setDuration(DURATION_TRANSLATION).setListener(null).setInterpolator(mInterpolator).start();
    ViewCompat.animate(mFabMiniD).translationY(-getResources().getDimensionPixelOffset(R.dimen.fab_mini_d_bottom_margin)).setDuration(DURATION_TRANSLATION).setListener(null).setInterpolator(mInterpolator).start();
    ViewCompat.animate(mFabMiniE).translationY(-getResources().getDimensionPixelOffset(R.dimen.fab_mini_e_bottom_margin)).setDuration(DURATION_TRANSLATION).setListener(null).setInterpolator(mInterpolator).start();
  }

  private void hideFabMinis(){
    Log.i(TAG, "HideFabMinis");
    ViewCompat.animate(mFab).rotation(0).withLayer().setDuration(DURATION_ROTATION).setInterpolator(mInterpolator).setListener(null).start();

    ViewCompat.animate(mFabMiniA).translationYBy(getResources().getDimensionPixelOffset(R.dimen.fab_mini_a_bottom_margin)).setDuration(DURATION_TRANSLATION).setListener(this).setInterpolator(new FastOutSlowInInterpolator()).start();
    ViewCompat.animate(mFabMiniB).translationYBy(getResources().getDimensionPixelOffset(R.dimen.fab_mini_b_bottom_margin)).setDuration(DURATION_TRANSLATION).setListener(this).setInterpolator(new FastOutSlowInInterpolator()).start();
    ViewCompat.animate(mFabMiniC).translationYBy(getResources().getDimensionPixelOffset(R.dimen.fab_mini_c_bottom_margin)).setDuration(DURATION_TRANSLATION).setListener(this).setInterpolator(new FastOutSlowInInterpolator()).start();
    ViewCompat.animate(mFabMiniD).translationYBy(getResources().getDimensionPixelOffset(R.dimen.fab_mini_d_bottom_margin)).setDuration(DURATION_TRANSLATION).setListener(this).setInterpolator(new FastOutSlowInInterpolator()).start();
    ViewCompat.animate(mFabMiniE).translationYBy(getResources().getDimensionPixelOffset(R.dimen.fab_mini_e_bottom_margin)).setDuration(DURATION_TRANSLATION).setListener(this).setInterpolator(new FastOutSlowInInterpolator()).start();
  }

  @Override
  public void onAnimationStart(View view) {}

  @Override
  public void onAnimationEnd(View view) {
    int id = view.getId();
    if (id == R.id.fabMiniA || id == R.id.fabMiniB || id == R.id.fabMiniC || id == R.id.fabMiniD || id == R.id.fabMiniE) {
      view.setVisibility(View.GONE);
    }
  }

  @Override
  public void onAnimationCancel(View view) { }
}
