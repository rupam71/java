#include<iostream>
using namespace std;

class City{
	string name; int population; float areaInSqKm;
	public:
		City() {
			name="TBA";  population=0;  areaInSqKm=0.0f;
		}
		setCityInfo() {
			cin.ignore();
			cout<<"Enter City Name: "; getline(cin,name);
			cout<<"Enter City Population: "; cin>>population;
			cout<<"Enter City Area In Sq Km: "; cin>>areaInSqKm;
		}
		showCityInfo() {
			cout<<"City Name: "<<name<<endl;
			cout<<"City Population: "<<population<<endl;
			cout<<"City Area In Sq Km: "<<areaInSqKm<<endl;
		}
}; 
 
class Neighbor{
	int noOfNeighbous; int *distanceToNeighbors; int *neighborIndices; 
	public:
		Neighbor() {
			noOfNeighbous=0; distanceToNeighbors=NULL, neighborIndices=NULL; 
		}
		setNeighborInfo() {
			cout<<"NO Of Neighbor: "; cin>>noOfNeighbous;
			distanceToNeighbors = new int [noOfNeighbous];
			neighborIndices = new int [noOfNeighbous];
		//	cin.ignore();
			for(int i=0; i<noOfNeighbous; i++) {
				cout<<"Enter "<<i+1<<" th Neighbor Indices: "; 
				cin>>neighborIndices[i];
				cout<<"Enter "<<i+1<<" th Distance To Neighbors: "; 
				cin>>distanceToNeighbors[i];
			}
		}
		showNeighborInfo(){
			cout<<"NO Of Neighbor: "<<noOfNeighbous<<endl;
			for(int i=0; i<noOfNeighbous; i++) {
				cout<<i+1<<" th Neighbor Indices: "<<neighborIndices[i]<<endl;
				cout<<i+1<<" th Distance To Neighbors: "<<distanceToNeighbors[i]<<endl;
			}
		}
};
 
class Graph{
	int noOfVertices; City *cities; Neighbor *neighbours; 
	public:
		Graph() {
			noOfVertices=0; cities=NULL; neighbours=NULL;
		}
		
		friend istream& operator>>(istream&, Graph&);
	    friend ostream& operator<<(ostream&, Graph&);
};
		//assume that neighbors are stored in sorted sequence      
		//in adjacency list based on their distance	
		istream& operator>>(istream& input, Graph& g){
			cout<<"Enter No Of Vertices: "; input>>g.noOfVertices;
			
			g.cities = new City [g.noOfVertices];
			g.neighbours = new Neighbor [g.noOfVertices];
			
			for(int i=0; i<g.noOfVertices; i++) {
				cout<<"Enter "<<i+1<<" th City: ";
				g.cities[i].setCityInfo();
				cout<<"Enter "<<i+1<<" th Neighbour: ";
				g.neighbours[i].setNeighborInfo();
			}
		}
		ostream& operator<<(ostream& output, Graph& g){
			cout<<"No Of Vertices: "; output<<g.noOfVertices<<endl;
			
			for(int i=0; i<g.noOfVertices; i++) {
				cout<<i+1<<" th City: ";
				g.cities[i].showCityInfo();
				cout<<"Enter "<<i+1<<" th Neighbour: ";
				g.neighbours[i].showNeighborInfo();
			}
		}
		void getNeighborsOfcityName(Graph g, string cityName, City neighborPtr, int n)
 
int main(){     
     Graph g; 
        cin>>g; 
		//equivalent of g.createGraph();     
		//assume that neighbors are stored in sorted sequence      
		//in adjacency list based on their distance   
 
    cout<<g; 
	// equivalent of displaying the city details in BFS fashion. Should ask    
	// name of the starting city from the user 
 
    string cityName; City *neighborPtr; int n;     
	cout<<”Enter a City name: “; cin>>cityName;     
	getNeighborsOfcityName(g, cityName, neighborPtr, n); 

//    int totalPopulation=0;     
//	for(i=0;i<n;i++) totalPopulation += neighborPtr[i]; 
// 
//    cout<<”Total population of the neighbors of ”<<cityName          
//	<<” is: ”<< totalPopulation<<endl; 
// 
//    cout<<”Enter a City name to start DFS traversal: “; 
//	cin>>cityName;     
//	g.traverseInDFS(cityName);      
//	// displays city details in DFS fashion starting from cityName. 
// 
    return 0; 
	}                         
