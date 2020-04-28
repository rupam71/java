#include<iostream>
using namespace std;

class Book{
  //field: isbnNo, title, price; 
  //string *autherPtr; int authorNo;
public:
  //write default constructor
  //add other necessary member functions...
  //declare necessary friend functions...
};

//need to overload >> operator to allow chaining
//Should ask info for all the fields from user

//need to overload << operator to allow chaining
//Should display all the fields of the object iff 
//the default values are replaced with user input

int main(){
  int n, i; 
  cout<<"How many books? "; cin>>n;
  Book bookArr[n]; //an array of Book objects

  int noOfAuthors = populateBooks(bookArr, n);
  //write this global function
  //This function will replace the default values (set by constructor) of
  //n Books by using cin>>BookObject format in a loop. Finally it returns
  //total number of authors of all books of the array.

  cout<<”No of authors of all books is: “<<noOfAuthors<<endl;
  cout << “Detail of the books are: “ << endl;
  for(i=0; i<n ;i++) cout << bookArr[i] << endl;
  int index = getBookIndexWithLowestPrice(bookArr, n);
  int x; cin>>x;
  
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
