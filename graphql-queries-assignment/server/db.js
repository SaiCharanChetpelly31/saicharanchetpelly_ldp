const tweets = [
  {
    id: "1",
    body: "This is my first tweet",
    date: "31/10/2001",
    author: {
      id: "1",
      username: "saicharan31",
      first_name: "saicharan",
      last_name: "chetpelly",
      full_name: "saicharan chetpelly",
      name: "saicharan",
      avatar_url: "img1.png",
    },
    stats: {
      views: 2,
      likes: 2,
      retweets: 3,
      responses: 4,
    },
  },
  {
    id: "2",
    body: "This is my second tweet",
    date: "14/07/2003",
    author: {
      id: "2",
      username: "sainikhil14",
      first_name: "sainikhil",
      last_name: "chetpelly",
      full_name: "sainikhil chetpelly",
      name: "sainikhil",
      avatar_url: "img2.png",
    },
    stats: {
      views: 2,
      likes: 2,
      retweets: 3,
      responses: 4,
    },
  },
];

exports.db = {
  tweets
};
