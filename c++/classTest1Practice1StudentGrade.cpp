#include<iostream>
using namespace std;

class Student {
	int id; string name; float cgpa; int *grade; int *credit; int noOfCourse;
	public:
		Student() {
			id=0;  name="TBA";  cgpa=0.0f;  grade=NULL; credit=NULL;  noOfCourse=0;
		}
		setInfo() {
			float a = 0; float totalCr = 0;
			cout<<"Enter Id: "; 	cin>>id;
			cout<<"Enter Name: "; 	cin>>name;
			cout<<"Enter NO OF COURSE: "; 	cin>>noOfCourse;
			grade = new int [noOfCourse];
			credit = new int [noOfCourse];
			for(int i=0; i<noOfCourse; i++) {
				cout<<"Enter "<<i+1<<" th Course Grade: ";		cin>>grade[i];
				cout<<"Enter "<<i+1<<" th Course Credit: ";		cin>>credit[i];
				a += grade[i]*credit[i];
				totalCr += credit[i];
			}
			cgpa = a/totalCr;
		}
		showInfo() {
			cout<<"Id: "<<id<<endl;
			cout<<"Name: "<<name<<endl;
			cout<<"NO OF COURSE: "<<noOfCourse<<endl;
			for(int i=0; i<noOfCourse; i++) {
				cout<<"Enter "<<i+1<<" th Course Grade: "<<grade[i]<<endl;
				cout<<"Enter "<<i+1<<" th Course Credit: "<<credit[i]<<endl;
			}
			cout<<"CGPA: "<<cgpa<<endl;
		}
		getId() { return id; }
};
	
	void populateStudents(Student arr[], int s){
		for(int i=0; i<s; i++) {
			arr[i].setInfo();
		}
	}
	void showStudents(Student arr[], int s){
		for(int i=0; i<s; i++) {
			arr[i].showInfo();
		}
	}
	void showStudents(Student arr[], int s, int x){
		bool isFound=false;
		for(int i=0; i<s; i++) {
			if( arr[i].getId() == x){
				arr[i].showInfo();
				isFound=true;
				break;
			}
		}
		if(!isFound) cout<<"ID NOT FOUND!!!"<<endl;
	}



int main(){
    int classSize, searchId;
    cout<<"Class size ? "; cin>>classSize;
	Student riyad, asif,  CSE213[classSize]; //array of objects
	populateStudents(CSE213,classSize);
	showStudents(CSE213,classSize);
	cout<<"Enter ID to view the student's info: ";
        cin>>searchId;

    showStudents(CSE213,classSize,searchId);
	//riyad.setInfo();	riyad.showInfo();
    //asif.setInfo();	asif.showInfo();
	return 0;
}
