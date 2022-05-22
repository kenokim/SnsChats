<template>
    <span>
      You must login first!
    </span>
      <div>
        <form @submit.prevent="login">
          <label for="email">
            Email:
          </label>
          <input v-model="email" type="email" name="email" value>
          
          <label for="password">
            Password:
          </label>
          <input v-model="password" type="password" name="password" value>
      
          <button type="submit" name="button">
            Login
          </button>
        </form>
      </div>
      <button v-on:click="testlogin">TestLogin</button>
</template>

<script>
import axios from 'axios'
  export default {
    components: {
      axios
    },
    data () {
      return {
        email: '',

      }
    },
    methods: {
      login () {
        this.$store.dispatch('login', {
          email: this.email,
          password: this.password
        })
        .then( () => {
          this.$router.push( { name: 'chats'} )
        })
      },
      testlogin() {
        return axios.post('http://localhost:8080/testlogin')
          .then(({ data }) => {
            this.$store.commit('SET_USER_DATA', data) 
            this.$router.push({ name: 'chats' })
        })
      }
    }
  }
</script>