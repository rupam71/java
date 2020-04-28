#include<iostream>
using namespace std;

class Student{
    private:
    int id;    string name;    float cgpa;
    public:
    Student(){
        id=0; name="TBA"; cgpa=0.0f;
    }
    void setInfo(){
        cout<<"Enter id: "; cin>>id;
        cin.ignore();
        cout<<"Enter name: "; getline(cin,name);
        cout<<"Enter cgpa: "; cin>>cgpa;
    }
    void showInfo(){
        cout<<"Id="<<id<<", Name="<<name<<", Cgpa="<<cgpa<<endl;
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
    int n, searchId;
    cout<<"How many students in the class ? "; cin>>n;
    Student CSE213sec2[n];
    populateStudents(CSE213sec2, n);
    showStudents(CSE213sec2, n);
    cout<<endl;
    cout<<"Enter id to view a specific student: ";
    cin>>searchId;
    showStudents(CSE213sec2, n, searchId);
    Student asif;
    asif.setInfo();
    asif.showInfo();
    return 0;
}

