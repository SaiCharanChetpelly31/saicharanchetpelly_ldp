const { ApolloServer } = require("apollo-server");
import { addMocksToSchema } from "@graphql-tools/mock";
import { makeExecutableSchema } from "@graphql-tools/schema";
const { typeDefs } = require("./schema");
const { Query } = require("./Query");
const { Mutation } = require("./Mutation");
const { createTestClient } = require("apollo-server-testing");

const server = new ApolloServer({
  schema: addMocksToSchema({
    schema: makeExecutableSchema({
      typeDefs,
      resolvers: {
        Query,
        Mutation,
      },
    }),
  }),
});

test("read a list of tweets", async () => {
  const { query } = createTestClient(server);
  const GET_TWEETS = `
  {
    AllTweets {
      body
    }
  }
  `;
  const response = await query({ query: GET_TWEETS });
  expect(response.data.AllTweets).toEqual([
    {
      body: "Hello World",
    },
    {
      body: "Hello World",
    },
  ]);
});
