<template>
<div>
  <h5>먼저 로그인 하세요 !</h5>
  <br>
  <button class="btn btn-primary w-50" v-on:click="testlogin">
    <img src="@/assets/pokeball2.png" width="27">
    테스트 회원 로그인
  </button>
  <br><br>
  <button class="btn btn-secondary w-50">
    <img src="@/assets/googlelogo.jpg" width="27">
    구글 로그인
  </button>
  <br><br>
  <button class="btn btn-warning w-50">
    <img src="@/assets/instalogo.jpeg" width="27">
    인스타 로그인
  </button>
</div>
    <!--<span>
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
      <button v-on:click="testlogin">TestLogin</button>-->

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