const { ApolloServer } = require("apollo-server");
const { typeDefs } = require("./schema");
const { Query } = require("./Query");
const { Mutation } = require("./Mutation");

const server = new ApolloServer({
  typeDefs,
  resolvers: {
    Query,
    Mutation
  }
});

server.listen().then(({ url }) => {
  console.log("Server is up at " + url);
});

