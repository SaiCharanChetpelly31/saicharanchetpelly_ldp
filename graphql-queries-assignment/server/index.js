const { ApolloServer } = require("apollo-server");
const { typeDefs } = require("./schema");
const { db } = require("./db");
const { Query } = require("./Query");
const { Mutation } = require("./Mutation");


const server = new ApolloServer({
  typeDefs,
  resolvers: {
    Query,
    Mutation
  },
  context: {
    db,
  },
});

server.listen().then(({ url }) => {
  console.log("Server is up at " + url);
});
