import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
//import store from './store'
import { createStore } from 'vuex'
import Vuex from 'vuex'
import axios from 'axios'

const store = createStore({
  state () {
    return {
      user: null
    }
  },
  mutations: {
    SET_USER_DATA(state, userData) {
      state.user = userData
      localStorage.setItem('user', JSON.stringify(userData))
      axios.defaults.headers.common['Authorization'] = `Bearer ${
        userData.token
      }`
      //axios.defaults.withCredentials = true
      //axios.defaults.headers.common['Authorization'] = userData.token
    }
  }
})

const app = createApp(App)
//app.component('SearchInput', SearchInputComponent)
//app.directive('focus', FocusDirective)
app.use(router)
app.use(store)
app.use(Vuex)
app.mount('#app')