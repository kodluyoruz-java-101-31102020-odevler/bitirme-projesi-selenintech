<template>
  <div class="row">
    <div class="card">
      <div class="card-body">
        <div class="row">
          <div class="col">
            <div class="row row-space">
              <span><h5>Book Name</h5></span>
              <div>{{ bookDetail.name }}</div>
            </div>
            <div class="row row-space">
              <span><h5>Book Detail</h5></span>
              <div>{{ bookDetail.description }}</div>
            </div>
            <div class="row row-space">
              <span><h5>Publication Date</h5></span>
              <div>{{ bookDetail.publicationDate }}</div>
            </div>
          </div>
          <div class="col">
            <span><h5>Authors</h5></span>
            <div v-for="author in bookDetail.authors" :key="author.id">
              <router-link :to="{name:'authorDetail',params:{authorId: author.id}}">{{ author.name }}</router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
 props:["bookDetail"]
};
</script>
<style scoped>
    .row-space{
        padding-top: 10px;
    }
</style>
