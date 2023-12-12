const { v4: uuid } = require("uuid");

exports.Mutation = {
    createTweet: (parent, { body }, { db }) => {
    const newTweet = {
      id: uuid(),
      body,
    };

    db.tweets.push(newTweet);

    return newTweet;
  },
};
