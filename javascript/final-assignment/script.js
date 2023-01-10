const userCardTemplate = document.querySelector(".data-user-card");
const userCardContainer = document.querySelector("[data-user-cards-container]");
const searchInput = document.querySelector("[data-search]");

var items = [];
var draggables;
var itemName = " "
var itemPrice = 0
var tableID = " "
var itemId = 0

const arr = ["Table1","Table2","Table3"]

var table1Array = []
var table2Array = []
var table3Array = []

const totalAmounts = [0, 0, 0]
const totalRupees = [0, 0, 0]

fetch("data.json")
  .then((res) => res.json())
  .then((data) => {
    items = data.map((item) => {
      const card = userCardTemplate.content.cloneNode(true).children[0];
      const heading = card.querySelector("[data-title]");
      const price = card.querySelector("[data-price]");
      const id = card.querySelector("[data-id]")
      heading.textContent = item.heading;
      price.textContent = item.price;
      id.textContent = item.id
      userCardContainer.append(card);
      //functioncall for drag and drop
      setTimeout(dragdrop(card), 4000)
      return {
        heading: item.heading,
        price: item.price,
        category: item.category,
        id: item.id,
        element: card,
      };
    });
  });

searchInput.addEventListener("input", (e) => {
  const value = e.target.value.toLowerCase();
  items.forEach((item) => {
    let isVisible =
      item.heading.toLowerCase().includes(value) ||
      item.category.toLowerCase().includes(value);
    item.element.classList.toggle("hide", !isVisible);
  });
});

const dragdrop = (card) => {
  draggables = document.querySelectorAll(".card");
  const containers = document.querySelectorAll(".table");
  draggables.forEach((draggable) => {
    draggable.addEventListener("dragstart", () => {
      draggable.classList.add("active");
    });

    draggable.addEventListener("dragend", () => {
      draggable.classList.remove("active");
    });
  });
  containers.forEach((container) => {
    container.addEventListener('dragover', (e) => {
      e.preventDefault();

    })

    container.addEventListener("drop", (e) => {

      //console.log("dropped")
      const draggable = document.querySelector(".active");
      tableID = container.getAttribute("id")

      //  draggable.className.includes("active")
      //container.append(draggable);
      const parent = document.querySelector(".container")
      const allChilds = Array.from(parent.children)
      // const billTable = allChilds[2]

      const childs = Array.from(draggable.children)
      var title = childs[0]
      var price = childs[1]
      var id = childs[2]
      itemName = title.textContent
      itemPrice = price.textContent
      itemId = id.textContent
      // console.log(itemId)

      //container.removeEventListener("drop")
      updateObjects(tableID, itemName, itemPrice, itemId)


      e.stopImmediatePropagation()

    })
  });
};


const tableSearch = document.querySelector(".search-table-input")
tableSearch.addEventListener("input", (e) => {
  const value = e.target.value.toLowerCase();
  for(let i=0;i<arr.length;i++){
    const table1 = document.getElementById("tableID1")
    const table2 = document.getElementById("tableID2")
    const table3 = document.getElementById("tableID3")
    const isPresent1 = arr[0].toLowerCase().includes(value)
    const isPresent2 = arr[1].toLowerCase().includes(value)
    const isPresent3 = arr[2].toLowerCase().includes(value)
    
    table1.classList.toggle("hide", !isPresent1);
    table2.classList.toggle("hide", !isPresent2);
    table3.classList.toggle("hide", !isPresent3);

  }
});


const showBilling = (tableId) => {
  if (tableId === 1) {
    const showTable = document.querySelector("#table-1")
    showTable.style.display = "inline"
  } else if (tableId === 2) {
    const showTable = document.querySelector("#table-2")
    showTable.style.display = "inline"
  } else {
    const showTable = document.querySelector("#table-3")
    showTable.style.display = "inline"
  }
}

const updateObjects = (tableId, itemName, price, id) => {
  if (tableId == "tableID1") {
    let isPresent = findDuplicate(id, 1)
    if (!isPresent) {
      table1Array.push({
        id: id,
        title: itemName,
        price: price,
        quantity: 1,
        total: price
      })
    }

  } else if (tableId == "tableID2") {
    let isPresent = findDuplicate(id, 2)
    if (!isPresent) {
      table2Array.push({
        id: id,
        title: itemName,
        price: price,
        quantity: 1,
        total: price
      })
    }
  } else {
    let isPresent = findDuplicate(id, 3)
    if (!isPresent) {
      table3Array.push({
        id: id,
        title: itemName,
        price: price,
        quantity: 1,
        total: price
      })
    }
  }
}
console.log(table1Array)
console.log(table2Array)

console.log(table3Array)

const findDuplicate = (id, tableNum) => {
  if (tableNum == 1) {
    for (const element of table1Array) {
      if (element.id == id) {
        let tempQuantity = element.quantity;
        element.quantity = Number(tempQuantity) + 1;
        element.total = element.price * element.quantity;
        return true;
      }
    }
    return false;
  } else if (tableNum == 2) {
    for (const element of table2Array) {
      if (element.id == id) {
        let tempQuantity = element.quantity;
        element.quantity = Number(tempQuantity) + 1;
        element.total = element.price * element.quantity;
        return true;
      }
    }
    return false;
  } else {
    for (const element of table3Array) {
      if (element.id == id) {
        let tempQuantity = element.quantity;
        element.quantity = Number(tempQuantity) + 1;
        element.total = element.price * element.quantity;
        return true;
      }
    }
    return false;
  }
}



const buildTable = (data, tablename) => {
  if (tablename == "firstTable") {
    var table = document.getElementById("firstTable")

    var rowCount = table.rows.length;
    for (var i = rowCount - 1; i > 0; i--) {
      table.deleteRow(i);
    }

    for (var i = 0; i < data.length; i++) {
      console.log("entereted for loop")
      var row = `<tr>
                      <td>${i + 1}</td>
                      <td class="hide" >${data[i].id}</td>
                      <td>${data[i].title}</td>
                      <td>${data[i].price}</td>
                      <td>
                        <input type="number" value="${data[i].quantity}" min="1" onchange="changeQty('${data[i].id}','${tablename}',this.value)" />
                      </td>
                      <td>${data[i].total}</td>
                      <td>
                        <i class="fa fa-trash" aria-hidden="true" id="delete" onclick="deleteItem('${data[i].id}','${tablename}')"></i>
                      </td>
                 </tr>`


      table.innerHTML += row
    }
  } else if (tablename == "secondTable") {
    var table = document.getElementById("secondTable")

    var rowCount = table.rows.length;
    for (var i = rowCount - 1; i > 0; i--) {
      table.deleteRow(i);
    }

    for (var i = 0; i < data.length; i++) {
      console.log("entereted for loop")
      var row = `<tr>
                      <td>${i + 1}</td>
                      <td class="hide">${data[i].id}</td>
                      <td>${data[i].title}</td>
                      <td>${data[i].price}</td>
                      <td>
                        <input type="number" value="${data[i].quantity}" min="1" onchange="changeQty('${data[i].id}','${tablename}',this.value)" />
                      </td>
                      <td>${data[i].total}</td>
                      <td>
                      <i class="fa fa-trash" aria-hidden="true" id="delete" onclick="deleteItem('${data[i].id}','${tablename}')"></i>

                      </td>

  
                 </tr>`


      table.innerHTML += row
    }
  } else {
    var table = document.getElementById("thirdTable")

    var rowCount = table.rows.length;
    for (var i = rowCount - 1; i > 0; i--) {
      table.deleteRow(i);
    }

    for (var i = 0; i < data.length; i++) {

      var row = `<tr>
                      <td>${i + 1}</td>
                      <td class="hide" >${data[i].id}</td>
                      <td>${data[i].title}</td>
                      <td>${data[i].price}</td>
                      <td>
                        <input type="number" value="${data[i].quantity}" min="1" onchange="changeQty('${data[i].id}','${tablename}',this.value)" />
                      </td>
                      <td>${data[i].total}</td>
                      <td>
                      <i class="fa fa-trash" aria-hidden="true" id="delete" onclick="deleteItem('${data[i].id}','${tablename}')"></i>

                      </td>

  
                 </tr>`


      table.innerHTML += row
    }
  }

}

function changeQty(id,tableNam,val) {
  if(val <= 0){
    deleteItem(id,tableNam)
  }else if(tableNam == "firstTable"){
    for (const element of table1Array) {
      if(element.id == id){
        element.quantity = val;
        element.total = element.price * element.quantity;
      }
    }

    var table = document.getElementById("firstTable")
    var rows = table.rows;

    for(let i=1;i<rows.length;i++){
      var cols = rows[i].cells
      console.log(cols[1].textContent)
      if(cols[1].textContent == id){
        cols[5].textContent = Number(cols[3].textContent) * Number(val)
      }
    }
  }else if(tableNam == "secondTable"){
    for (const element of table2Array) {
      if(element.id == id){
        element.quantity = val;
        element.total = element.price * element.quantity;
      }
    }

    var table = document.getElementById("secondTable")
    var rows = table.rows;

    for(let i=1;i<rows.length;i++){
      var cols = rows[i].cells
      console.log(cols[1].textContent)
      if(cols[1].textContent == id){
        cols[5].textContent = Number(cols[3].textContent) * Number(val)
      }
    }
  }else{
    for (const element of table3Array) {
      if(element.id == id){
        element.quantity = val;
        element.total = element.price * element.quantity;
      }
    }

    var table = document.getElementById("thirdTable")
    var rows = table.rows;

    for(let i=1;i<rows.length;i++){
      var cols = rows[i].cells
      console.log(cols[1].textContent)
      if(cols[1].textContent == id){
        cols[5].textContent = Number(cols[3].textContent) * Number(val)
      }
    }
  }
}


const deleteItem = (id,tableNam) => {
  if(tableNam == "firstTable"){
        let tempArray = table1Array.filter(ele => ele.id!=id)
        console.log(tempArray)
        table1Array = tempArray
        buildTable(table1Array,"firstTable")
        modalsfn()
  }else if(tableNam == "secondTable"){
    let tempArray = table2Array.filter(ele => ele.id!=id)
        table2Array = tempArray
        buildTable(table2Array,"secondTable")
        modalsfn()
  }else{
    for (const element of table3Array) {
      if(element.id == id){
        let tempArray = table3Array.filter(ele => ele.id!=id)
        table3Array = tempArray
        buildTable(table3Array,"thirdTable")
        modalsfn()
      }
    }
  }
}
//javascrioot for popup
const modalsfn = ()=> {
  const openModalButtons = document.querySelectorAll('[data-modal-target]')
const closeModalButtons = document.querySelectorAll('[data-close-button]')
const overlay = document.getElementById('overlay')

openModalButtons.forEach(button => {
  button.addEventListener('click', () => {
    const modal = document.querySelector(button.dataset.modalTarget)
    openModal(modal)
  })
})

overlay.addEventListener('click', () => {
  const modals = document.querySelectorAll('.modal.active')
  modals.forEach(modal => {
    closeModal(modal)
  })
})

closeModalButtons.forEach(button => {
  button.addEventListener('click', () => {
    const modal = button.closest('.modal')
    closeModal(modal)
  })
})

function openModal(modal) {
  if (modal == null) return
  modal.classList.add('active')
  overlay.classList.add('active')
}

function closeModal(modal) {
  if (modal == null) return
  modal.classList.remove('active')
  overlay.classList.remove('active')
}
}
modalsfn()

var btn = document.getElementById("tableID1")
btn.addEventListener("click", () => {
  buildTable(table1Array, "firstTable")
  showBilling(1)
})
var btn = document.getElementById("tableID2")
btn.addEventListener("click", () => {
  buildTable(table2Array, "secondTable")
  showBilling(2)
})
var btn = document.getElementById("tableID3")
btn.addEventListener("click", () => {
  buildTable(table3Array, "thirdTable")
  showBilling(3)
})




const calculateTotalRupees = (table, id) => {
  var sum = 0
  for (const element of table) {
    sum += Number(element.total)
  }
  totalRupees[id] = sum
}

const calculateTotalItems = (table, id) => {
  var sum = 0
  for (const element of table) {
    sum += Number(element.quantity)
  }
  totalAmounts[id] = sum
}

const billBtn1 = document.querySelector(".bill-btn1")
billBtn1.addEventListener("click",()=>{
  alert("Your total Bill Amount is "+totalRupees[0])
})
const billBtn2 = document.querySelector(".bill-btn2")
billBtn2.addEventListener("click",()=>{
  alert("Your total Bill Amount is "+totalRupees[1])
})
const billBtn3 = document.querySelector(".bill-btn3")
billBtn3.addEventListener("click",()=>{
  alert("Your total Bill Amount is "+totalRupees[2])
})

var intervalId = window.setInterval(function () {
  calculateTotalRupees(table1Array, 0)
  calculateTotalRupees(table2Array, 1)
  calculateTotalRupees(table3Array, 2)

  calculateTotalItems(table1Array, 0)
  calculateTotalItems(table2Array, 1)
  calculateTotalItems(table3Array, 2)


  document.querySelector(".total-amount1").textContent = `Rs: ${totalRupees[0]}`
  document.querySelector(".total-amount2").textContent = `Rs: ${totalRupees[1]}`
  document.querySelector(".total-amount3").textContent = `Rs: ${totalRupees[2]}`
  document.querySelector(".total-amount6").textContent = `Rs: ${totalRupees[2]}`
  document.querySelector(".total-amount5").textContent = `Rs: ${totalRupees[1]}`
  document.querySelector(".total-amount4").textContent = `Rs: ${totalRupees[0]}`




  document.querySelector(".total-items1").textContent = `Total items: ${totalAmounts[0]}`
  document.querySelector(".total-items2").textContent = `Total items: ${totalAmounts[1]}`
  document.querySelector(".total-items3").textContent = `Total items: ${totalAmounts[2]}`
  document.querySelector(".total-items6").textContent = `Total items: ${totalAmounts[2]}`
  document.querySelector(".total-items5").textContent = `Total items: ${totalAmounts[1]}`
  document.querySelector(".total-items4").textContent = `Total items: ${totalAmounts[0]}`


}, 200);



