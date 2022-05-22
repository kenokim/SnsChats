<template>
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
  export default {
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
          this.$router.push( { name: 'chatslist'} )
        })
      },
      testlogin() {
        this.$store.dispatch('testlogin', {
          email: this.email,
          password: this.password
        })
        .then( () => {
          this.$router.push( { name: 'chatslist' } )
        })
      }
    }
  }
</script>