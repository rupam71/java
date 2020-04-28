#include<iostream>
using namespace std;

class Author {
	string name, email; string gender;    
// may add private methods, too, if you feel appropriate   
	public: 
	void setAuthor(){
		cout<<"Enter Name: "; cin>>name;
		cout<<"Enter email: "; cin>>email;
		cout<<"Enter gender: "; cin>>gender;
	}
	void showAuthor(){
		cout<<"Name: "<<name<<" Email: "<<email<<" Gender: "<<gender<<endl;
	}
//add necessary methods AND/OR declare friends, so that the given main() works  
}; 
 
class Book {   
	string bookName, isbn; Author authors; float price ;   
	public: 
	void setBook(){
		cout<<"Enter Book Name: "; cin>>bookName;
		cout<<"Enter isbn: "; cin>>isbn;
		cout<<"Enter price: "; cin>>price;
		cout<<"Enter Author: "; authors.setAuthor();
	}
	void showBook(){
		cout<<"Book Name: "<<bookName<<endl;
		cout<<"isbn: "<<isbn<<endl;
		cout<<"Book price: "<<price<<endl;
		cout<<"Book Author: "; authors.showAuthor();
	}
// add necessary methods AND/OR declare friends, so that the given main() works 
}; 
 
class Course {   
	string courseId, courseTitle; int noOfCredits; Book textBook;     
// may add private methods, too, if you feel appropriate   
	public: 
//	void setCourse(){
//		
//	}
//	void showCourse(){
//		cout<<"Course Id: "<<courseId<<endl;
//		cout<<"Course Title: "<<courseTitle<<endl;
//		cout<<"No Of Credits: "<<noOfCredits<<endl;
//		cout<<"TtextBook: "; textBook.showBook();
//	}
	friend istream& operator>>(istream&, Course&);
	friend ostream& operator<<(ostream&, Course&); 
}; 
 	
// add global methods, which you may consider as friends of some classes above 
 
	void allocateAndPopulateCourses (Course *courseArr, int n) {
		courseArr = new Course [n];
		for( int i=0; i<n; i++){
			cin>>courseArr[i];
			cout<<courseArr[i];
		}
	}
	istream& operator>>(istream& input, Course& b){
 		cout<<"Enter Course Id: "; input>>b.courseId;
		cout<<"Enter Course Title: "; input>>b.courseTitle;
		cout<<"Enter No Of Credits: "; input>>b.noOfCredits;
		cout<<"Enter TextBook: "; b.textBook.setBook();
	 }
	ostream& operator<<(ostream& output, Course& b){
 		cout<<"Course Id: "; output<<b.courseId<<endl;
		cout<<"Course Title: "; output<<b.courseTitle<<endl;
		cout<<"No Of Credits: "; output<<b.noOfCredits<<endl;
		cout<<"TtextBook: "; b.textBook.showBook();
	 } 
 
int main(){   
	Course *courseArr; 
	int n;   
	cout<<"How many courses? "; 
	cin>>n;    
	allocateAndPopulateCourses(courseArr, n);  
	 
//	for(int i=0;i<n;i++){
//		cout<<courseArr[i];
//	}
	 
 
//    int totalCredits = 0;   
////	for(i=0;i<n;i++) totalCredits += courseArr[i]; 
// 
//    cout<<"Total no of credits of these courses is: "<<totalCredits<<endl;   
	return 0; 
}   
