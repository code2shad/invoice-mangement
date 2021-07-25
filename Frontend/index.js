const $ = document.querySelector.bind(document)
const $$ = document.querySelectorAll.bind(document)
const $id = document.getElementById.bind(document)
//Dom elements

const backDrop = $(".backDrop")
const addModal = $id("addModal")
const editModal = $id("editModal")
const addModalForm = $id("addModalForm")
const editModalform = $id("editModalForm")
const deleteModal = $id("deleteModal")


function addModalOpen(){
    backDrop.classList.remove("hide")
    addModal.classList.remove("hide")
}

function deleteModalOpen(){
    backDrop.classList.remove("hide")
    deleteModal.classList.remove("hide")
}

function deleteModalClose(){
    backDrop.classList.add("hide")
    deleteModal.classList.add("hide")
}

function editModalOpen(){
    backDrop.classList.remove("hide")
    editModal.classList.remove("hide")
}

function addModalClose(){
    backDrop.classList.add("hide")
    addModal.classList.add("hide")
}

function editModalClose(){
    backDrop.classList.add("hide")
    editModal.classList.add("hide")
}



function handleClick(event){
    const{id}=event.target
    console.log(id)

    if(id==="add"){
        addModalOpen()
    }else if(id==="edit"){
        editModalOpen()
    }else if(id==="delete"){
        deleteModalOpen()
    }
    
}

function handleSearch(event){
    const{name,value} = event.target
    console.log(name +" " +value)
}




//Listeners
$id("add").addEventListener("click",handleClick)
$id("edit").addEventListener("click",handleClick)
$id("delete").addEventListener("click",handleClick)
$id("search").addEventListener("input",handleSearch)
$id("cancelAddModal").addEventListener("click",addModalClose)
$id("clearAddModal").addEventListener("click",()=>{addModalForm.reset()})
$id("submitAddModal").addEventListener("click",handleSearch)
$id("closeModal").addEventListener("click",addModalClose)



$id("cancelEditModal").addEventListener("click",editModalClose)
$id("clearEditModal").addEventListener("click",()=>{editModalform.reset()})
$id("submitEditModal").addEventListener("click",handleSearch)
$id("closeEditModal").addEventListener("click",editModalClose)


$id("clearDeleteModal").addEventListener("click",deleteModalClose)
$id("closeEditModal").addEventListener("click",editModalClose)

$id("closeDeleteModal").addEventListener("click",deleteModalClose)