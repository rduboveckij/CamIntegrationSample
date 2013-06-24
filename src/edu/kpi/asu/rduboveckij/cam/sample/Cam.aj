package edu.kpi.asu.rduboveckij.cam.sample;

import edu.kpi.asu.rduboveckij.cam.CAM;

public aspect Cam {
	pointcut incMethod(): execution(public int MainActivity.computing(Integer, Integer));

	int around(Integer a, Integer b): incMethod() && args(a, b) {
		MainActivity act = ((MainActivity) thisJoinPoint.getThis());
		CAM cam = act.getCam();
		int result;
		if (cam.onClient(act)) {
			result = proceed(a, b);
			cam.saveCurrentLogTime();
		} else {
			result = act.remoteComputing(a, b);
		}

		return result;
	}
}
