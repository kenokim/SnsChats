<script>
import axios from "axios"
import ChatsVo from "../components/ChatsVo.vue"

export default {
  components: { ChatsVo },
  data () {
    return {
      isLoading: true,
      chatsList: []
    }
  },
  created() {
    axios.get('http://localhost:8080/chats').then(( { data } ) => {
      this.chatsList = data
      this.isLoding = false
      console.log(data)
    }).catch( () => {
      this.$router.push({ name: 'login' })
    })
  },
  methods: {
    generate() {
      axios.post('http://localhost:8080/chats').then(() => {
        this.$router.push({ name: 'chats' })
      })
    }
  }
}
</script>

<template>
<div>
  <span>Hello world</span>
  <br>
  {{ chatsList }}
  <template v-if="!isLoading">
    <ChatsVo v-for="chats in chatsList" :key="chats.id" :chats="chats" />
  </template>
  <p v-else>
    Loading Chats
  </p>
</div>
<button v-on:click="generate">GENERATE</button>
</template>