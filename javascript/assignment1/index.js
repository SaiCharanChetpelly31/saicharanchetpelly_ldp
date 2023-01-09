//task1
function sendMessage(message) {
    document.getElementById("demo").innerHTML = message;
  }

  function getMessage(sendMessage) {
    const message = "This is saicharan";

    return sendMessage(message);
  }

  getMessage(sendMessage);

  //task2
  const getInitials = (firstName, lastName) => firstName[0] + lastName[0];
  console.log(getInitials("Sai", "Charan"));