# Dropwizard Tic-Tac-Toe API
### Mike Racine

### How to run
java -jar target/tictactoe-0.0.1-SNAPSHOT.jar server config.yml

# API
### Create a new game of Tic-Tac-Toe
curl -X "POST" "http://localhost:8080/tictactoe"

### Join a game of Tic-Tac-Toe (replace gameId with the number of the game you want to join"
curl -X "POST" "http://localhost:8080/tictactoe/{gameId}"

### Make a move in a game of Tic-Tac-Toe
### Example below is placing piece "X" at location (0,0) in game 22
curl -X "POST" "http://localhost:8080/tictactoe/22/makeMove"
     -H "Content-Type: application/json"
     -d '{"piece":"X",
          "coordinate":{"x":0,"y":0}}'

### Note: On Windows platforms, replace the single quotations with 
### double quotations and all double quotations in the data with \"
curl -X "POST" "http://localhost:8080/tictactoe/22/makeMove"
     -H "Content-Type: application/json"
     -d "{\"piece\":\"X\",
          \"coordinate\":{\"x\":0,\"y\":0}}"

### Close a game of Tic-Tac-Toe
curl -X "POST "http://localhost:8080/tictactoe/{gameId}/close"

### Get a list of the ids of available games to play
curl -X "GET" "http://localhost:8080/tictactoe/getGameIds"

### Get a list of moves made in a certain game of Tic-Tac-Toe
curl -X "GET" "http://localhost:8080/tictactoe/{gameId}/getMoves"
