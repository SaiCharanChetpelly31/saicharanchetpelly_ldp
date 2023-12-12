import { ApolloServer } from "@apollo/server";
import { startStandaloneServer } from "@apollo/server/standalone";
import { GraphQLScalarType, Kind, GraphQLError } from "graphql";

// A schema is a collection of type definitions (hence "typeDefs")
// that together define the "shape" of queries that are executed against
// your data.
const typeDefs = `#graphql
  # Comments in GraphQL strings (such as this one) start with the hash (#) symbol.
  scalar Odd

  # This "Book" type defines the queryable fields for every book in our data source.
  type Book {
    title: String
    author: String
  }

  # The "Query" type is special: it lists all of the available queries that
  # clients can execute, along with the return type for each. In this
  # case, the "books" query returns an array of zero or more Books (defined above).
  type Query {
    books: [Book]
    echoOdd(odd: Odd!): Odd!
    login(input:LoginInput):String
  }

  type User{
    username:String
    password:String
  }

  input LoginInput{
    username:String
    password:String
  }
`;

function oddValue(value: number) {
  if (typeof value === "number" && Number.isInteger(value) && value % 2 !== 0) {
    return value;
  }
  throw new GraphQLError("Provided value is not an odd integer", {
    extensions: { code: "BAD_USER_INPUT" },
  });
}

const books = [
  {
    title: "The Awakening",
    author: "Kate Chopin",
  },
  {
    title: "City of Glass",
    author: "Paul Auster",
  },
];

// Resolvers define how to fetch the types defined in your schema.
// This resolver retrieves books from the "books" array above.

// The ApolloServer constructor requires two parameters: your schema
// definition and your set of resolvers.
const server = new ApolloServer({
  typeDefs,
  resolvers: {
    Odd: new GraphQLScalarType({
      name: "Odd",
      description: "Odd custom scalar type",
      parseValue: oddValue,
      serialize: oddValue,
      parseLiteral(ast) {
        if (ast.kind === Kind.INT) {
          return oddValue(parseInt(ast.value, 10));
        }
        throw new GraphQLError("Provided value is not an odd integer", {
          extensions: { code: "BAD_USER_INPUT" },
        });
      },
    }),
    Query: {
      echoOdd(_, { odd }) {
        return odd;
      },
      books: () => books,
    },
  },
});

// Passing an ApolloServer instance to the `startStandaloneServer` function:
//  1. creates an Express app
//  2. installs your ApolloServer instance as middleware
//  3. prepares your app to handle incoming requests
const { url } = await startStandaloneServer(server, {
  listen: { port: 4003 },
});

console.log(`🚀  Server ready at: ${url}`);
