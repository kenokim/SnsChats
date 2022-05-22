import Vuex from 'vuex'
import axios from 'axios'

export default new Vuex.Store({
  state: {
    user: null
  },
  mutations: {
    SET_USER_DATA(state, userData) {
      state.user = userData
      localStorage.setItem('user', JSON.stringify(userData))
      axios.defaults.headers.common['Authorization'] = `Bearer ${
        userData.token
      }`
    }
  },
  actions: {
    register ({ commit }, credentials) {
      axios.post('http://localhost:8080/fake/register', credentials)
      .then(
          ({ data }) => {
            commit('SET_USER_DATA', data)
          }
      )
    },
    testlogin ({ commit }, credentials) {
      axios.post('http://localhost:8080/testlogin', credentials)
      .then(
        ({ data }) => {
          commit('SET_USER_DATA', data)
        }
      )
    }
  }
})