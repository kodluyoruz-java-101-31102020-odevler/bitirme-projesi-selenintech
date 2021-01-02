import axios from "axios";
import {Axios} from "./axios"

export default class AuthorService{

    getAll(){
         return Axios.get("/authors");
    }

    save(author){
        return Axios.post("/authors",author);
    }

    get(authorId){
        return Axios.get(`/authors/${authorId}`)
    }
}