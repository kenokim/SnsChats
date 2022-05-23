<template>
<div>
  <span>채팅방에 접속하세요 ! </span>
  <button class="btn btn-secondary btn-sm" v-on:click="generate">새 채팅방</button>
  <br>
  <template v-if="!isLoading">
    <ChatsVo v-for="chats in chatsList" :key="chats.id" :chats="chats" />
  </template>
  <p v-else>
    Loading Chats
  </p>
  <!--<div v-if="!isLoading">
  </div>
  <div v-else>Loading...</div>-->
</div>
</template>

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
    this.load()
  },
  methods: {
    load () {
      axios.get('http://localhost:8080/chats').then(( { data } ) => {
      this.chatsList = data
      this.isLoading = false
      console.log(data)
    }).catch( () => {
      this.$router.push({ name: 'login' })
    })
    },
    generate () {
      axios.post('http://localhost:8080/chats').then(() => {
        //this.$router.push({ name: 'chats' })
        this.load().then(() => {
        //  this.isLoading = false
        })
      })
    }
  }
}
</script>
