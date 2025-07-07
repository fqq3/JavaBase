package Person;

abstract class Person {
	
	abstract public int pay();
}

class Teacher extends Person{
	int basic;
	int num;
	public Teacher() {
		this.basic=0;
		this.num=0;
	}
	public Teacher(int b,int n) {
		this.basic=b;
		this.num=n;
	}
	public int pay() {
		return this.basic+this.num*30;
	}
}
class CollegeStudent extends Person{
	int scholarship;
	public CollegeStudent() {
		this.scholarship=0;
		
	}
	public CollegeStudent(int s) {
		this.scholarship=s;
		
	}
	public int pay() {
		return this.scholarship;
	}
}