package commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.ITestResult;

// Muc dich cua file VertificationFailures la: no se get nhung cai Error va dua vao file report cho minh.

public class VertificationFailures extends HashMap<ITestResult, List<Throwable>> {
	private static final long serialVersionUID = 1;
	private static VertificationFailures failures;

	private VertificationFailures() {
		super();
	}

	public static VertificationFailures getFailures() {

		if (failures == null) {
			failures = new VertificationFailures();
		}
		return failures;
	}

	public List<Throwable> getFailuresForTest(ITestResult result) {
		List<Throwable> exceptions = get(result);
		return exceptions == null ? new ArrayList<Throwable>() : exceptions;
	}

	public void addFailureForTest(ITestResult result, Throwable throwable) {
		List<Throwable> exceptions = getFailuresForTest(result);
		exceptions.add(throwable);
		put(result, exceptions);
	}
}
