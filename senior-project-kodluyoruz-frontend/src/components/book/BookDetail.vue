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
              {{ author.name }}
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      bookDetail: {
        id: 5,
        name: "adfg",
        publicationDate: "1977-02-12T00:00:00.000+00:00",
        description: "yüzer",
        authors: [
          {
            id: 2,
            name: "ayşe",
          },
          {
            id: 3,
            name: "ali",
          },
        ],
      },
    };
  },
};
</script>
<style scoped>
    .row-space{
        padding-top: 10px;
    }
</style>
