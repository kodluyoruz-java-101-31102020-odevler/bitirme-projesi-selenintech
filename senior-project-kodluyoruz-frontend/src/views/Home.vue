<template>
  <div class="container">
   <author-save/>
   <author-list/>
   <book-save/>
   <book-list/>
   <book-detail/>
  </div>
</template>

<script>
// @ is an alias to /src
import AuthorList from "@/components/author/AuthorList.vue"
import AuthorSave from "@/components/author/AuthorSave.vue"
import BookList from "@/components/book/BookList.vue"
import BookSave from "@/components/book/BookSave.vue"
import BookDetail from "@/components/book/BookDetail.vue"


export default {
  name: 'Home',
  components: 
   {
    AuthorList,
    AuthorSave,
    BookList,
    BookSave,
    BookDetail
  }
}
</script>
