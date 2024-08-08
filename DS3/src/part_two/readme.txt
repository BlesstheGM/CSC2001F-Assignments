Simulation Readme

SimulatorTwo.java - README

This simulation program, SimulatorOne.java, is designed to model a scenario where taxis operated by different companies serve clients by transporting them between shops within a given network. Below is a brief description of the features implemented in this version:

1. Taxis are not always stationed at shops:
   - Taxis are dynamically allocated based on client requests and their availability.

2. Taxis can take a client to any shop:
   - Upon receiving a client request, the program finds the nearest available taxi and simulates the journey to the desired shop.

3. Some/all taxis can carry 2 or more clients:
   - The program supports the concept of taxis being able to carry multiple clients simultaneously, though this specific functionality is not implemented in this version.

4. The number of taxis is finite:
   - The simulation considers a finite number of taxis available for each company, and clients can only be served if there are available taxis.

5. Taxis and shops belong to different companies:
   - Taxis are assigned to specific companies, and they only operate between shops of their respective company.

6. Client calls are interspersed with traffic reports requiring changes to the graph weights:
   - Although not explicitly implemented, the program can be extended to incorporate traffic reports and dynamically update graph weights accordingly.

Usage:
- Compile and run the SimulatorOne.java file.
- Input the graph details, company details (number of taxis for each company), and client requests.
- The program will simulate taxi-client interactions and output the journey details.



Example:
# >> Input

# Graph representing the road network and distances between shops
4
A B 10 C 15 D 20
B C 5 D 7
C D 3

# Company details
2
QnQ 2
Shopfite 2

# Client requests
3
A QnQ C
B Shopfite D
C Shopfite A

# >> Output

Client at node A has been picked up by taxi 1 of QnQ Taxis. Taxi travels from A to C.
Client at node B has been picked up by taxi 1 of Shopfite Cabs. Taxi travels from B to D.
Client at node C has been picked up by taxi 2 of Shopfite Cabs. Taxi travels from C to A.


Author:
Blessing Hlongwane


