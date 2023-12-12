import React, { ReactNode, useState } from "react";
import useGetTweets from "../Hooks/useGetTweets";
import logo from "../images/tlogo.jpeg";
import verify from "../images/verify.png";
import green from "../images/greenDot.png";
import gray from "../images/grayDot.png";
import sum from "../images/sum.jpeg";
import deleteIcon from "../images/delete.png";
import Twitl from "../images/twitl.png";
import "./Tweets.css";
import { Button, InputBase, Link } from "@mui/material";
import { gql, useMutation } from "@apollo/client";
import Create from "./CreateTweet";


const READ_TWEET = gql`
  mutation MarkTweetRead($markTweetReadId: ID!) {
    markTweetRead(id: $markTweetReadId)
  }
`;

const DEL_TWEET = gql`
  mutation Mutation($deleteTweetId: ID!) {
    deleteTweet(id: $deleteTweetId)
  }
`;

function Tweets() {
  const { error, loading, data } = useGetTweets();

  const [idVal, setIdVal] = useState<string>();
  const [readOrNot, { data: data1, loading: loading1, error: error1 }] =
    useMutation(READ_TWEET, {
      variables: {
        markTweetReadId: idVal,
      },
    });

  const[deleteTweet,  { data: data2, loading: loading2, error: error2 }] =
  useMutation(DEL_TWEET,{
    variables:{
        deleteTweetId: idVal,
    },
  })

  if (loading) return <h1>Loading...</h1>;

  if (error) return <h2>{error.message}</h2>
  return (
    <div>
      <div className="Tweetcontain">
        <h1>Tweets</h1>
        <Button
          style={{
            textTransform: "none",
            color: "black",
            backgroundColor: "lightgrey",
            marginRight: "30px",
            height: "30px",
            marginTop: "20px",
          }}
          startIcon={
            <img src={Twitl} alt="verify" height={"20px"} width={"20px"} />
          }
        >
          Follow @twitterapi
        </Button>
      </div>
      {data.AllTweets.map(
        (
          tweet: {
            body: ReactNode;
            id: string;
            read: boolean;
            tweetUser: {
              username: string;
              name: string;
            };
            tweetStat: {
              views: string | number;
            };
          },
          key: any
        ) => (
          <div className="contain" key={key}>
            <div className="profile">
              <img src={logo} alt="twitter" height={"80px"} width={"80px"} />
            </div>
            <div style={{ width: "100%" }}>
              <div
                className="topcontain"
                onClick={async () => {
                  await setIdVal(tweet.id);
                  await readOrNot();
                  window.location.reload();
                }}
              >
                <div className="topcontainleft">
                  {tweet.tweetUser?.username}{" "}
                  <img
                    src={verify}
                    alt="verify"
                    height={"15px"}
                    width={"15px"}
                  />{" "}
                  @{tweet.tweetUser?.name}
                  {tweet.read ? (
                    <img
                      src={green}
                      alt="verify"
                      height={"24px"}
                      width={"24px"}
                    />
                  ) : (
                    <img
                      src={gray}
                      alt="verify"
                      height={"24px"}
                      width={"24px"}
                    />
                  )}
                </div>
              </div>
              <div className="bodycontain">
                {tweet.body}
                <div>
                  <Button
                    startIcon={
                      <img
                        src={sum}
                        alt="verify"
                        height={"25px"}
                        width={"25px"}
                      />
                    }
                  >
                    Show Summary
                  </Button>
                  <Button 
                  startIcon={<img src={deleteIcon} alt="icon"/>}
                  onClick={async () => {
                  await setIdVal(tweet.id);
                  await deleteTweet();
                  window.location.reload();
                }}>
                    deleteTweet
                  </Button>
                </div>
              </div>
            </div>
          </div>
        )
      )}
      <div style={{ width: "82%", backgroundColor: "lightgray" }}>
        <Create/>
      </div>
    </div>
  );
}

export default Tweets;
