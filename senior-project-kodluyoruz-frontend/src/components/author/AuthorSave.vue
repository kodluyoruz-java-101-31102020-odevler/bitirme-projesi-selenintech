<template>
  <div class="row">
    <div class="col-md-6">
      <input type="text" class="form-control" placeholder="Author Name" v-model="authorName"/>
    </div>
    <div class="col-md-1">
      <button type="button" class="btn btn-primary btn-block" v-on:click="save">Save</button>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      authorName: "",
    };
  },
  methods: {
      save(){
          if(this.authorName.length == 0){
            return
          }
          let author = {
              name: this.authorName
          }
          this.$emit("save",author)
             
      }
  },
};
</script>