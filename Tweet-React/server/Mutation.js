const { v4: uuid } = require("uuid");

exports.Mutation = {
  createTweet: (parent, { body }, { db }) => {
    const newTweet = {
      id: uuid(),
      body,
      read: false,
      authorId: uuid(),
      statsId: uuid(),
      tweetUser: {
        username: "saicharan31",
        name: "saicharan chetpelly",
      },
      tweetStat: {
        views: 0,
        likes: 0,
      },
    };
    db.tweets.push(newTweet);
    return newTweet;
  },
  markTweetRead: (parent, { id }, { db }) => {
    const index = db.tweets.findIndex((tweet) => tweet.id === id);
    if (index === -1) return false;
    db.tweets[index] = {
      ...db.tweets[index],
      read: true,
    };
    return true;
  },
  deleteTweet: (parent, { id }, { db }) => {
    db.tweets = db.tweets.filter((tweet) => tweet.id !== id);
    return true;
  },
};
