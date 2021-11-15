Major design decisions:

    In phase 0, we have only one entity——Plant——to represent all three stages(from seed to matured
    plants) of the plants. In phase 1, we have decided to add Seed to the entity. Therefore, instead
    of using one entity throughout the stages, the Seed instance will be converted to Plant instance
    as it matures in the land. Now, as stated in the Specification, seed has a seed name, planting
    time, buying price, experience point, id, seed type, while plant has a plant name, selling
    price, id, plant type.

    Also, we have reached an agreement that Warehouse has only use cases but no controller while
    Store has only controller but no use cases.
    - Warehouse: The player will not be able to modify the warehouse by himself or herself;
        however, the warehouse can be changed by specific actions including planting a seed or
        buying products from the store. Thus, although the player does not have direct access to the
        warehouse, the land controller and store controller will call the warehouse manager to
        perform specific actions.
    - Store: the reason why the store does not have a manager is because the store itself won’t
        change no matter what the player does. In order to make changes to player and warehouse, the
        store controller will interact with player manager and warehouse manager. For example, if
        the player wants to buy a seed from the store, the store controller will first ask the
        player manager to check if the player has enough money, if yes, then the store controller
        will move on to add the bought product to the warehouse via warehouse manager.

How the project adheres to Clean Architecture:

    We have built the project based on clean architecture: we developed the entities first and
    UI/databases last.  The project satisfies the following “rules”:
    - The project is testable without external elements.
    - The project is independent of UI and databases, meaning that the user can change UI and
        databases easily without changing the inner layers.
    - The source code dependencies only point inwards (the inner layers do not depend on outer
        layers).

How the project is consistent with the SOLID design principles:

    We use interfaces or abstract classes when some classes have the same methods, and enforce those
    classes to inherit or implement those abstractions. This follows Interface Segregation
    Principle.

    We define a Storable interface for Plants, Seeds, Items(entity classes). The warehouse needs to
    interact with those classes. When the WarehouseManager(use cases) manipulates those classes, the
    parameters are passed as Storable type. This makes use of the Dependency Inversion Principle
    since the higher modules depend on abstraction to interact with lower modules.

    Every class in our program only has one responsibility. For example, the Store class is only
    responsible for the transaction between player and store; the Warehouse class is only
    responsible for storing items; the land class is only responsible for cultivating seeds, etc.
    When we design our program, we clearly follow the Single Responsibility Principle.

Packaging strategies:

    We choose package by layers as our packaging strategy. We have six major packages that are
    constructed according to the clean architecture.

Implemented design pattern:

    We use observable to monitor any change the player makes. The reason why we use the observer
    design pattern is that our database needs to be updated as the player makes changes(such as
    clicking buttons) in real time. Once the database is updated,  entities, more specifically, land, player, store and warehouse will be updated accordingly. From the coding perspective, controllers will observe changes made in managers and transmit those changes back to the database.