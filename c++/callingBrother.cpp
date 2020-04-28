#include<iostream>
using namespace std;

class Person{
    int noOftaskCompleted;
    
public:
    Person(){noOftaskCompleted=0;}
    int getNoOftaskCompleted(){
        return noOftaskCompleted;
    }
    Person& buySnack(){
        cout<<"Snacks are bought :-)"<<endl;
        noOftaskCompleted++;
        return *this;
    }
    Person& arrangeLivingRoom(){
        cout<<"Living room is cleaned :-("<<endl;
        noOftaskCompleted++;
        return *this;
    }
    void serveSnackToMyFriends(){
        cout<<"Snacks Served !!!"<<endl;
        noOftaskCompleted++;
    }

};
int main(){
    Person nafi;
    //nafi.buySnack();
    //nafi.arrangeLivingRoom();
    //nafi.serveSnackToMyFriends();
    nafi.buySnack().arrangeLivingRoom().serveSnackToMyFriends();
    cout<<"No of task completed by Nafi: "
    <<nafi.getNoOftaskCompleted();

    return 0;
}
