<template>
  <div>
    <div v-if="isNotFound">
      <h4>Author is not found!</h4>
    </div>
    <div v-if="isLoaded">
      <div>
        <h4>{{ authorName }}</h4>
      </div>
      <div>
        <book-list :books="books" />
      </div>
    </div>
  </div>
</template>



<script>
import BookList from "@/components/book/BookList.vue";
import AuthorService from "@/service/authorService.js"

var authorService =  new AuthorService()


export default {

  components: {
    BookList,
  },
  data() {
    return {
      books: [],
      authorName: "",
      isLoaded: false,
      isNotFound: false,
    };
  },
  created() {
      this.loadAuthor()
  },
  methods: {
      loadAuthor(){
          let authorId = this.$route.params.authorId
          authorService.get(authorId)
          .then(response => {
                if(response.status != 200){
                  this.isNotFound = true
                  return
                }
                this.authorName = response.data.author.name 
                this.books = response.data.books
                this.isLoaded = true
         })
         .catch(() => {
             this.isNotFound = true
            })
      }
  },
};
</script>