#include <iostream>
using namespace std;

class City{
    string name;	int population;    float areaInSqKm;
	public:
	int getPopulation(){	return this->population;	}
	string getCityName(){	return name;    }
	void setCityInfo(){
       cout<<"Enter City Name "<<endl;
       cin>>name;
       cout<<"Enter City Population"<<endl;
       cin>>population;
       cout<<"Enter Area In Square In KM"<<endl;
       cin>>areaInSqKm;
   }
	void showCityInfo(){
        cout<<"City Name "<<name<<" ";
		cout<<"City Population : "<<population<<" ";
		cout<<"Area In Square In KM"<<areaInSqKm<<endl;
	}
};
class Neighbor{
    int noOfNeighbous;	int *distanceToNeighbours, *neighborIndices;
	public:
	int getNoOfNeighbour(){	return noOfNeighbous;	}
	int* getNeighbourIndices(){	return neighborIndices;	}
	void setNeighbourInfo(){
        cout<<"How many Neighbours?"<<endl;
        cin>>noOfNeighbous;
        distanceToNeighbours=new int[noOfNeighbous];
        neighborIndices=new int[noOfNeighbous];
		cout<<"Now insert distance and index of your neighbour"<<endl;
        for(int i=0;i<noOfNeighbous;i++){
        	cout<<i+1<<" th distance To Neighbours: ";	cin>>distanceToNeighbours[i];
            cout<<i+1<<" th neighbor Indices: ";	cin>>neighborIndices[i];
        }
	}
};
class Graph{
    int noOfVertices;	City *cities;    Neighbor *neighbours;
	public:
	friend void operator>>(istream&in ,Graph &g);
    friend void operator<<(ostream &out,Graph g);
    friend void getNeighborsOfcityName(Graph  &g, string nameOfcity,City *&neighborPtr,int &n);
};
void operator>>(istream&in ,Graph &g){
    cout<<"How many Cities?"<<endl;
    in>>g.noOfVertices;
    g.cities=new City[g.noOfVertices];
    g.neighbours=new Neighbor[g.noOfVertices];
    for(int i=0;i<g.noOfVertices;i++){
        g.cities[i].setCityInfo();
        g.neighbours[i].setNeighbourInfo();
    }
}
void operator<<(ostream &out,Graph g){
    for(int i=0;i<g.noOfVertices;i++){
        g.cities[i].showCityInfo();
    }
}
void getNeighborsOfcityName(Graph  &g, string nameOfcity,City *&neighborPtr,int &n){
    int track=0;
    for(int i=0;i<g.noOfVertices;i++){
        if(g.cities[i].getCityName()==nameOfcity){
            track=i;
            break;
        }
    }
	int *myNeighhbourIndicies = g.neighbours[track].getNeighbourIndices();

    n=g.neighbours[track].getNoOfNeighbour();
    neighborPtr = new City[n];
	for(int i=0;i<n;i++){
       neighborPtr[i]= g.cities[myNeighhbourIndicies[i]];   
   }
}
void operator+=(int &totalPopulation, City neighborPtr){
    totalPopulation+= neighborPtr.getPopulation();
}
int main(){
	Graph g;
    cin>>g; 
    cout<<g;
    
  	string cityName; 
  	City *neighborPtr;
  	int n;
  	cout<<"Enter a City name: ";
  	cin>>cityName;
  	getNeighborsOfcityName(g, cityName, neighborPtr, n);
  	int totalPopulation=0;
  	for(int i=0;i<n;i++)
  	totalPopulation += neighborPtr[i];
  	cout<<"Total population of the neighbors of "<<cityName<<" is: "<< totalPopulation<<endl;
  	
	return 0;
}
