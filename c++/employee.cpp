#include<iostream>
using namespace std;

	class Employee{  
	//field: 
	int id; string name; float salary; string dept; string* degrees; int noOfDegrees;   
	public: 
	//write default constructor          [1 marks] 
	Employee() {
		id = 0;  name = "TBA"; salary = 0.0f; dept = "noun"; degrees = NULL; noOfDegrees = 0;
	}
	getName() { return name; }
	setDept(string s) { dept = s; }
	getSalary() { return salary; }
	getNoDeg() { return noOfDegrees; }
	
	bool operator < (float f) {
		if( salary < f) return true;
		else return false;
	}
	
	bool operator >= (int f) {
		if( noOfDegrees >= f) return true;
		else return false;
	}
	
	void operator += (int x) {
		// empArr[pos] += x;
		int per = (x/100) + 100;
		salary = salary * per ;
	}
	
	float operator + (Employee e) {
		float temp;
		temp = salary + e.salary ;
		return temp ;
	}
	//add other necessary methods... //declare necessary friend functions...   };      
	//need to overload >> operator allowing function chaining     [2 marks]   
	//Should ask info for all the fields  from user  
 	//need to overload << operator allowing function chaining        [2 marks]   
	 //Should display all the fields of the object 		"
	 friend istream& operator >> (istream&, Employee&);
	 friend ostream& operator << (ostream&, Employee&);
	 friend float operator + (float, Employee);
};
	
	istream& operator >> (istream& input, Employee& e) {
		cout<<"Enter Id: "; input>>e.id;
		input.ignore();
		cout<<"Enter Name: "; getline(input, e.name);
		cout<<"Enter Salary: "; input>>e.salary;
		cout<<"Enter No Of Degrees: "; input>>e.noOfDegrees;
		e.degrees = new string [e.noOfDegrees];
		input.ignore();
		for(int i=0; i<e.noOfDegrees; i++) {
			cout<<"Enter "<<i+1<<" th Degree: ";
			getline(input, e.degrees[i]);
		}
		return input;
	}
	
	ostream& operator << (ostream& output, Employee& e) {
		cout<<"Id: "; output<<e.id<<endl;
		cout<<"Name: "; output<<e.name<<endl;
		cout<<"Salary: "; output<<e.salary<<endl;
		cout<<"No Of Degrees: "; output<<e.noOfDegrees<<endl;
		for(int i=0; i<e.noOfDegrees; i++) {
			cout<<i+1<<" th Degree: "; 
			output<<e.degrees[i]<<endl;
		}
		return output;
	}
	
	float operator + (float f, Employee e) {
		float temp;
		temp = f + e.salary;
		return temp;
	}
	
	float populateEmployees(Employee arr[], int n, string dn) {
		float total =0;
		for(int i=0; i<n; i++) {
			cin>>arr[i];
			arr[i].setDept(dn);
			total += arr[i].getSalary() ;
		}
		return total/n ;
	}
	
	int getEmployeeIndexWithLowestSalary(Employee arr[],int n){
		int low = arr[0].getSalary(); int index = 0;
		for(int i=0; i<n; i++) {
			if( low > arr[i].getSalary() ){
				low = arr[i].getSalary();
				index = i ;
			}
		}
		return index;
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
		//if empArr[pos] is an employee having minimum 4 degrees and his/her  
		//salary  is <50000 taka, then increase his/her salary by x percent 
		//write operator functions (< , +=) & getNoDeg() method  [2+2+1 = 5 marks] 
 
		Employee e1, e2, e3, e4; cin>>e1>>e2>>e3>>e4; 
 	
		//overload ‘+’ operator twice. ‘+’ means adding salary, not Employees 
		
		cout<<( (e1+e2+(avgSalry*n)+e3+e4 > 50000000.0)   // [2 X 2 = 4 marks]    
		? "The company is considered as a large enterprise."    
		: " The company is NOT considered as a large enterprise."  ) 
		<< endl; 
		
		return 0; 
}
