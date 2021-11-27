- The player will enter a preferred username at the start the game.
  - Player class will be initialized with the username and other default values, such as initial money, warehouse capacity and land. The player and the store will start at level 1.
  
- Player can use seeds and tools given at beginning to plant on the land. The LandEntity class will monitor how much lands are available.
  - WarehouseManager will deduct the used seed from WareHouse class
  - LandManager will update the states of the land
  - PlayerManager will update the experience of the Player
  
- After the plant is planted, player can use the fertilizer given at beginning to make the plants grow faster.
  - When player use the fertilizer, the states of land will be updated, the grow time of the plant will be decreased, and the used fertilizer will be deducted from the Warehouse. All the above actions can be done through each classes’ manager
  
- Once the plant is grown, player can harvest the plant.
  - WarehouseManage will added the harvested plant to the Warehouse inventory.
  - LandManager will update the states of the land to empty.
  - PlayerManager will increase the experience of the player according to the experience gained from harvesting the plant


