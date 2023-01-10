let action = (userId) => {
  let mail = userId + "@gmail.com";
  console.log("Fetched email successfully");
  console.log("The emailId is:", mail);
};
var getData = (userId) => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(action(userId));
    }, 4000);
  });
};

async function getEmail() {
  try {
    console.log("start");
    await getData("saicharan");
  } catch (error) {
    console.log("Error in retrieving emailId of user ", error);
  } finally {
    console.log("end");
  }
}
getEmail();
