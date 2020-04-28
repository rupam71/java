
#include<iostream>
using namespace std;



class Account{
	int accNo;
	string accName;
	float balance;
	public:

    //void Account(){ //constructor
    Account(int no, string name){ //constructor
        accNo=no; accName=name; balance=0.0;
    }

    Account(){ //constructor
        accNo=0; accName="TBA"; balance=0.0;
    }

    void setInfo(){
        cout<<"Enter account no: "; cin>>accNo;
        cout<<"Enter account name: "; cin>>accName;
        cout<<"Enter balance: "; cin>>balance;
    }
    void showInfo(){
        cout<<"AccNo="<<accNo
        <<", AccName="<<accName
        <<", Balance="<<balance<<endl;
    }

	void setBalance(float balance){
	    (*this).balance = balance;
	    //this->balance = balance;
	}

	float getBalance(){ return balance; }
	string getName(){ return accName; }

	void  showBalance(){
	   cout<<"balance="<<balance<<endl;
	}
};

int main(){
    Account a1,a2,a3,a4(4,"Rafiq");
    a1.setInfo(); a2.setInfo();
    a1.showInfo(); a2.showInfo();
    a3.showInfo(); a4.showInfo();
    float b;
    cout<<"Avg balance: "<<(a1.getBalance()+a2.getBalance())/2<<endl;
    cout<<"Enter new balance for "<<a1.getName()<<": ";
    cin>>b;
    a1.setBalance(b);
    //cout<<"New balance of a1="<<a1.getBalance();
    a1.showInfo();

	return 0;
}












