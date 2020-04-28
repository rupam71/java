#include<iostream>
using namespace std;

class Student{
	int id;
	string name;
	public:
	float cgpa;
	void setData(){
		cout<<"Enter Id: "; cin>>id;
		cout<<"Enter Name: "; cin>>name;
		cout<<"Enter Cgpa: "; cin>>cgpa;
	}
	void showData(){
		cout<<"Id="<<id<<", Name="<<name
		 <<", Cgpa="<<cgpa<<endl;
	}
};



int main(){
	int n, i;
 	float avgCgpa, maxCgpa;
 	float cg = 0.0;   
	float max = 0.0;
	
//	int arr[n];
	cout<<"How many students? "; cin>>n;
	Student arr[n];
	
	for(i=0;i<n;i++) arr[i].setData();
	for(i=0;i<n;i++) arr[i].showData();
	
	for(i=0;i<n;i++) cg += arr[i].cgpa;

	avgCgpa = cg / n;
	cout<<"AVG CGPA: "<<avgCgpa<<endl;
	
	for(i=0;i<n;i++) {
		if (max < arr[i].cgpa) 
		max = arr[i].cgpa;
	}
	
	maxCgpa = max;
	cout<<"Max CGPA: "<<maxCgpa<<endl;

	
	return 0;
}
