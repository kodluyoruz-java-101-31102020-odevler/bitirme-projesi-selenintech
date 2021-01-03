<template>
  <div class="row">
    <div class="row row-space">
      <div class="col-md-4">
        <input type="text" class="form-control" placeholder="Book Name" v-model="bookName" />
      </div>
      
      <div class="col-md-4">
        <select
          class="form-select"
          aria-label="Default select example"
          multiple
          v-model="selectedAuthors"
        >
          <option selected>Select Author</option>
          <option v-for="author in authors" :key="author.id" :value="author">
            {{ author.name }}
          </option>
        </select>
      </div>
    </div>
    <div class="row row-space">
      <div class="col-md-4">
        <input type="text" class="form-control" placeholder="Description" v-model="description"/>
      </div>
      <div class="col-md-4">
        <input type="text" class="form-control" placeholder="Publication Date (yyyy-mm-dd)" v-model="publicationDate" />
      </div>
      <div class="col-md-1">
        <button type="button" class="btn btn-primary btn-block"  @click="save">Save</button>
      </div>
    </div>
  </div>
</template>

<script>
import AuthorService from "@/service/authorService.js";
var authorService = new AuthorService();
export default {
  data() {
    return {
      authors: [],
      selectedAuthors: [],
      bookName: "",
      description: "",
      publicationDate: "",
    };
  },
  created() {
    this.loadAuthors();
  },
  methods: {
    loadAuthors() {
      authorService.getAll().then((response) => {
        this.authors = response.data.authors;
      });
    },
    save(){
      if(this.bookName.length == 0 || this.selectedAuthors.length == 0 || this.publicationDate.length == 0){
        
        return
      }
      let authorIds = this.selectedAuthors.map(author => author.id)
      let book = {
        name: this.bookName,
        description: this.description,
        publicationDate: this.publicationDate,
        authorIds: authorIds
      }
      console.log("burdan")
      this.$emit("save", book)

    }
  },
};
</script>
<style scoped>
.row-space {
  padding-top: 10px;
}
</style>



    
