#include<iostream>
using namespace std;

int main() {
	int x = 10;
	float per = (float)x /100;
	float salary = 30000;
	salary = salary*(1+per);
	cout<<salary;
	return 0;
}
