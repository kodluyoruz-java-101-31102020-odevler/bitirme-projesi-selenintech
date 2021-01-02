<template>
  <div class="row " >
    <div class="row row-space">
      <div class="col-md-4">
        <input type="text" class="form-control" placeholder="Book Name" />
      </div>

      <div class="col-md-4">
        <select class="form-select" aria-label="Default select example" multiple>
          <option selected>Select Author</option>
          <option v-for="author in authors" :key="author.id" :value="author">{{author.name}}</option>
        </select>
      </div>
    </div>
    <div class="row row-space">
      <div class="col-md-4">
        <input type="text" class="form-control" placeholder="Description" />
      </div>
      <div class="col-md-1">
          <button type="button" class="btn btn-primary btn-block">Save</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      authors: [
        {
          id: 1,
          name: "selen",
        },
        {
          id: 2,
          name: "ayşe",
        },
        {
          id: 3,
          name: "ali",
        },
      ],
    };
  },
};
</script>
<style scoped>
    .row-space{
        padding-top: 10px;
    }
</style>

    
