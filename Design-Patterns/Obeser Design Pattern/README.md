# Observer Design Patter  
Consider YouTube, how are we getting notifications whenever there is a new video uploaded from channel which we subscribed?  
The problem is **if one object's status is changed, then how this is communicated with other objects**  
Polling Technique solve this problem without using Observer Design Pattern  
### Polling Technique:
Terminology is simple  
**Observable/Subject**: object which changes it's states  
**Observer**: which wants to know changes in observable and there can be many observers  
**drawback** : observer checks the observable whether it got changes its state or not by sending frequent requests to obervable  
### Pushing Technique: 
This is the Observer Design Pattern  
It is the Observable responsibility to notify observer whenever there is change in observable state  

```
Definition of Observer Design Pattern:
Defines a one to many relationship between objects so that when one object changes state, all of its dependents are notified and updated automatically
```
### Standard UML:




