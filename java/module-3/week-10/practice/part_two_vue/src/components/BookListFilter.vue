!<template>
  <div id="movie-filter">
    <h2>Filter</h2>
    <form v-on:submit.prevent="filter">
      <div class="form-group">
        <label for="search">Title:</label>
        <input type="text" placeholder="Search..." v-model="titleString" id="search" />
      </div>
      <div class="form-group" v-if="allGenres.length > 0">
        <label for="genre-list">Genres:</label>
        <select id="genre-list" v-model="genreList" multiple>
          <option v-for="genre of allGenres" v-bind:key="genre.id"
              v-bind:value="genre.name">{{genre.name}}</option>
        </select>
      </div>
      <div class="button-group">
        <button id="submit-button" type="submit">Filter</button>
        <button v-on:click="clear">Reset</button>
      </div>
    </form>
  </div>
</template>

<script>
import bookService from "../services/BookService";

export default {
  data() {
    return {
      allGenres: [],
      titleString: "",
      genreList: []
    };
  },
  created(){
    bookService.getGenres()
      .then(response => {
        this.allGenres = response.data;
      })
      .catch((error) => {
        this.error = `Could not get the genres list for the filter.`;
        console.log(this.error, error.response);
      });
  },
  methods: {
    filter() {
      this.$emit("filterValueChange", {titleString: this.titleString, genreList: this.genreList});
    },
    clear() {
      this.titleString='';
      this.genreList=[];
    }
  },
};
</script>

<style scoped>

#submit-button {
  background-color: #E69C60;

}
#movie-filter {
  display: flex;
  flex-wrap: nowrap;
  align-items: top;
  gap: 2rem;
  margin-bottom: 2rem;
  padding: 1rem 2rem;
  width: fit-content;
  
}

form {
  display: flex;
  flex-wrap: wrap;
  gap: 2rem;
  justify-content: center;
  align-items: top;
  background-color:#C0B387;
  border: solid 1px;
}

.form-group {
  display: flex;
  align-items: baseline;
}

label {
  margin-right: 0.5rem;
}

h2 {
  font-size: 1.2rem;
  font-weight: bold;
}

input {
  background-color: #F9F6F0;
  border: 1px solid #30362F;
  display: inline-block;
  height: fit-content;
  margin-bottom: 1rem;
  padding: 0.25rem 0.75rem;
}

button {
  background-color: #e9e7e3;
  border: 1px solid #30362F;
  border-radius: 0.25rem;
  display: inline-block;
  height: fit-content;
  padding: 0.25rem 0.75rem;
  margin-bottom: 0.5rem;
  margin-right: 0.5rem;
  width: 100px;
}

select {
  background-color: #F9F6F0;
  border: 1px solid #30362F;
  display: inline-block;
}

option {
  padding: 0.25rem 0.5rem;
}

</style>
