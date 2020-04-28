#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

class Matrix{
	int** dataPtr; int row,col;

	public:
	// write default constructor
	Matrix(){
		row = col = 0;
	}

	//write parameterized constructor:
	 Matrix(int x, int y)
    {
        row=x;
        col=y;

        dataPtr = new int*[row];

        for(int i=0;i<row;i++)
            dataPtr[i]=new int[col];

        cout<<"Enter the values:";  
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                cin>>dataPtr[i][j];
    }

	//write parameterized constructor:
	Matrix(int r, int c, int val){
		//dataPtr[i][j] = rand() % val
		srand(time(NULL));
		row = r; col = c;
		 dataPtr = new int *[row];
		 for(int i=0; i<row; i++) 
		 dataPtr[i] = new int [col];
		 
		 //value
		 for(int i=0; i<row; i++) {
		 	for(int j=0; j<col; j++) {
		 		dataPtr[i][j] = rand() % val;
			 }
		 }
	}

	void getMatrix(){
		cout<<"Enter Row: "; cin>>row;
	    cout<<"Enter Col: "; cin>>col;
	    
		 dataPtr = new int *[row];
		 for(int i=0; i<row; i++) 
		 dataPtr[i] = new int [col];
		 
		 //value
		 cout<<"Enter the values: ";
		 for(int i=0; i<row; i++) {
		 	for(int j=0; j<col; j++) {
		 		cin>>dataPtr[i][j];
			 }
		 }
	}

//	void showMatrix void(){
	void showMatrix(){
		cout<<"All Matrix Value: "<<endl;
		for(int i=0; i<row; i++) {
		 	for(int j=0; j<col; j++) {
		 		cout<<dataPtr[i][j]<<"  ";
			 }
			 cout<<endl;
		 }
	}

	Matrix operator+=(int x){
		for(int i=0; i<row; i++) {
		 	for(int j=0; j<col; j++) {
		 		dataPtr[i][j] = dataPtr[i][j] +x ;
			 }
		 }
	}

	Matrix operator+(Matrix m){
		Matrix temp;
		temp.row = row;
		temp.col=col;
		
		temp.dataPtr = new int *[row];
		for(int i=0; i<row; i++)
		temp.dataPtr[i] = new int [col];
		
		for(int i=0; i<row; i++) {
		 	for(int j=0; j<col; j++) {
		 		temp.dataPtr[i][j] = dataPtr[i][j] + m.dataPtr[i][j] ;
	}} return temp; }

	friend Matrix operator+(int, Matrix);
};

//global function which is friend & therefore can access private fields
Matrix operator+(int x, Matrix m){
	Matrix temp;
		temp.row = m.row;
		temp.col= m.col;
		
		temp.dataPtr = new int *[m.row];
		for(int i=0; i<m.row; i++)
		temp.dataPtr[i] = new int [m.col];
		
		for(int i=0; i<m.row; i++) {
		 	for(int j=0; j<m.col; j++) {
		 		temp.dataPtr[i][j] = m.dataPtr[i][j] + x ;
	}} return temp; 
}

int main(){
	Matrix m1, m2(3,2), m3(3,3,50), m4, m5;
	m1.getMatrix();
	cout<<"Matrix m1: "<<endl; 	m1.showMatrix();
	cout<<"Matrix m2: "<<endl; 	m2.showMatrix();
	cout<<"Matrix m3: "<<endl; 	m3.showMatrix();
	m1 += 2;
	cout<<"After m1 +=2, m1 = "<<endl; m1.showMatrix();
	m4 = m1 + m2 + m3;
	cout<<"After m4 = m1 + m2 + m3, m4 = "<<endl; m4.showMatrix();

	m5 = 3 + m4;
	cout<<"After m5 = 3 + m4, m5 = "<<endl; m5.showMatrix();
	return 0;
}







