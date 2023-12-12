
import { useQuery, gql } from "@apollo/client";

const GET_TWEETS=gql`
    query{
        AllTweets{
            id
            body 
            read 
            authorId
            statsId 
            tweetUser{
                username
                name
            }
            tweetStat{
                views
                likes
            }
        }
    }
`;

function useGetTweets(){
    const {error, loading, data}=useQuery(GET_TWEETS);

    return({
        error,
        loading,
        data
    })
}

export default useGetTweets;