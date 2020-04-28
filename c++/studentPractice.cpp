#include<iostream>
using namespace std;

class Student {
	int id;
	string name;
	float cgpa;
	public:
		Student() {
			id = 01;
			name= "TBA";
			cgpa = 0.0f;
		}
		setInfo() {
			cout<<"Enter Id: "; cin>>id;
			cin.ignore();
			cout<<"Enter Name: "; cin>>name;
			cout<<"Enter CGPA: "; cin>>cgpa;
		}
		showInfo() {
			cout<<"Id: "<<id<<" Name: "<<name<<" CGPA: "<<cgpa<<endl;
		}
		getId() {
			return id;
		}
		
};

	void populateStudents (Student arr[], int size) {
		for(int i=0; i<size; i++) {
			arr[i].setInfo();
		}
	}
	void showStudents (Student arr[], int size) {
		for(int i=0; i<size; i++) {
			arr[i].showInfo();
		}
	}
	void showStudents (Student arr[], int size, int key) {
		bool isFound= false;
		for(int i=0; i<size; i++) {
			if(arr[i].getId()==key) {
				arr[i].showInfo();
				isFound=true;
				break;
			}
		}
		if(!isFound) cout<<"OOPS invalid ID!"<<endl;
	}

int main() {
	int n, searchId;
    cout<<"How many students in the class ? "; cin>>n;
    Student CSE213sec2[n];
    populateStudents(CSE213sec2, n);
    showStudents(CSE213sec2, n);
    cout<<endl;
    cout<<"Enter id to view a specific student: ";
    cin>>searchId;
    showStudents(CSE213sec2, n, searchId);
	
	return 0;
}
