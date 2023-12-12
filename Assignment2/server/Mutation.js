const axios = require("axios");

exports.Mutation = {
  createTweet: async (_, { body }) => {
    const response = await axios.post("http://localhost:3001/tweets", { body });
    return response.data;
  },
  deleteTweet: async (_, { id }) => {
    const response = await axios.delete(`http://localhost:3001/tweets/${id}`);
    return response.status === 200;
  },
  markTweetRead: async (_, { id }) => {
    const response = await axios.patch(`http://localhost:3001/tweets/${id}`, {
      read: true,
    });
    return response.status === 200;
  },
};
