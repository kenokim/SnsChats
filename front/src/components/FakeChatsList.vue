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
    axios.get('http://localhost:8080/fake/chats').then(( { data } ) => {
      this.chatsList = data.chatsList
      this.isLoding = false
    })
  }
}
</script>

<template>
<div>
  <span>Hello world</span>
  <br>
  <template v-if="!isLoading">
    <ChatsVo v-for="chats in chatsList" :key="chats.id" :chats="chats" />
  </template>
  <p v-else>
    Loading Chats
  </p>
</div>
</template>