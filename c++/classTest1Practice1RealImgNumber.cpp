#include<iostream>
using namespace std;

class ComplexNo{
	int real; int img;
	public:
		ComplexNo(){
			real = 0;
			img = 0;
		}
		ComplexNo(int r){
			real = r;
			cout<<"Enter Your Img Number: ";	cin>>img;
		}
		ComplexNo(int r, int i){
			real = r;
			img = i;
		}
		void setComplexNo() {
			cout<<"Enter Real Number "; cin>>real;
			cout<<"Enter Img Number "; cin>>img;
		}
		
		void showCoplexNo() {
			cout<<real<<(img>=0?"+":"")<<img<<"i"<<endl;
		}
		void add (ComplexNo c, ComplexNo d, ComplexNo e) {
			real = c.real + d.real + e.real;
			img = c.img + d.img + e.img;
		}
		ComplexNo add (ComplexNo c, ComplexNo d) {
			ComplexNo temp;
			temp.real = real + c.real + d.real;
			temp.img = img + c.img + d.img;
			return temp;
		}
		ComplexNo operator+(ComplexNo c) {
			ComplexNo temp;
			temp.real = real+ c.real;
			temp.img = img+ c.img;
			return temp;
		} 
		ComplexNo operator+(int x) {
			ComplexNo temp;
			temp.real = real+ x;
			temp.img = img;
			return temp;
		}
		friend ComplexNo operator+(int, ComplexNo);
};
		ComplexNo operator+(int x, ComplexNo c) {
			ComplexNo temp;
			temp.real =  x + c.real;
			temp.img = c.img;
			return temp;
		}

int main(){
  ComplexNo c1, c2(10), c3(23,33), c4, c5, c6, c7, c8, c9;
  cout<<"set c1: "<<endl; 
  cout<<"c1 before setting = "; c1.showCoplexNo();  
  c1.setComplexNo();
  c4.add(c1,c2,c3); // here client is empty. So return type void.
  cout<<"c1 = "; c1.showCoplexNo();  
  cout<<"c2 = "; c2.showCoplexNo();
  cout<<"c3 = "; c3.showCoplexNo();  
  cout<<"c4 = "; c4.showCoplexNo();
  
  c5 = c1.add(c2,c3); cout<<"c5 = "; c5.showCoplexNo(); // here client is NOT empty. So return type ComplexNo.
  
  c6 = (c2+c3); cout<<"c6 = "; c6.showCoplexNo();
  
  c7 = (c6+5); cout<<"c7 = "; (c6+5).showCoplexNo();
  
  c8 = (5+c7); cout<<"c8 = "; c8.showCoplexNo();
  
  c9 = (c1+c2+c3+c4+c5+c6+c7+c8); cout<<"c9 = "; c9.showCoplexNo();
  
  return 0;
}
