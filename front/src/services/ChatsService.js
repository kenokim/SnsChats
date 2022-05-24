import axios from "axios"

const apiClient = axios.create({
  baseURL: 'http://localhost:8080',
  withCredentials: false,
  headers: {

  }
})

export default {
  getChats () {
    return axios.get('http://localhost:8080/chats')
  }
}