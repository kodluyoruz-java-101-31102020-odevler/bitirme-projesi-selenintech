<template>
  <div>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">Author</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="author in authors" :key="author.id">
          
          <td><router-link :to="{name:'authorDetail',params:{authorId: author.id}}">{{ author.name }}</router-link></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  
  props:["authors"]
};
</script>