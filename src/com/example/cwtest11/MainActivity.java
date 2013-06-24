package com.example.cwtest11;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import edu.kpi.asu.rduboveckij.cam.CAMImpl;
import edu.kpi.asu.rduboveckij.cam.utils.CommonUtils;
import edu.kpi.asu.rduboveckij.cam.utils.GenTestData;

public class MainActivity extends Activity {
	private TextView text;
	private static final String HOST_NAME = "http://floating-atoll-1202.herokuapp.com/";
	private CAMImpl cam = new CAMImpl();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (TextView) findViewById(R.id.hello);
		text.setText("" + computing(2, 3));
	}

	public int computing(Integer a, Integer b) {
		return a + b;
	}

	public int remoteComputing(Integer a, Integer b) {
		return a * b;
	}

	public void experiments() {
		GenTestData.instance("1", 15, 0.5, 1.5, 2, 2, 2);
		GenTestData.instance("2", 15, 0.5, 1.5, 4, 3, 4);
		GenTestData.instance("3", 15, 0.5, 1.5, 5, 4, 5);
		GenTestData.instance("4", 15, 0.5, 1.5, 8, 6, 8);
		GenTestData.instance("5", 15, 0.5, 1.5, 15, 10, 15);
		GenTestData.experiments(CommonUtils.newArray(0.5, 0.9, 0.7));
	}

	public CAMImpl getCam() {
		return cam;
	}

	public void setCam(CAMImpl cam) {
		this.cam = cam;
	}
}
