#include<iostream>
using namespace std;

class Student{
	int id; string name; float cgpa;
	int *grade; int *credit; int noOfCourse;
	public:
		Student() {
			id=0; name="TBA"; cgpa=0.0f;
			grade=NULL; credit=NULL; noOfCourse=0;
		}
		void setInfo(){
			float c = 0; float a=0;
        cout<<"Enter id: "; cin>>id;
        cout<<"Enter name: "; cin>>name;
        cout<<"Enter No Of Course: "; cin>>noOfCourse;
        grade = new int [noOfCourse];
        credit = new int [noOfCourse];
        for(int i=0; i<noOfCourse; i++) {
        	cout<<"Enter Grade of "<<i+1<<"th course: "; cin>>grade[i];
        	cout<<"Enter no of credits of "<<i+1<<"th course: "; cin>>credit[i];
        		 a += (int)grade[i]*credit[i];
        		 c += credit[i];
		}
		cgpa = (a/c);
    }
    void showInfo(){
        cout<<"ID: "<<id; cout<<endl;
        cout<<"Name: "<<name; cout<<endl;
        cout<<"No Of Course: "<<noOfCourse; cout<<endl;
        for(int i=0; i<noOfCourse; i++) {
        	cout<<"Grade of "<<i+1<<"th course: "<<grade[i]; cout<<endl;
        	cout<<" No of credits of "<<i+1<<"th course: "<<credit[i];
        	cout<<endl;
		}
		cout<<"CGPA: "<<cgpa;
    }
    getId() {return id;}
};
	void populateStudents(Student arr[], int size) {
		for(int i=0; i<size; i++){
			arr[i].setInfo();
		}
	}
//	void showStudents(Student arr[], int size) {
//		for(int i=0; i<size; i++){
//			arr[i].showInfo();
//		}
//	}
	void showStudents(Student arr[], int size){
        int i;
        for(i=0;i<size;i++){
            arr[i].showInfo();
        }
}
	void showStudents(Student arr[], int size, int checkId){
    int i; bool isFound=false;
    for(i=0;i<size;i++){
            if(arr[i].getId() == checkId){
                arr[i].showInfo(); isFound=true;
                break;
            }
    }
    if(!isFound) cout<<"Oops! Invalid student ID..."<<endl;
}

int main(){
    int classSize, searchId;
    cout<<"Class size ? "; cin>>classSize;
	Student riyad, asif,  CSE213[classSize]; //array of objects
	populateStudents(CSE213,classSize);
	showStudents(CSE213,classSize);
	cout<<endl;
	cout<<"Enter ID to view the student's info: ";
        cin>>searchId;

    showStudents(CSE213,classSize,searchId);
	//riyad.setInfo();	riyad.showInfo();
    //asif.setInfo();	asif.showInfo();
	return 0;
}

