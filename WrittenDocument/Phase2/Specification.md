Specification (This is also included in Design Document)

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
