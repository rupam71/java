#include <iostream>
using namespace std;

 
class HardDisk {     
// fields: rpm (int), capacityInGB(int)
 int rpm;
 int capacityInGB;
 
 	public: // add necessary methods, so that the given main() works  
	 
	setHd ()
	 {
	 	cout<<"Enter RPM: "; cin>>rpm;
	 	cout<<"Enter capacity in GB: "; cin>>capacityInGB;	 	
	 }
	showHd()
	 {
	 	cout<<"RPM: "<<rpm<<endl;
	 	cout<<"Capacity in GB: "<<capacityInGB<<endl;	
	 }
		
			 
	 }; 
 
class Computer {    
// fields: brand (string), speedInGhz(float), noOfHDD (int), hddArr (HardDisk*), price (float)  
	string brand; float speedInGhz;  int noOfHDD; float price; HardDisk *hddArr;
 public: // add necessary methods, so that the given main() works
 		
 		setComputer ()
 		{
 			cout<<"Enter brand: "; cin>>brand;
 			cout<<"Enter speed in ghz: "; cin>>speedInGhz;		
 			cout<<"Enter Price: "; cin>>price;
 			cout<<"Enter no of hdd: "; cin>>noOfHDD;
 			hddArr = new HardDisk [noOfHDD];
 			for (int i=0; i< noOfHDD; i++)
 			{
 			cout<<"Enter HardDisk "<<i+1<<" : ";
			 hddArr[i].setHd(); 
 			}
		 	
		}
		
		showComputer ()
 		{
 			cout<<"Brand: "<<brand <<endl;
 			cout<<"Speed in ghz: "<<speedInGhz<<endl;		
 			cout<<"Price: "<<price<<endl;
 			cout<<"No of hdd: "<<noOfHDD<<endl;
 			for (int i=0; i< noOfHDD; i++)
 			{
 			cout<<" HardDisk "<<i+1<<" : ";
			 hddArr[i].showHd(); 
 			}
		 	
		}
 
 
  }; 
 	
class ComputerLab {   //    // fields: roomNo (string), noOfComputer (int), compArr (Computer*)   

	string roomNo; int noOfComputer; Computer *compArr; 
 public: // add necessary methods, so that the given main() works 
 	setComputerLab ()
 	{
 		
		 cout<<"Enter room no: "; cin>>roomNo;
		 cout<<"Enter no of computer: "; cin>>noOfComputer;
		 compArr = new Computer[noOfComputer];
		 for (int i =0; i < noOfComputer; i++)
		 {
		 	cout<<"Enter computer"<<i+1<<" ";
		 	compArr[i].setComputer();
		 }
	 }
	 
	 showComputerLab ()
 	{
 		
		 cout<<"Room no: "<<roomNo<<endl;
		 cout<<"No of computer: "<<noOfComputer<<endl;
		 
		 for (int i =0; i < noOfComputer; i++)
		 {
		 	cout<<"Computer"<<i+1<<" ";
		 	compArr[i].showComputer();
		 }
	 }
	 getNoOfComputer() { return noOfComputer;}
	 
	 bool operator>=(int thirty)
		{
			if (noOfComputer>=thirty) return true;
			else return false;
			
		 } 
 }; 
 
 
 
int main(){   
ComputerLab* labs; 
int n;   
cout<<"How many computer labs? "; 
cin>>n;    
labs = new ComputerLab[n];   
for(int i=0;i<n;i++) 
{ labs[i].setComputerLab();
labs[i].showComputerLab();

if (labs[i] >= 30) 
cout<<"It is a big computer Lab."<<endl; 
else cout<<"It is a small computer Lab."<<endl;    
     } 
 
// ComputerLab t;
// t.setComputerLab();
// t.showComputerLab();
 
 
 
 
  return 0;      } 
