#include<iostream>
using namespace std;

class Student{
    private:
	int id; 	string name; 	float cgpa;
	string* grades; int* credits; int noOfCourses;
	public:
    Student(){
        id=0; name="TBA"; cgpa=0.0f;
        grades=NULL; credits=NULL; noOfCourses=0;
    }
	void setInfo(){
	    int i;
	    cout<<"Enter id: "; cin>>id;
	    cout<<"Enter Name: "; cin>>name;
	    //cout<<"Enter cgpa: "; cin>>cgpa;
	    cout<<"No of courses completed ? "; cin>>noOfCourses;
	    grades = new string[noOfCourses];
	    credits = new int[noOfCourses];
	    for(i=0;i<noOfCourses;i++){
            cout<<"Enter Grade of "<<i+1<<"th course: "; cin>>grades[i];
            cout<<"Enter no of credits of "<<i+1<<"th course: "; cin>>credits[i];
	    }
	    cgpa = 
	    //cgpa=3.5f;
	}

	void showInfo(){
	    int i;
	    cout<<"ID="<<id<<", Name="<<name<<", Cgpa="<<cgpa<<endl;
	    for(i=0;i<noOfCourses;i++){
	        cout<<"Grade of "<<i+1<<"th course = "<<grades[i]
                <<", having "<<credits[i]<<" credit(s)."<<endl;
	    }
	}
	int getId(){return id;}
};

void populateStudents(Student arr[], int size){
        int i;
        for(i=0;i<size;i++){
            arr[i].setInfo();
        }
}

void showStudents(Student arr[], int size){
        int i;
        for(i=0;i<size;i++){
            arr[i].showInfo();
        }
}

void showStudents(Student arr[], int size, int sId){
    int i; bool isFound=false;
    for(i=0;i<size;i++){
        if(arr[i].getId() == sId){
            arr[i].showInfo();
            isFound=true;
            break;
        }
    }
    if(!isFound)
        cout<<"Oops! Student not found..."<<endl;
    return;
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





