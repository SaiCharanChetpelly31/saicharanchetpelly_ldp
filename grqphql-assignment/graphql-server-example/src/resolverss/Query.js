exports.Query = {
  hello: (parent, args, context) => "World",
  login: (parent, { input }, { db }) => {
    return db.products.find((product) => product.id === id);
  },
};
