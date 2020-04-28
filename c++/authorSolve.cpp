#include<iostream>
#include<cstdlib>
using namespace std;

class Book{

    int isbnNo;
    int authorNo;
    float price;
    string *autherPtr;
    string title;

public:
    Book()
    {
        isbnNo = 0;
        title = " TBA ";
        price = 0.0;
        autherPtr = NULL;
        authorNo = 0;
    }

     istream &operator >>(istream &input, Book &c)
    {
        cout<<"Enter isbnNo: ";input>>c.isbnNo;
        input.ignore();
        cout<<"Enter Title: ";getline(input, c.title);
        cout<<"Enter Price: ";input>>c.price;
        cout<<"Enter Author No: ";input>>c.authorNo;
        c.autherPtr = new string [c.authorNo];
        input.ignore();
        for(int i=0;i<c.authorNo;i++)
        {
          cout<<"Enter Author "<<i<<" ";
          getline(input,c.autherPtr[i]);

        }
        return input;
    }
     ostream &operator <<(ostream &output , Book &c)
    {
        if(c.isbnNo != 0)
    {
        cout<<"isbnNo: "; output<<c.isbnNo<<endl;
        cout<<"tile: "; output<<c.title<<endl;
        cout<<"price: "; output<<c.price<<endl;
        cout<<"authorNo: "; output<<c.authorNo<<endl;
        cout<<"--Authors--"<<endl;
        for(int i=0;i<c.authorNo;i++)
        {
            cout<<"Auther "<<i<<" ";
            output<<c.autherPtr[i]<<endl;
        }
    }

        return output;
    }
    int getAutherNo()
    {
        return authorNo;
    }
    int getPrice()
    {
        return price;
    }





};
int populateBooks(Book bookArr[], int n)
{
    int author = 0;
    for(int i=0;i<n;i++)
    {
        cin>>bookArr[i];
        author = author + bookArr[i].getAutherNo();
    }
    return author;
}
 int getBookIndexWithLowestPrice(Book bookArr[],int n)
    {
       int minP = bookArr[0].getPrice();
       int index = 0;
       for(int i=0;i<n;i++)
       {
           if(bookArr[i].getPrice() < minP)
            minP = bookArr[i].getPrice();
            index = i;
       }
       return index;
    }

int main()
{
    int n;
    cin>>n;
    Book bookArr[n];

    int author = populateBooks(bookArr, n);
    cout<<"No of authors of all books is: "<<author<<endl;
    cout << "Detail of the books are: " << endl;
    for(int i=0; i<n ;i++)
    {
        cout << bookArr[i] << endl;
    }
    int index = getBookIndexWithLowestPrice(bookArr, n);

//    int x; cin>>x;
//    if(bookArr[index]<500.0)
//        bookArr[index] += x;

    return 0;
}
