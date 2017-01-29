pragma solidity ^0.4.2;

/**
* A contract to buy access to content.
* 
* This contract was created by Team APME during the Hackerthon
* Hack the Valley in Baar, Switzerland
* 
* 
*/
contract APMEContract{
    
    function APMEContract(){
        apme = msg.sender;
    }
    
    modifier onlyAPME{
        if (msg.sender != apme) throw;
        _;
    }
    
        
    //#################################################################
    //
    //                        DATA STRUCTURES
    //
    //#################################################################
    
    
    //apme adress to collect possible fees adress
    address apme;
    
    //Map content to their id
    mapping(string =>Content) private contents;
    
    //Map adresses to the user
    mapping(address => string) private users;
    
    //Wallet of apme 
    address apme_adress;
    
    //Map id to user data
    mapping(string =>User) private _users;
    

    struct Content{
        
        //Id of the purchased content
        string contentId;
        
        //We want to know how often this was purchased
        uint256 counter;
        
        //Track how much revenue has been created by this content
        uint256 revenue;
    }
    
    // content of the user
    struct User{
        //unique id given by APME
        string userId;
        
        //Ownership
       mapping(string =>bool) ownership;
        
    }
    
    
    //Keep track of some statistics
    struct Purchase{
        string userId;
        string contentId;
        uint time;
        uint price;
    }
    
    // a global purchase history
    Purchase[] purchaseHistory;
    
    uint256 overallRevenue;
    uint256 overallUsers;
    uint256 overallContent;
    
    
    
    //#################################################################
    //
    //                        PAYMENT
    //
    //#################################################################
    
     function payForContent(string contentId, string userId, address paymentReciever, uint price) payable returns (string){
      
      if(price>msg.value){
         return "INSUFFICIENT FUNDS";
      }


      if(!contentExist(contentId)){
          //Register this content for statistics
          registerContent(contentId);
      }
      
      if(!userExist(userId)){
          //Register this user for statistics
          registerUser(userId);
      } 

      if(hasAccess(contentId,userId)){
          return "HAS ALREADY PAYED";
      }
      
      else{

          //if(paymentReciever.send(price)){
          //         return "PAYMENT SENDING FAILED";
          //}
         // else{
              _users[userId].ownership[contentId]=true;
              contents[contentId].counter++;
              contents[contentId].revenue+=price;
              overallRevenue+= price;
              overallContent++;
              purchaseHistory.push(Purchase(userId, contentId,now, price));
              
              return "SUCCESS";
          //}
      }
    }
    
    
    //#################################################################
    //
    //                        INSIGHT AND STATISTICS
    //
    //#################################################################
    
    function getPurchasesCountForContent(string contentId) constant returns (uint p){
        
        if(!contentExist(contentId)) throw;
        p=contents[contentId].counter;
    }
    
    function getRevenueForContent(string contentId) constant returns (uint256){
        
        if(!contentExist(contentId)) throw;
        return contents[contentId].revenue;
    }
    
    
    function getOverallPurchases() constant returns (uint256){
        return purchaseHistory.length;
    }
    
     function getOverallContent() constant returns (uint256){
        return overallContent;
    }
    
     function getOverallRevenue() constant returns (uint256){
        return overallRevenue;
    }
    
     function getOverallUsers() constant returns (uint256){
        return overallUsers;
    }
    
    //#################################################################
    //
    //                        COMMON FUNCTIONALITY
    //
    //#################################################################
    function contentExist(string contentId) constant returns (bool result){
        result =  bytes(contents[contentId].contentId).length > 0;
    }
    
    
    //Validate if a user exist for this msg.sender
    function userExist(string userId) constant returns (bool result){
       result= bytes(_users[userId].userId).length> 0;
    }
    
    //Create a user to track some basic statistic
    function registerUser(string userId) private {
        
        if(userExist(userId)) throw;
        users[msg.sender]=userId;
        _users[userId]=User(userId);
        overallUsers++;
    }
    
    // save the content to track some basic statistics
    function registerContent(string contentId) private {
       
        if(contentExist(contentId)) throw;
        contents[contentId]=Content(contentId,0,0);
        overallContent++;
    }
 
    //check if the user has access (payed) for the content
    function hasAccess(string contentId, string userId) constant returns (bool){
        if(!contentExist(contentId)) return false;
        if(!userExist(userId)) return false;
        return _users[userId].ownership[contentId];
          
    }
    
    //Only callable by the payment method
    function revokeAccess(string contentId, string userId) onlyAPME{
        if(!contentExist(contentId)) throw;
        if(!userExist(userId)) throw;
        _users[userId].ownership[contentId]=false;
    }
    
}
