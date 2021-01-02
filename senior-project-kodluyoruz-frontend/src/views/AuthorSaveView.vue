<template>
  <div class="container">
    <author-save @save="saveAuthor" />
    <author-list :authors="authors" />
  </div>
</template>

<script>
// @ is an alias to /src
import AuthorList from "@/components/author/AuthorList.vue";
import AuthorSave from "@/components/author/AuthorSave.vue";
import AuthorService from "@/service/authorService.js";

var authorService = new AuthorService();
export default {
  name: "Home",
  components: {
    AuthorList,
    AuthorSave,
  },
  data() {
    return {
      authors: [],
    };
  },
  created() {
    this.loadData();
  },
  methods: {
    loadData() {
      authorService.getAll()
        .then((response) => {
        this.authors = response.data.authors;
      });
    },
    saveAuthor(author) {
      authorService.save(author)
      .then(() => {
        this.loadData()
      })
    },
  },
};
</script>
