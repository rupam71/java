#include<iostream>
#include<queue>
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
		string getName() { return name;}
		getPopulation() { return population;}
		setPopulation(int n) { population = n;}
		friend int operator += (int, City);
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
				cout<<"Enter "<<i+1<<" th Neighbor Distance: "; 
				cin>>distanceToNeighbors[i];
				cout<<"Enter "<<i+1<<" th Neighbor Indices: "; 
				cin>>neighborIndices[i];
			}
		}
		showNeighborInfo(){
			cout<<"NO Of Neighbor: "<<noOfNeighbous<<endl;
			for(int i=0; i<noOfNeighbous; i++) {
				cout<<i+1<<" th Neighbor Indices: "<<neighborIndices[i]<<endl;
				cout<<i+1<<" th Distance To Neighbors: "<<distanceToNeighbors[i]<<endl;
			}
		}
	//	 getNeighborIndices() { return neighborIndices;}
};
class Graph{
	int noOfVertices; City *cities; Neighbor *neighbours;
	int **adjMat; 
	public:
		Graph() {
			noOfVertices=0; cities=NULL; neighbours=NULL;
		}
		getNoOfVertices(){return noOfVertices;}
		void traverseInDFS(string city) {
			int index =-1;
			for(int i=0; i<noOfVertices; i++) {
				if ( city == cities[i].getName()) {
					index = i;
					break;
				}
			}
			queue<int>q;
			q.push(index);
			
			bool visited [noOfVertices];
			for(int i=0; i<noOfVertices; i++){
				visited[i] = false;
			}
			
			while(!q.empty()){
				int current = q.front();
				q.pop();
				
				if(visited[current]==false){
					cout<<" City: ";
				cities[current].showCityInfo();
			cout<<" Neighbour: ";
				neighbours[current].showNeighborInfo();
				cout<<endl;
			visited[current]=true ;
				}
				
				for(int i=0; i<noOfVertices; i++) {
				if(adjMat[current][i]>0 && visited[i]==false){
					q.push(i);
					break;
				}
			}
		}	//	while End
	}	//travarse End
		
		friend istream& operator>>(istream&, Graph&);
	    friend ostream& operator<<(ostream&, Graph&);
};
		int operator += (int t, City c) {
			int temp;
			temp = t + c.population;
			return temp;
		}
		//in adjacency list based on their distance	
		istream& operator>>(istream& input, Graph& g){
			cout<<"Enter No Of Vertices: "; input>>g.noOfVertices;
			
			g.cities = new City [g.noOfVertices];
			g.neighbours = new Neighbor [g.noOfVertices];
			
			// city info first
			for(int i=0; i<g.noOfVertices; i++) {
				cout<<"Enter "<<i+1<<" th City: ";
				g.cities[i].setCityInfo();
			}
			// Neighbor info last
			for(int i=0; i<g.noOfVertices; i++) {
				cout<<"Enter "<<g.cities[i].getName()<<" Neighbour Information: ";
				g.neighbours[i].setNeighborInfo();
			}
			
			 g.adjMat = new int*[g.noOfVertices];
			for(int i=0;i<g.noOfVertices;i++)
            g.adjMat[i]=new int[g.noOfVertices];

        cout<<endl;
			
	//		g.adjMat = new int [g.noOfVertices][g.noOfVertices];
			bool b;
			for(int i=0; i<g.noOfVertices; i++){				
				for(int j=0; j<g.noOfVertices; j++){
					if(i == j){ g.adjMat[i][j]= 0 ;}
					else {
						cout<<"Enter 0 or 1 Value "<<endl;
						cout<<"Is "<<g.cities[i].getName()<<" Has A Neighbour Name "<<g.cities[j].getName()<<" ?";
						input>>b;
						g.adjMat[i][j]=(int)b;
					}
				}
			}
		}
		ostream& operator<<(ostream& output, Graph& g){
			cout<<"No Of Vertices: "; output<<g.noOfVertices<<endl;
			string city; cout<<"starting city: "; cin>>city;
			int index = -1;
			cout<<endl;
			
			queue<int>q;
			for(int i=0; i<g.noOfVertices; i++) {
				if ( city == g.cities[i].getName()) {
					index = i;
					break;
				}
			}
			
			
			bool visited [g.noOfVertices];
			for(int i=0; i<g.noOfVertices; i++){
				visited[i] = false;
			}
			
			q.push(index);
			
			while(!q.empty()) {
				int current = q.front();
				q.pop();
				
				if(visited[current]==false){
				cout<<" City: ";
				g.cities[current].showCityInfo();
				cout<<" Neighbour: ";
				g.neighbours[current].showNeighborInfo();
				visited[current]=true ;
				cout<<endl;
			}
			
			for(int i=0; i<g.noOfVertices; i++) {
				if(g.adjMat[current][i]>0 && visited[i]==false){
					q.push(i);
				}
			}
		}	//while End
	}	//operator End
		void getNeighborsOfcityName(Graph g, string cityName, City *neighborPtr, int n) {
//			for(int i=0; i<g.getNoOfVertices(); i++) {
//				if ( cityName == g.cities[i].getName()) {
//					index = i;
//					break;
//				}
//			}
//			string cityName; City *neighborPtr; int n;
			neighborPtr = new City [n];
			for(int i=0; i<n; i++) {
				//neighborPtr[i].getPopulation();
				neighborPtr[i].setCityInfo();
			}
			
		}
 
int main(){     
     Graph g; 
//        cin>>g;    
		//in adjacency list based on their distance   
 
//    cout<<g; 
 
    string cityName; City *neighborPtr; int n=2;     
	cout<<"Enter a City name: "; cin>>cityName;     
	getNeighborsOfcityName(g, cityName, neighborPtr, n); 
	
    int totalPopulation=0;     
	for(int i=0;i<n;i++) totalPopulation += neighborPtr[i]; 
 
    cout<<"Total population of the neighbors of "<<cityName          
	<<" is: "<< totalPopulation<<endl; 
 
    cout<<"Enter a City name to start DFS traversal: "; 
	cin>>cityName;     
	g.traverseInDFS(cityName);      
	 
 
    return 0; 
	}                         
