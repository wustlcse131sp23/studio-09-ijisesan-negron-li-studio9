package studio9;

import assignment7.Student;

import java.util.HashMap;
import java.util.Map;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions
	private final Map<String, Student> roster;

	public UniversityDatabase() {
		roster = new HashMap<>();
	}

	public void addStudent(String accountName, Student student) {
		if (roster.get(accountName)==null) {
			roster.put(accountName, student);
		}
	}

	public int getStudentCount() {
		return roster.size();
	}

	public String lookupFullName(String accountName) {
		if (roster.get(accountName)!=null) {
			return roster.get(accountName).getFullName();
		} else {
			return null;
		}
	}

	public double getTotalBearBucks() {
		double out = 0;
		for (String that : roster.keySet()) {
			out = out + roster.get(that).getBearBucksBalance();
		}
		return out;
	}
}
