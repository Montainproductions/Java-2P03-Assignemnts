# Java 2P03 Assignments

This is the work for the 4 main assignments that I had to work on while in the COSC 2P03 Advance Data Structure class at Brock University.
 
## Assignment 1

For this assignment I was required to make a wait queue for a clinic and had to use a Linked list to create the queue and as time in the day passed (Calculated through a monitor that calculated the time of day) it would either insert a new patient or eliminate the first person in the queue.
 
The main errors I could have improved on was in the process of adding the eliminate first person in queue I had started to move some code that was initially setting up the Queue which meant that it caused a problem were the last person in the txt file was appearing repeatedly in the linked list. Because I was working on it very close to the deadline, I didn’t have enough time to notice and fix the problem.

Meanwhile since I was able to work on LinkedList last year for a different class it wasn’t as hard to wrap my head around it and get the base linked list working for the rest of the assignment
 
 ## Assignment 2
 
 The second assignment had to do with saving information in a binary search tree and then be able to inOrderTraverse the general tree and search for a specific given drug. After this I also implemented two different depth methods, one to calculate the depth of a given drug while the other one is meant to find the drug with the largest depth in the tree.

Overall, this assignment wasn’t very complicated as most of the things I needed to work on was easy to implement. I lost 0.5 points when I didn’t implement a separate java class called BinaryNode (Which had a method named “Display node, I don’t see much of a reason why since I already have a display drug in the drug class, and I can call it when I traverse each drug node) and I lost 0.25 points for only having 1 base case instead of 2.
 
## Assignment 3
 
For this assignment I was required to build a heap data structure to store a set of drug information. After that I was meant to implement a trickle-down system that would go through the heap and update the position of any drug I needed (Usually the first object in the Heap array).
 
The most difficult part of the assignment was setting up the Heap arrays and knowing if the Heap I was outputting was ordered correctly or I was doing it incorrectly. Especially since at time I was getting confuse inbetween heaps and binary tree data structure as the professor as part of his explanation of the assinment compare them to binary trees and some of the example code he had gone through was being explain in a similar fashion to binary trees. This meant that I had to do some external resarch with the textbook and some other websites to better understand the diffrences between both data structures. 
After recving my grade for the assignment I realized that I had lost points because I wasnt properly using the findmin method for later parts of the assignment which meant that I had been deducted the 1.25 points.
 
## Assignment 4

This final assignment has to do with graphs where I need to go through a list of drugs and 2 different 2d matrixes to find which drugs are connected to other drugs and place them in their own module ID value. After this I am meant to make a new array and pair of matrixes that are part of a specific module group which I am meant to then find the shortest path between two drugs either using a Breadth first search or Dijkstra algorithm depending on if I need to search in the unweighted or weighted matrix.

For the marks I lost it had to do with not having worked and uploaded a satisfactory MSTPrim method, meanwhile the FindShortestPath method for both the weighted and unweighted wasnt complete enough for the TAs to give me points towards my final grade.
