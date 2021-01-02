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
          <td>{{author.name}}</td>
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