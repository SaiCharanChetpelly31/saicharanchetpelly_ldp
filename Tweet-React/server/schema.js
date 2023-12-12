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
   deleteTweet(id: ID!): Boolean
   markTweetRead(id: ID!): Boolean
}

  type Tweet {
   id: ID
   body: String
   read:Boolean
   authorId:ID
   statsId:ID
   tweetUser: User
   tweetStat: Stat
  }

  type User {
   username: String!
   name: String!
  }

  type Stat {
   views: Int
   likes: Int
  }

  type Notification {
   id: ID
   type: String
  }

  type Meta {
   count: Int
  }
`;
