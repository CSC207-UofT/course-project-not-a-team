
SLOID

    1. We use interfaces or abstract classes when some classes have the same methods, and enforce those classes to inherit or implement
       those abstractions. This follows Interface Segregation Principle.
    2. We define a Storable interface for Plants, Seeds, Items(entity classes). The warehouse needs to interact with those classes. 
       When the WarehouseManager(use cases) manipulates those classes, the parameters are passed as Storable type. This makes use of 
       the Dependency Inversion Principle since the higher modules depend on abstraction to interact with lower modules.
    3. Every class in our program only has one responsibility. For example, the Store class is only responsible for the transaction 
       between player and store; the Warehouse class is only responsible for storing items; the land class is only responsible for 
       cultivating seeds, etc. When we design our program, we clearly follow the Single Responsibility Principle.

---

Clean architecture ([reference link](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html))

    We have built the project based on clean architecture: we developed the entities first and UI/databases last. The project 
    satisfies the following rules from the above reference link:
        1. The project is testable without external elements.
        2. The project is independent of UI and databases, meaning that the user can change UI and databases easily without changing 
           the inner layers.
        3. The source code dependencies only point inwards (the inner layers do not depend on outer layers).

The following is a picture of how we organized our package using clean architecture
![a](https://github.com/CSC207-UofT/course-project-not-a-team/blob/main/WrittenDocument/Phase2/packaging.jpg)

---

Design Pattern

    1. Observer Design Pattern:
       We use observable to monitor any change the player makes. The reason why we use the observer design pattern is that our database
       needs to be updated as the player makes changes(such as clicking buttons) in real time. Once the database is updated,  entities,
       more specifically, land, player, store and warehouse will be updated accordingly. From the coding perspective, controllers will 
       observe changes made in managers and transmit those changes back to the database. 
    2. Factory Design Pattern:
       The implementation of items in entities used factory design pattern, so that item factory can create different items based on 
       different input. Our first design is to define an abstract super class item and different concrete child classes for each item 
       including fertilizer and watering can. But we noticed that this could be adapted to simple factory design pattern so that our 
       code could be easier to understand. The use of factory design pattern on item might look naive right now, but it will be more
       helpful if we were to implement more concrete items in the future.

---

Use of Github Features

    Issues: 
        We used issues as a reminder of what we should do next. Since we were working in person for the majority time of the term, we 
        only created five issues, but our group still finds it useful.
 
 For refactor feature of github, see 'Refactoring' session; for major pull request, see 'Brief summary of each member's work since phase 1' session
 
---

Code Style and Documentation

    We fixed all the warning and checked that Javadoc are all written whenever needed during our last final check before deadline of 
    presentation.
    
**TODO**
gateway, viewModel, MainViewModel, viewModel, System
need docstring

---

Testing

    Most part of our project's code are tested, including controller classes, use case classes and entity classes (i.e. code other than
    the outmost layer of clean architecture). We did test our database part of the code through AndriodStudio feature instead of using 
    unit test, so this is not shown on the test coverage. However, we do find it difficult to test the front end part of the program.
    
**TODO**
maybe include screenshot of test coverage

---

Refactoring

    We used the request change feature of pull request to ask each other to refactor the corresponding code. The following are the 
    places where we used the refactoring feature in phase 2.
        For #136 pull request, we have refactored the document README.md by making it be more specific.
        For #137 pull requests, we add a new function to harvest all plants in one click, the change of controller has some 
        problem and we request some change.

Here are the corresponding pull request link: [pull request #136](https://github.com/CSC207-UofT/course-project-not-a-team/pull/136) 
[pull_request_#137](https://github.com/CSC207-UofT/course-project-not-a-team/pull/137)

---

Code Organization

    We choose package by layers as our packaging strategy. We have six major packages that are constructed according to the clean
    architecture.

See Clean Architecture for a picture of our packaging strategy.

---

Specification

    Player: Every player has a level, experience bar, warehouse, money, name. The player can set their preferred name at the start of 
    the game and will be able to level up once they fulfill the experience bar at this level. The player can use money to buy seeds or 
    items (fertilizers, watering can) and he/she can sell harvest plants to the store to earn money. 
    
    Plant and Seed: Plant is now divided into two stages: Plant and Seed. The player can buy seeds from the store, plant the seed, wait
    for the seed to mature, and then sell harvested plants back to the store. 
        Every plant has a plant name, selling price, id, plant type. 
        Every seed has a seed name, planting time(how much time the seed needs to mature), buying price, experience point(experience 
        points are the points the player can earn by successfully harvesting the plant(matured seed)), id, seed type.
        
    Land: The player also has the land entity. The level of the player corresponds to how much lands he/she can unlock.The land entity 
    has lock status, plant, water time, stage, price, index.  If the land’s status is unlocked, the player can buy the land and start 
    growing plants. Plant and water time varies according to the given plant. Each plant has 3 stages: 1. Seed 2. Watering stage 3. 
    Matured plant. The number of lands represents the maximum number of plants the player can grow each time. 
    
    Items: Items have price, item name, and id. For now, it only includes fertilizers and watering can:
        Fertilizers can be used to boost the growth speed of the plant (decrease the plant time).
        Watering can can be used to water the plants, once the plant is watered, the plant will continue growing.

    Warehouse: The player’s warehouse will be used to store all the products, including seeds, plants, and items. The capacity of the 
    warehouse will increase as the level of the player increases.

    Store: The player can buy plants, seeds and items from the store. The store will unlock more products as the level of the player 
    increases.

---

Major design decisions in Phase 2

    1. LandManager update: In phase 1 we use one LandManager for one land, as the number of land increase the number of LandManager 
       also increase, so in phase 2 we use one LandManager for all lands. This will lighten the load on database, help us add new 
       features to make it easy-to-use and manageable.
    2. UI upgrade: In phase 1 our app just have some text description, in phase 2 we changed some structures in UI and add pictures in
       it to make it follow the simple and intuitive use.
    3. Apply MVVM: After the phase 1 TA point out that we have some structures problem in our code, so we changed our code to make it 
       follow the MVVM pattern. We used to have controller and presenter in our file, but now we merged the controller into ViewModel 
       and put the simple message in presenter into the constant file. Then our code will follow the MVVM pattern.
    4. Add new features to follow the 7 principles: Auto Harvest, buy multiple items in one click. We found that our UI could be more 
       easy for users to operate, these features can help to reduce the physical effort.

---

Brief summary of each member's work since phase 1

    Jingquan Cao, github name: J-D-CONNOR: My major code work is that I implement auto-harvest feature on pull request 137. This pull is 
    significant since this feature allows us to follow 7 principles of universal design.
    
Relevent pull request link: [#137](https://github.com/CSC207-UofT/course-project-not-a-team/pull/137)
