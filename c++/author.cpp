#include<iostream>
using namespace std;

class Book{
  int isbnNo; string title; float price; 
  string *autherPtr; int authorNo;
public:
  //write default constructor
  Book() {
  	isbnNo =0; title="TBA"; price=0.0f; 
    autherPtr=NULL; authorNo=0;
  }
  getAuthorNo() { return authorNo; }
  getPrice() { return price; }
  //add other necessary member functions...
  //declare necessary friend functions...
  friend istream& operator>>(istream&, Book&);
  friend ostream& operator<<(ostream&, Book&);
  bool operator<(float f){
  	if ( price < f) return true;
  	else return false;
  }
  void operator+=(int x){
  	//  x/100; ( price*(x/100) )
  	int per = (x/100);
  	price = price*(100+per);
  }	
  float operator+(Book b){
  	float temp;
  	temp = price + b.price;
  	
  	return temp;
  }
  friend float operator+(float, Book);

//  void allocateMemoryForAuthors( int no){
//     authorNo=no;
//     authorPtr = new string[no];
//  }
};

	int populateBooks(Book arr[], int n) {
		int author =0;
		for(int i=0; i<n; i++) {
			cin>>arr[i];
			author += arr[i].getAuthorNo();
		}
		return author;
	}
	istream& operator>>(istream& input, Book& b){
		cout<<"Enter isbnNo: "; input>>b.isbnNo;
		input.ignore();
		cout<<"Enter Title: ";  getline(input,b.title);
		cout<<"Enter Price: "; input>>b.price;
		cout<<"Enter Author No: "; input>>b.authorNo;
	//	b.authorPtr = new string [b.authorNo];
		b.autherPtr = new string [b.authorNo];
		input.ignore();
		for(int i=0; i<b.authorNo; i++) {
			cout<<"Enter Author "<<i+1<<"th: ";
			getline(input,b.autherPtr[i]);
		}
		return input;
	}
	ostream& operator<<(ostream& output, Book& b){
		cout<<"IsbnNo: "; output<<b.isbnNo<<endl;
		cout<<"Title: ";  output<<b.title<<endl;
		cout<<"Price: "; output<<b.price<<endl;
		cout<<"Author No: "; output<<b.authorNo<<endl;
		for(int i=0; i<b.authorNo; i++) {
			cout<<"Enter Author "<<i+1<<"th: "; 
			output<<b.autherPtr[i]<<endl;
		}
		return output;
	}
	float operator+(float x, Book b){
		float temp;
		temp = x + b.price;
		return temp;
	}
	int getBookIndexWithLowestPrice(Book arr[], int n){
		int minPrice = arr[0].getPrice();
		int index = 0;
		for(int i=0; i<n; i++) {
			if (minPrice > arr[i].getPrice() ) {
				minPrice = arr[i].getPrice();
				index = i;
			}
		}
		return index;
	}
//need to overload >> operator to allow chaining
//Should ask info for all the fields from user

//need to overload << operator to allow chaining
//Should display all the fields of the object iff 
//the default values are replaced with user input

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
