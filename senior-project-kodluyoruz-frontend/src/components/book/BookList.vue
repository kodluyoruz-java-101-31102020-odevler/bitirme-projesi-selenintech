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
          <td>{{ book.name }}</td>
          <td> 
              <span v-for="author in book.authors" :key="author.id">
                  {{author.name}}&nbsp;
              </span>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      books: [
        {
          id: 5,
          name: "adfg",
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
        {
          id: 1,
          name: "balina",
          authors: [],
        },
        {
          id: 2,
          name: "balina",
          authors: [],
        },
        {
          id: 3,
          name: "adfg",
          authors: [],
        },
        {
          id: 4,
          name: "adfg",
          authors: [],
        },
      ],
    };
  },
};
</script>