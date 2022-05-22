<template>
      <div>
        <!--<form @submit.prevent="register">-->
        <form v-on:click="register">
          <label for="name">
            Name:
          </label>
          <input v-model="name" type="text" name="name" value>
    
          <label for="email">
            Email:
          </label>
          <input v-model="email" type="email" name="email" value>
    
          <label for="password">
            Password:
          </label>
          <input v-model="password" type="password" name value>
    
          <button type="submit" name="button">
            Register
          </button>
        </form>
      </div>

      <button v-on:click="send">Button</button>
      
</template>

<script>
import axios from 'axios'
export default {
  components: {
    axios,
  },
  data () {
    return {
      name: '',
      email: '',
      password: ''
    }
  },
  methods: {
    register () {
      axios.post('http://localhost:8080/register', { name: this.name, email: this.email, password: this.password })
      .then(({ data }) => {
        this.$store.commit('SET_USER_DATA', data) 
        this.$router.push({ name: 'fakechats' })
      })
    },

    send() {
      return axios.post('http://localhost:8080/fake/register')
      .then(({ data }) => {
        console.log('user data is:', data)
        this.$store.commit('SET_USER_DATA', data) 
        this.$router.push({ name: 'fakechats' })
      })
    }
  }
}
</script>