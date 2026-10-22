// Requirements:
-> First you need to understand what is amazon locker 
-> Take a flow of user use the system and understand  what it needs

I ordered TV from amazon and I opted for locker .
// A user can choose any locker, or it has to in some KM of radius to his actual location.
// Since it is mentioned in the question that I will be getting code which I need to put in system which unlocks the locker and then I can get my TV. 
// is there any product dimension verification for locker check 
// here we can assume that whatever product we order as now can go to locker 
// A code is unique to a locker of a particular location 
// if someone know the code can get the product from the locker 
// A locker can just have one single item or it can be many?
// A code is basically for locker for a user, and it can have multiple items or per item we have code?
// once the product is take one cycle of delivery is completeing notifing the user .


requirements:

1) User should be able to select a locker or not depends what interviews say or by default when you opt for locker, system assigns you a location of the locker 
2) User should be able to put the code
3) Upon recieveing the code, the system should verify the user, and unlocks the locker .
4) User can collect his order from the locker .(Does user need to completely close the locker or how does that locker gets ready for the next order)
5) Lets suppose a user does not takes his order, then is the locker going to be remain closed forever.
6) Each locator should have sopme manual workaround needed to manage this kind of situations?

# Non-functional requirements:
1) Do I need to draw the class or show the end- end working code?
2) Rest api are needed or console based is fine 
3) Do I need to add database or in-memory is fine?

Second Try:

Step1 : List the actors:
1) Delivery agent which picks the order from the amazon warehouse and delivery to the locker(here we dont care about which locker).
2) User whose parcel it is 
These are the two actors who are going to use this 

Step2 : 
Lets list  action for Delivery Agent:
1) Delivery agent is assigned multiple order.
2) Each order basically tell the agent to pick the product from the warehouse and put it to the required lockers.
3) Once he delivers it notifies to the system that order is ready to be collected.

Lets list actions for User who placed the order:
1) User when recieved the notification that his parcel is ready to collect? (Here I will ask the interviewer that when the code generation will takes place?)
2) User reaches to the locker destination and put his code in the system.
3) Sysetm will verify the code and check for locker having his parcel
4) Once verified the locker opens and user can collect the parcel 


Step3 : 
Lets draw the unahppy path:
1) Lets say delivery agent has put the parcel in the locker,
   and user cancels the order and since if lets say the user is having the code, he can go and collect even thought order is cancelled
   before the delivery agents picks up the cancelled order.
2) What if user multiple times enters the wrong code? We might put this locker locks for next 24 hours and regenerate the code again .

3) Steps can have multiple compartment, we need to fit the right product dimension to the right locker so that we will have more space for parcels

4) What about the system where user does not collects the parcel and that locker reamains locked for a very long period of time 


Step4 : 
1) Agents deposit package to the system 
2) System assigns the free smallest compartment satisfying its dimensions and system locks the lockers and generate a unique ID and notifies the customer
3) Custom upon receving notification visit the locker collects the parcel.
4) Sytem frees the compartment and mark the delivery complete 

OUT Of scope:
Lets say once product is assigned to locker and customer does not come to pick it , it should be either again pick up by customer agent and should move to 
some common storehouse(which is just meant for this parcel to be collected which are undeliverd. and slowly and gradely should mark them cancel if custerom does not pick it)


