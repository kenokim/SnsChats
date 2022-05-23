<template>
  <div class="container">
    <div class="row p-3 mb-2 bg-chats rounded">
      <p class="col-4">{{this.chats.title}}</p>
      <p class="col-4">{{this.chats.createAt}}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'chatsvo',
  props: {
    chats: null
  }
}
</script>

<style>
.bg-chats {
  background: rgb(175, 255, 172);
}
</style>