﻿\1.      Harriet Zhu and Saifei Liao will work on Store and StoreManager. The store will be responsible for making exchanges with the Player class and the StoreManager will implement all the exchange details for the store. Store is the entity class and StoreManager is the use cases class. Harriet Zhu is mainly responsible for implementing the Store class and in the next stage, the StoreManager class will be implemented together. The problem we encountered is how to record user's input and how to develop GUI with Android Studio.        

\2.   Yi Yang is working on the class Plants, which contains the name, plant time, buying price, selling price, and experiment point when the plants are harvested. He will make sure we have enough different plants to plant and the data for the plant are  appropriate. Plants is an entity class and it will be the basement of other classes. The problem I encountered during the process is making sure the data for the plants are good for players to progress. This farming process cannot be too fast or too low.

\3. Jason Liu and Servus Chen worked on the LandEntity class, Warehouse class, WarehouseManager class  and LandManager class. The LandEntity class will be responsible for a piece of land that a player can plant on.  The LandManager will be responsible for modifying the LandEntity class. The Warehouse is responsible for storing what a player has, and it is modified by the WarehouseManager class. We did well at defining only the most essential attributes in our classes.  This ensures our class can have all its functions with minimum attributes, to make the class less complex and easier to understand. The problem we encountered during the process is deciding how our classes should work with other classes.  

\4. (Jingquan Cao). I am working on Player, PlayerManager, Item class. Player is an entity who stores basic data including name, money, level, warehouse, exp bar. PlayerManager updates player’s info by some operations like gain exp, add/subtract money. item is a class of various tools for farming. I also wrote some unit tests for my classes. The main problem I have is that I am not sure how to apply clean architecture and solid principles when trying to organize codes. I plan to implement more items and also more methods in PlayerManager in the next phase.

We have designed our project based on clean architecture: we created packages for entities, use cases and controllers separately. With this design, we can clearly see the relationships between classes, and we can easily utilize the class as needed.

