#include<iostream>
using namespace std;

class Grades{
	int noOfCourse; string *gradePtr;
	public:
		Grades() { noOfCourse = 0; gradePtr=NULL; }
		setGrades() {
			cout<<"NO Of Course: "; cin>>noOfCourse;
			gradePtr = new string [noOfCourse];
			cin.ignore();
			for(int i=01; i<noOfCourse; i++) {
				cout<<"Enter "<<i+1<<" th course grade: "; 
				cin>>gradePtr[i];
			}
		}
		showGrades() {
			cout<<"NO Of Course: "<<noOfCourse<<endl;
			for(int i=01; i<noOfCourse; i++) {
				cout<<i+1<<" th course grade: "<<gradePtr[i]<<endl;
			}
		}
};

class Semesters{
	int noOfSemesters; string *name; string *year; Grades *gradeInfo;
	public:
		Semesters() { noOfSemesters = 0; name=NULL; year=NULL; gradeInfo=NULL;}
		setSemesters() {
			cout<<"NO Of Semesters: "; cin>>noOfSemesters;
			name = new string [noOfSemesters];
			year = new string [noOfSemesters];
			gradeInfo = new Grades [noOfSemesters];
			cin.ignore();
			for(int i=01; i<noOfSemesters; i++) {
				cout<<"Enter "<<i+1<<" th semester name: "; 
				cin>>name[i];
				cout<<"Enter "<<i+1<<" th semester Year: "; 
				cin>>year[i];
				cout<<"Enter "<<i+1<<" th semester Grade Info: "; 
				gradeInfo[i].setGrades();
			}
		}
		showSemesters() {
			cout<<"NO Of Semesters: "<<noOfSemesters<<endl;
			for(int i=01; i<noOfSemesters; i++) {
				cout<<i+1<<" th Semesters name: "<<name[i]<<endl;
				cout<<i+1<<" th Semesters Year: "<<year[i]<<endl;
				cout<<i+1<<" th Semesters Grade Info: "<<endl;
				gradeInfo[i].showGrades();
			}
		}
};

class Student{
	int id; string name; Semesters info;
	public:
		Student() { id =0; name="TBA"; }
		setStudent() {
			cout<<"Enter Id: "; cin>>id;
			cout<<"Enter Name: "; cin>>name;
			cout<<"Enter Semesters info: "; 
			info.setSemesters();
		}
		showStudent() {
			cout<<"ID: "<<id<<endl;
			cout<<"NAME: "<<name<<endl;
			cout<<"Semesters info: "<<endl;
			info.showSemesters();
		}
};

int main() {
	Student arif;
	arif.setStudent();
	arif.showStudent();
	
	return 0;
}
