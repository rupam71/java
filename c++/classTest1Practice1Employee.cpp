#include<iostream>
using namespace std;

	class Employee{   
		int id; string name; float salary; string dept; string* degrees; int noOfDegrees;   
		public:
		Employee() {	id=0;  name="TBA";  salary=0.0f;  dept="noun";  degrees=NULL;  noOfDegrees=0;	}
		setDept(string s) { dept = s; }
		getSalary() { return salary; }
		getNoDeg() { return noOfDegrees; }
		
		bool operator<(float f) {
			if ( salary < f ) return true;
			else return false;
		}
//		bool operator >= (int x) {
//			if (noOfDegrees >= x) return true;
//			else return false;
//		}
		void operator += (int x) {
			float per = (float)x/100;
			salary = salary*(1+per);
		}
		float operator+(Employee e) {
			float f;
			f = salary + e.salary;
			return f;
		}
		
		friend istream& operator>>(istream&, Employee&);
		friend ostream& operator<<(ostream&, Employee&);
		friend float operator+(float, Employee);
	};
	
	int populateEmployees(Employee arr[], int n, string dn){
		float total = 0;
		for(int i=0; i<n; i++) {
			cin>>arr[i];
			arr[i].setDept(dn);
			total += arr[i].getSalary();
		}
		return total/n;
	}
	istream& operator>>(istream& input, Employee& e){
		cout<<"Enter Id: "; input>>e.id;
		input.ignore(); cout<<"Enter Name: "; getline(input, e.name);
		cout<<"Enter Salary: "; input>>e.salary;
		cout<<"Enter No Of Degree: "; input>>e.noOfDegrees;
		e.degrees = new string [e.noOfDegrees];
		input.ignore();
		for(int i=0; i<e.noOfDegrees; i++) {
			cout<<"Enter "<<i+1<<" th Degree: "; getline(input, e.degrees[i]);
		}
		return input;
	}
	ostream& operator<<(ostream& output, Employee& e){
		cout<<"Id: "; output<<e.id<<endl;
		cout<<"Name: "; output<<e.name<<endl;
		cout<<"Salary: "; output<<e.salary<<endl;
		cout<<"Total No Of Degree: "; output<<e.noOfDegrees<<endl;
		for(int i=0; i<e.noOfDegrees; i++) {
			cout<<i+1<<" th Degree: "; output<<e.degrees[i]<<endl;
		}
		return output;
	}
	int getEmployeeIndexWithLowestSalary(Employee arr[], int n){
		float lowSalary = arr[0].getSalary() ; int index = 0;
		for(int i=0; i<n; i++) {
			if (lowSalary>arr[i].getSalary()){
				lowSalary=arr[i].getSalary();
				index = i;
			}
		}
		return index;
	}
	float operator+(float f, Employee e) {
			float temp;
			temp = f + e.salary;
			return temp;
		}
		
	int main(){ 
 		int n; cout<<"How many employees? "; 
		 cin>>n; 
		 Employee empArr[n]; 
		 //represent an array of Employee objects 
		 string dn; 
		 cin.ignore(); 
		 cout<<"Enter a dept name: "; getline(cin,dn); 
 
    	float avgSalry = populateEmployees(empArr, n, dn);     // [4 marks]     
		//This function will replace default values (set by constructor) of n 
		//Employees by using cin>>EmployeeObject format in a loop. Finally it 
		//returns average salary of the employees of department dn (3rd parameter).    
		cout<<"Average salary of "<<dn<<"department is: "<<avgSalry<<endl; 
 		cout << "Detail of the employees are: " << endl;    
		for(int i=0; i<n ;i++) cout << empArr[i] << endl;     
 		int pos = getEmployeeIndexWithLowestSalary(empArr, n);       // [2 marks] 
 		int x; 	
		cout<<"Increment rate (%)? "; cin>>x; 
		if(empArr[pos]<50000.0 && empArr[pos].getNoDeg()>=4) empArr[pos] += x;
		cout<<"salary: "<< empArr[pos].getSalary(); 
		//if empArr[pos] is an employee having minimum 4 degrees and his/her  
		//salary  is <50000 taka, then increase his/her salary by x percent 
		//write operator functions (< , +=) & getNoDeg() method  [2+2+1 = 5 marks] 
 		/*
		Employee e1, e2, e3, e4; cin>>e1>>e2>>e3>>e4; 
 		//overload ‘+’ operator twice. ‘+’ means adding salary, not Employees 
		cout<<( (e1+e2+(avgSalry*n)+e3+e4 > 50000000.0)   // [2 X 2 = 4 marks]    
		? "The company is considered as a large enterprise."    
		: " The company is NOT considered as a large enterprise."  ) 
		<< endl; 
		*/
		return 0; 
}
