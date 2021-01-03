<template>
  <div class="row">
    <div class="col-md-6">
      <input type="text" class="form-control" placeholder="Search" v-model="bookName"/>
    </div>
    <div class="col-md-1">
      <button type="button" class="btn btn-primary btn-block" v-on:click="search">Search</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      bookName: "",
    };
  },
  methods: {
      search(){
        this.$emit("search",this.bookName)
        
             
    }
  },
};
</script>