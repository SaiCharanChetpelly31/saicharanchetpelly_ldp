const { Query } = require("./Query");
const { ApolloServer, gql } = require("apollo-server");

const typeDefs = gql`
  type Query {
    coins(skip: Int!, limit: Int!, currency: String!): [Coin!]!
    exchanges:[String!]!
    markets:[Market]
    tickers:[Ticker]
    flats:[Flat]
    news(skip: Int!, limit: Int!):[News!]!
  }
  
  type Market{
    price:Int,
    exchange:String,
    pair:String,
    volume:ID
  }

  type News{
    id: String
    feedDate: ID
    source: String
    title: String
    isFeatured: Boolean
    description: String
    imgURL: String
    link: String
    sourceLink: String
    shareURL: String
    relatedCoins: [String]
  }
  

  type Flat{
    name:String,
    rate:Float,
    symbol:String,
    imageUrl:String
  }

  type Ticker{
    price:Float,
    exchange:String,
    from:String,
    to:String
  }

  type Coin {
    icon: String!
    id: String!
    name: String!
    symbol: String!
    rank: Int!,
    price: Float!
    priceBtc: Float!
    volume: Float!
    marketCap: String!
    availableSupply: ID!
    totalSupply: ID!
    priceChange1h: Float!
    priceChange1d: Float!
    priceChange1w: Float!
    websiteUrl: String!
    redditUrl: String!
    twitterUrl: String!
    exp: [String!]!
  }
`;
const server = new ApolloServer({
    typeDefs,
    resolvers: {
      Query,
    },
  });
  
  server.listen().then(({ url }) => {
    console.log("Server is up at " + url);
  });
  