package assignment7;

import java.util.Arrays;

public class Student {
	private String first;
	private String last;
	private int id;
	//	private int attempt;
	//	private int pass;
	//	private double quality;
	private double bucks;
	//	private double gpa;
	private double[] grades = new double[0];
	private int[] credits = new int[0];
	/**
	 * define parameters of a student
	 * @param first first name of student
	 * @param last last name of student
	 * @param id id of student
	 */
	public Student(String first, String last, int id) {
		this.first=first;
		this.last=last;
		this.id=id;
	}
	/**
	 * returns of the full name of the student
	 * @return full name of student
	 */
	public String getFullName() {
		return first + " " + last;
	}
	/**
	 * returns the id of the student
	 * @return id of student
	 */
	public int getId() {
		return id;
	}
	/**
	 * returns the total no. of credits that the student attempted
	 * @return total attempted credit of student
	 */
	public int getTotalAttemptedCredits() {
		int out = 0;
		for (int n : credits) {
			out += n;
		}
		return out;
	}
	/**
	 * returns the total no. of credits passed (quality>1.7) by the student
	 * @return credits passed by students
	 */
	public int getTotalPassingCredits() {
		int out = 0;
		for (int i =0; i<credits.length; i++) {
			if (grades[i]>= 1.7) {
				out+=credits[i];
			}
		}
		return out;
	}
	/**
	 * submits the grade of a new course
	 * @param grade grade of course
	 * @param credit credit of course
	 */
	public void submitGrade(double grade, int credit) {
		grades= Arrays.copyOf(grades, grades.length+1);
		grades[grades.length-1] = grade;
		credits = Arrays.copyOf(credits, credits.length+1);
		credits[credits.length-1] = credit;
	}
	/**
	 * returns the average GPA of the student
	 * @return average GPA of student
	 */
	public double calculateGradePointAverage() {
		double gpa = 0;
		for (int i=0; i<grades.length;i++) {
			gpa += grades[i]*credits[i];
		}
		return gpa/getTotalAttemptedCredits();
	}
	/**
	 * returns the class standing of the student
	 * @return String description of class standing
	 */
	public String getClassStanding() {
		int n = getTotalPassingCredits();
		if (n<30) {
			return "First Year";
		} else if (n<60) {
			return "Sophomore";
		} else if (n<90) {
			return "Junior";
		} else {
			return "Senior";
		}
	}
	/**
	 * return eligibility of student for PhiBetaKappa
	 * @return boolean eligibility 
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if ((getTotalAttemptedCredits()>=98&&calculateGradePointAverage()>=3.6)||(getTotalAttemptedCredits()>=75&&calculateGradePointAverage()>=3.8)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * adds amount of money to bear bucks balance
	 * @param amount amount of money added
	 */
	public void depositBearBucks(double amount) {
		bucks += amount;
	}
	/**
	 * substracts amount of money from bear bucks balance
	 * @param amount amount of money subtracted
	 */
	public void deductBearBucks(double amount) {
		bucks -= amount;
	}
	/**
	 * returns the balance of bear bucks
	 * @return balance of bear bucks
	 */
	public double getBearBucksBalance() {
		return bucks;
	}
	/**
	 * returns all bear bucks balance, minus $10 fee
	 * @return bear bucks balance - 10, min 0
	 */
	public double cashOutBearBucks() {
		double out = 0;
		if (bucks >=10) {
			out = bucks-10;
		}
		bucks = 0;
		return out;		 
	}
	/**
	 * creates new student that shares last name with one or both parents, and cashes out all bear bucks from both parents
	 * @param firstName first name of new student
	 * @param otherParent last name of the other parent of the student
	 * @param isHyphenated whether last name of new student is hyphenated combination of both parents
	 * @param id id of new student
	 * @return
	 */
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		Student child;
		if (isHyphenated) {
			child = new Student(firstName, this.last+"-"+otherParent.last, id);
		} else {
			child = new Student(firstName, this.last, id);
		}
		child.depositBearBucks(this.cashOutBearBucks()+otherParent.cashOutBearBucks());
		return child;
	}
	/**
	 * returns the name and id of the student
	 * @return String name and id of student
	 */
	public String toString() {
		return first + " " + last + id;
	}
}

