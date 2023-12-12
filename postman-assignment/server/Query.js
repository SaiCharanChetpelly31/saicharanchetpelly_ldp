
const axios = require('axios');

const REST_API_URL = 'https://api.coinstats.app/public/v1/coins';

exports.Query= {
    coins: async (_, { skip, limit, currency }) => {
      try {
        const response = await axios.get(REST_API_URL, {
          params: {
            skip,
            limit,
            currency,
          },
        });
        
        const coinsData = response.data.coins;
        
        const coins = coinsData.map((coin) => ({
          icon: coin.icon,
          id: coin.id,
          name:coin.name,
          symbol:coin.symbol,
          rank: coin.rank,
          price: coin.price,
          priceBtc: coin.priceBtc,
          volume: coin.volume,
          marketCap:coin.marketCap,
          availableSupply: coin.availableSupply,
          totalSupply: coin.totalSupply,
          priceChange1h: coin.priceChange1h,
          priceChange1d: coin.priceChange1d,
          priceChange1w: coin.priceChange1w,
          websiteUrl: coin.websiteUrl,
          redditUrl: coin.redditUrl,
          twitterUrl: coin.twitterUrl,
          exp: coin.exp
        }));

        return coins;
      } catch (error) {
        throw new Error('Failed to fetch coins.');
      }
    },
    news: async (_, { skip, limit }) => {
      try {
        const response = await axios.get('https://api.coinstats.app/public/v1/news', {
          params: {
            skip,
            limit,
          },
        });
        
        const newsData = response.data.news;
        
        const news = newsData.map((coin) => ({
          id: coin.id,
          feedDate: coin.feedDate,
          source: coin.source,
          title: coin.title,
          isFeatured: coin.isFeatured,
          description: coin.description,
          imgURL: coin.imgURL,
          link: coin.link,
          sourceLink: coin.sourceLink,
          shareURL: coin.shareURL,
          relatedCoins:coin.relatedCoins
        }));

        return news;
      } catch (error) {
        throw new Error('Failed to fetch news.');
      }
    },
    exchanges: async () => {
      try {
        const response = await axios.get("https://api.coinstats.app/public/v1/exchanges");
        const exchangesData = response.data.supportedExchanges;
        return exchangesData;
      } catch (error) {
        throw new Error('Failed to fetch exchanges.');
      }
    },
    markets:async()=> {
      try{
        const response = await axios.get("https://api.coinstats.app/public/v1/markets?coinId=bitcoin");
        const marketsData = response.data;
        return marketsData;
      }
      catch (error) {
        throw new Error('Failed to fetch markets.');
      }
    },
    tickers:async()=>{
      try{
        const response = await axios.get("https://api.coinstats.app/public/v1/tickers?exchange=yobit&pair=BTC-USD");
        const tickersData = response.data.tickers;
        return tickersData;
      }
      catch (error) {
        throw new Error('Failed to fetch tickers.');
      }
    },
    flats: async () => {
      try {
        const response = await axios.get("https://api.coinstats.app/public/v1/fiats");
        const flatsData = response.data;
        return flatsData;
      } catch (error) {
        throw new Error('Failed to fetch exchanges.');
      }
    },
};

