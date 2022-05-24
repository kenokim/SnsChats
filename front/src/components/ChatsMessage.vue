<template>
  <div class="container rounded p-1 border border-warning">
    {{ chatsMessage.id }}
    <span>: </span>
    {{ chatsMessage.content }}
  </div>
</template>
<script>
export default {
  props: {
    chatsMessage: null
  }
}
</script>

<style>
.bg-message {
  background: yellowgreen
}
.border-message {
  border-color: yellowgreen
}
</style>