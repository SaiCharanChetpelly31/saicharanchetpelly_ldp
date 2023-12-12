const { gql } = require("apollo-server");

exports.typeDefs = gql`
  type Query {
   Tweet(id: ID!): Tweet
   Tweets(limit: Int, skip: Int, sort_field: String, sort_order: String): [Tweet]
   AllTweets:[Tweet]
   TweetsMeta: Meta
   User(id: ID!): User
   Notifications(limit: Int): [Notification]
   NotificationsMeta: Meta
}

type Mutation {
   createTweet (
       body: String!
   ): Tweet
   deleteTweet(id: ID!): Tweet
   markTweetRead(id: ID!): Boolean
}

  type Tweet {
   id: ID!
   body: String
   date: String
   author: User
   stats: Stat
  }

  type User {
   id: ID!
   username: String
   first_name: String
   last_name: String
   full_name: String
   name: String
   avatar_url: String
  }

  type Stat {
   views: Int
   likes: Int
   retweets: Int
   responses: Int
  }

  type Notification {
   id: ID
   date: String
   type: String
  }

  type Meta {
   count: Int
  }
`;
