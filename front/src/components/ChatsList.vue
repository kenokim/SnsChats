<template>
<div>
  <div class="container">
    <div class="row">
      <p class="col-10">채팅방에 접속하세요 ! </p>
      <button class="btn btn-secondary btn-sm col-2" v-on:click="generate">새 채팅방</button>
      <br>
      
      <template v-if="!isLoading">
        <ChatsVo v-for="chats in chatsList" :key="chats.id" :chats="chats" />
      </template>
      
      <p v-else>
        Loading Chats
      </p>
      <div class="col-1 btn" v-on:click="previous">
        <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-arrow-left-circle" viewBox="0 0 16 16">
          <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-4.5-.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5z"/>
        </svg>
      </div>
      <div class="col-10"></div>
      <div class="col-1 btn" v-on:click="next">
        <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-arrow-right-circle" viewBox="0 0 16 16">
          <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z"/>
        </svg>
      </div>

    </div>
  </div>
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
      chatsList: [],
      pageNum: 0,
      queryParam: {
        params: {
          pageNum: this.pageNum
        }
      }
    }
  },

  created() {
    this.load()
  },

  methods: {
    load () {
      axios.get('http://localhost:8080/chats', { params: { pageNum: this.pageNum }}).then(( { data } ) => {
        this.chatsList = data
        this.isLoading = false
        console.log(data)
      }).catch( () => {
        this.$router.push({ name: 'login' })
      })
    },

    generate () {
      axios.post('http://localhost:8080/chats').then(() => {
        this.load().then(() => {

        })
      })
    },

    previous () {
      this.pageNum -= 1 // async?
      this.load()
    },

    next () {
      this.pageNum += 1 // async?
      this.load()
    }

  }
}
</script>
