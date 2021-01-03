<template>
  <div>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">Book Name</th>
          <th scope="col">Authors</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="book in books" :key="book.id">
          <td>
            <router-link :to="{name:'bookDetail',params:{bookId: book.id}}">{{ book.name }}</router-link>
            </td>
          <td> 
            
              <span v-for="author in book.authors" :key="author.id">
                 <router-link :to="{name:'authorDetail',params:{authorId: author.id}}">{{ author.name }}</router-link>
                  &nbsp;
                
              </span>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  props:["books"]
};
</script>