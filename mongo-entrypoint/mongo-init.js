
db = db.getSiblingDB('iot_data'); 

db.house.insertOne({
    "unixTime": 0,
    
    "watValue": 0,
    "workLoad": 0,
    "plugId": 0,
    "houseHoldId": 1,
    "houseId": 0});

db.censor.insertOne({
    "id": "99",
    "name": 99,
    "status": "on",
     "have_turn_on":"no"});

db.createUser(
    {
        user: "iotUser",
        pwd: "Ahihi123",
        roles: [ { role: "readWrite", db: "iot_data"} ],
    }
);

