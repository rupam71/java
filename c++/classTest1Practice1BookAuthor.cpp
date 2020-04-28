#include<iostream>
using namespace std;

class Book{
  int isbnNo; string title; float price; 
  string *autherPtr; int authorNo;
  public:
  	Book() {
  		isbnNo=0;  title="TBA";	  price=0.0f; 	autherPtr=NULL; 	 authorNo=0;
	  }
	  getAuthorNo() { return authorNo; }
	  getPrice() { return price; }
	  
	  bool operator<(float f){
	  	if ( price < f) return true;
	  	else return false;
	  }
	 
	  void operator += (int x){
	  	float percent = x/100;
	  	price = price*(100+percent);
	  }
	  // b1+b2
	  float operator+(Book b){
	  	float temp;
	  	temp = price + b.price;
	  	return temp;
	  }
	  
	  friend istream& operator>>(istream&, Book&);
	  friend ostream& operator<<(ostream&, Book&);
	  friend float operator+(float, Book);
};	
	int populateBooks(Book arr[], int n){
		int author = 0;
		for(int i=0; i<n; i++){
			cin>>arr[i];
			author += arr[i].getAuthorNo();
		}
		return author;
	}
	istream& operator>>(istream& input, Book& b){
		cout<<"Enter isbnNo: "; input>>b.isbnNo;
		input.ignore(); cout<<"Enter Title: "; getline(input, b.title);
		cout<<"Enter Price: "; input>>b.price;
		cout<<"Enter Author No: "; input>>b.authorNo;
		b.autherPtr = new string [b.authorNo];
		input.ignore();
		for(int i=0; i<b.authorNo; i++){
			cout<<"Enter "<< i+1<<" th Author Name: "; 	
			getline(input, b.autherPtr[i]);
		}
		return input;
	}
	ostream& operator<<(ostream& output, Book& b){
		cout<<"IsbnNo: "; output<<b.isbnNo<<endl;
		cout<<"Title: "; output<<b.title<<endl;
		cout<<"Price: "; output<<b.price<<endl;
		cout<<"Total Author No: "; output<<b.authorNo<<endl;
		for(int i=0; i<b.authorNo; i++){
			cout<< i+1<<" th Author Name: "; 	
			output<<b.autherPtr[i]<<endl;
		}
		return output;
	}
	int getBookIndexWithLowestPrice(Book arr[], int n){
		float lowPrice = arr[0].getPrice(); int index = 0;
		for(int i=0; i<n; i++){
			if( lowPrice > arr[i].getPrice() ){
				lowPrice = arr[i].getPrice();
				index = i;
			}
		}
		return index;
	}
	float operator+(float f, Book b) {
		float temp;
		temp = f  + b.price;
		return temp;
	}

int main(){
  int n, i; cout<<"How many books? " ; cin>>n;
  Book bookArr[n]; //an array of Book objects

  int noOfAuthors = populateBooks(bookArr, n);
  //write this global function
  //This function will replace the default values (set by constructor) of
  //n Books by using cin>>BookObject format in a loop. Finally it returns
  //total number of authors of all books of the array.

  cout<<"No of authors of all books is: "<<noOfAuthors<<endl;
  cout << "Detail of the books are: " << endl;
  for(i=0; i<n ;i++) cout << bookArr[i] << endl;
  int index = getBookIndexWithLowestPrice(bookArr, n);
  int x; cout<<"% to increase lowest price: "; cin>>x;
  
  if(bookArr[index]<500.0) bookArr[index] += x;
  //bookArr[index] is a book and if it’s 
  //price is <500 taka, then += will increase 
  //the book’s price by x%. Write necessary 
  //operator functions ( < , += ) 

  Book b1, b2, b3, b4; cin>>b1>>b2>>b3>>b4;

  //overload ‘+’ operator twice. 
  //‘+’ means adding price, not books
  cout<<( (b1+b2+b3+b4 > 5000.0)
    ? "Customer is given 10% discount."
    : " customer is given 5% discount."
  ) << endl;
  return 0;
}
