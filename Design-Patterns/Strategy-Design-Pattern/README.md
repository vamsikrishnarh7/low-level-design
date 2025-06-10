# Strategy Design Pattern  
This pattern says Inheritance is bad  
For an example, we are building an app for Robot simulation in which different kind of robots walk, talk etc..  

Lets add another robot called **SparrowRobot** which can *fly*  
Assume we have some number of robots which can fly  
So for each robot we have to fly() method. Clearly there is no resuability of fly() methpd which is exacly same for all flyable robots like SparrowRobot, CrowRobot etc..  
If we keep fly() method in Robot class itself then all non-flyable robots will also fly.  
