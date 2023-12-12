const { ApolloServer, gql } = require("apollo-server");
const jwt = require("jsonwebtoken");
const secretKey = "saicharan149";

const options = {
  expiresIn: "1h" 
};
const mockUser = {
  id: "1",
  username: "saicharan",
  password: "password"
};


const typeDefs = gql`
  type Query {
    me: User
  }
  type User {
    id: ID
    username: String
  }
  type Mutation {
    login(username: String!, password: String!): String
  }

`;

const resolvers = {
  Query: {
    me: (parent, args, context) => {
      // Retrieve the user information from the context
      return context.user;
    },
  },
  Mutation: {
    login: async (parent, { username, password }) => {
      
     
      const hashedPassword = mockUser.password;
      
    
      if (password == hashedPassword) {
        
        const token = jwt.sign({ user: mockUser }, secretKey,options);
        // console.log(token)
        return token;
      } else {
        throw new Error("Invalid username or password");
      }
    },
    
  },
};

const server = new ApolloServer({
  typeDefs,
  resolvers,
  context: ({ req }) => {
    
    const authHeader = req.headers.authorization;
  
     
    if (authHeader) {
      const token = authHeader.split(" ")[1];
  
      try {
        const decodedToken = jwt.verify(token, secretKey);
        console.log(decodedToken)
        // console.log("hello")
        const user = decodedToken.user;
  
        return { user };
      } catch (error) {
        console.error("Error verifying JWT token:", error);
      }
    }
  
    return {};
  },
  
});

server.listen().then(({ url }) => {
  console.log("server is ready at " + url);
});