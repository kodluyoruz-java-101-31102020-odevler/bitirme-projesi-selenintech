<template>
  <div>
      <div v-if="isNotFound">
          <h4>Book Not Found</h4>

      </div>
   <book-detail v-if="isLoaded" :book-detail="bookDetail"/>

   
  </div>
</template>
<script>

import BookService from "@/service/bookService.js"
import BookDetail from "@/components/book/BookDetail.vue"
var bookService = new BookService()


export default {
  components:{
      BookDetail,
  },
  data() {
    return {
      isNotFound: false,
      isLoaded: false,
      bookDetail: {
        id: 0,
        name: "",
        publicationDate: "",
        description: "",
        authors: [],
      },
    };
  },
  created() {
      this.loadBookDetail()
  },
  methods: {
      
      loadBookDetail(){
          let bookId = this.$route.params.bookId
          bookService.get(bookId)
          .then(response => {
              if(response.status != 200){
                  this.isNotFound = true
                  return
              }
              this.bookDetail = response.data
              this.isLoaded =  true

          })
          .catch(()=>{
              this.isNotFound = true
          })
        

      }
  },
};
</script>