exports.Query = {
    Tweet: (parent, { id }, { db }) => {
        return db.tweets.find((tweet) => tweet.id === id);
    },
    AllTweets:(parent,args,{db})=>{
        return db.tweets;
    }
};