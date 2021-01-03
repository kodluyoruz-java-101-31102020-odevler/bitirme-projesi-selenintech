<template>
  <div class="container">
   <book-save class="component-top-space" @save="saveBook"/>
   <book-search class="component-top-space" @search="searchBooks"/>
   <book-list class="component-top-space" :books="books"/>
   </div>
</template>

<script>
// @ is an alias to /src
import BookList from "@/components/book/BookList.vue"
import BookSave from "@/components/book/BookSave.vue"
import BookSearch from "@/components/book/BookSearch.vue"
import BookService from "@/service/bookService.js"

var bookService =  new BookService()

export default {
  name: 'Home',
  components: 
   {
    BookList,
    BookSave,
    BookSearch,
    },
    data() {
        return {
            books:[],
        }
    },
    created() {
        this.getAllBooks()
    },
    methods: {
        getAllBooks(){
            bookService.getAll()
            .then(response => {
                this.books = response.data.books
            })
        },
        searchBooks(bookName){
            if(bookName == null || bookName.length == 0){
                this.getAllBooks()
                return
            }
            bookService.search(bookName)
            .then(response => {
                this.books = response.data.books
            })
        },
        saveBook(book){
            bookService.save(book)
            .then(() => {
                this.getAllBooks()
            })
        }
    },
}
</script>
<style lang="css">
    .component-top-space{
        padding-top: 20px;
    }
    
</style>

