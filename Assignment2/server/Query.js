
const axios = require('axios');

exports.Query= {
  AllTweets: async () => {
    const response = await axios.get('http://localhost:3001/tweets');
    return response.data;
  },
  Tweet: async (_, { id }) => {
    const response = await axios.get(`http://localhost:3001/tweets/${id}`);
    return response.data;
  },
  Tweets: async (_, { limit, skip, sort_field, sort_order }) => {
    let url = `http://localhost:3001/tweets?_limit=${limit}&_start=${skip}`;
    if (sort_field && sort_order) {
      url += `&_sort=${sort_field}&_order=${sort_order}`;
    }
    const response = await axios.get(url);
    return response.data;
  },
  TweetsMeta: async () => {
    const response = await axios.get('http://localhost:3001/tweets');
    return { count: response.data.length };
  },
  User: async (_, { id }) => {
    const response = await axios.get(`http://localhost:3001/users/${id}`);
    return response.data;
  },
  Notifications: async (_, { limit }) => {
    const url = limit ? `http://localhost:3001/notifications?_limit=${limit}` : 'http://localhost:3001/notifications';
    const response = await axios.get(url);
    return response.data;
  },
  NotificationsMeta: async () => {
    const response = await axios.get('http://localhost:3001/notifications');
    return { count: response.data.length };
  },
};

