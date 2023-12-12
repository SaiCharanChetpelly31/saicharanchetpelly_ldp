const tweets = [
  {
    id: "1",
    body: "We have updated our Player Cards guidelines. Quick overview and discussion in our developer forums:",
    read:false,
    authorId:101,
    statsId:101,
    tweetUser: {
      username: "saicharan31",
      name: "saicharan chetpelly",
    },
    tweetStat: {
      views: 2,
      likes: 2,
    },
  },
  {
    id: "2",
    body: "This is my second tweet",
    read:false,
    authorId:102,
    statsId:102,
    tweetUser: {
      username: "sainikhil14",
      name: "sainikhil chetpelly",
    },
    tweetStat: {
      views: 2,
      likes: 2,
    },
  },
];

exports.db = {
  tweets
};
