var db = connect('127.0.0.1:27017/thedatabase');

print('----------- The Database created! ----------');

db.createCollection("users");
db.users.save({ _id: ObjectId(), name: "User 1", email: "user1@gmail.com"});
db.users.save({ _id: ObjectId(), name: "User 2", email: "user2@gmail.com"});
db.users.save({ _id: ObjectId(), name: "User 3", email: "user3@gmail.com"});
db.users.save({ _id: ObjectId(), name: "User 4", email: "user4@gmail.com"});
db.users.save({ _id: ObjectId(), name: "User 5", email: "user5@gmail.com"});
db.users.save({ _id: ObjectId(), name: "User 6", email: "user6@gmail.com"});

db.createUser({user: "user", pwd: "user123", roles: [{ role: "readWrite", db: "thedatabase" }]});