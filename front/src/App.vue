<script setup>
import { RouterLink, RouterView } from 'vue-router'
import HelloWorld from '@/components/HelloWorld.vue'
import { authComputed } from '@/vuex/helpers.js'
</script>

<template>
  <header>
    <img alt="Vue logo" class="logo" src="@/assets/bulbarsaur.jpg" width="125" height="125" />

    <div class="wrapper">
      <HelloWorld msg="Sns Chats" />

      <nav>
        <RouterLink class="btn btn-success btn-sm md-3" to="/">홈</RouterLink>
        <!--<RouterLink to="/about">About</RouterLink>-->
        <RouterLink class="btn btn-success btn-sm" to="/chats">채팅</RouterLink>
        <!--<RouterLink class="btn btn-success btn-sm" to="/fakechats">FakeChats</RouterLink>-->
        <!--<RouterLink to="/register">Register</RouterLink>-->
        <!--<RouterLink v-if="!loggedIn" to="/login">Login</RouterLink>
        <button v-else type="button" class="logoutButton" @click="logout">Logout</button>-->
        <RouterLink class="btn btn-primary btn-sm" to="/login">로그인</RouterLink>
        <button type="button" class="btn btn-secondary btn-sm" @click="logout">로그아웃</button>
    

      </nav>
    </div>
  </header>

  <RouterView />
</template>

<script>
  export default {
    methods: {
      logout () {
        console.log('Logged out')
        this.$store.commit('CLEAR_USER_DATA')
      }
    },
    computed: {
      ...authComputed
    }
  }
</script>

<style>
@import '@/assets/base.css';

#app {
  max-width: 1280px;
  margin: 0 auto;
  padding: 2rem;

  font-weight: normal;
}

header {
  line-height: 1.5;
  max-height: 100vh;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

a,
.green {
  text-decoration: none;
  color: hsla(160, 100%, 37%, 1);
  transition: 0.4s;
}

@media (hover: hover) {
  a:hover {
    background-color: hsla(160, 100%, 37%, 0.2);
  }
}

nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
}

@media (min-width: 1024px) {
  body {
    display: flex;
    place-items: center;
  }

  #app {
    display: grid;
    grid-template-columns: 1fr 1fr;
    padding: 0 2rem;
  }

  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  nav {
    text-align: left;
    margin-left: -1rem;
    font-size: 1rem;

    padding: 1rem 0;
    margin-top: 1rem;
  }
}
</style>
