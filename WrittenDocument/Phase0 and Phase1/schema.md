Schema of farm game Database

table of the user info, in practical this table will only contain 1 row once the player is created
will be updated during game

Table Player(
    name  TEXT,
    level INT,
    playerExp INT,
    money INT,
    PRIMARY KEY (name)
)

table of plants
will NOT be updated during game

Table Plant(
    id INT,
    plantName TEXT,
    seedName TEXT,
    time INT,
    buyPrice INT,
    sellPrice INT,
    plantExp INT,
    unlockLevel INT,
    PRIMARY KEY (id)
)

table of items
will NOT be updated during game

Table Item(
    id INT,
    name TEXT,
    type TEXT,
    price INT,
    PRIMARY KEY (id)
)

table of plants and items stored in the warehouse
will be updated during game

Table Warehouse(
    id: INT
    type: TEXT,
    quantity INT,
    PRIMARY KEY (id, type)
)

table of levels
will NOT be updated during game

Table Level(
    level INT,
    exp INT,
    capacity INT,
    landMax INT,
    PRIMARY KEY: (level)
)

table of lands
will be updated during game

Table Land(
    index INT,
    price INT,
    lockStatus INT,
    plant INT,
    waterTime INT,
    fertilizeTime INT,
    stage INT,
    PRIMARY KEY (index)
)


