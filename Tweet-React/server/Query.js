exports.Query = {
    Tweet: (parent, { id }, { db }) => {
        return db.tweets.find((tweet) => tweet.id === id);
    },
    Tweets:(parent,{limit,skip,sort_field,sort_order},{db})=>{
        return db.tweets.slice(skip,skip+limit);
    },
    AllTweets:(parent,args,{db})=>{
        return db.tweets;
    }
};