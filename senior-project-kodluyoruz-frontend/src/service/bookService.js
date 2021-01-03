import {Axios} from "./axios"



export default class BookService{

    save(book){
        return Axios.post("/books", book)
    }

    get(bookId){
        return Axios.get(`/books/${bookId}`)
    }

    getAll(){
        return Axios.get("/books")
    }

    search(bookName){
        return Axios.get(`/books/search?name=${bookName}`)
    }
}