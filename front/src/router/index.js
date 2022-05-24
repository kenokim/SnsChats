import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ChatsView from '../views/ChatsView.vue'
import ChatsDetails from '../views/ChatsDetails.vue'
import FakeChatsView from '../views/FakeChatsView.vue'
import RegisterUser from '../views/RegisterUser.vue'
import LoginUser from '../views/LoginUser.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/chats',
      name: 'chats',
      component: ChatsView
    },
    {
      path: '/chats/:id',
      name: 'ChatsDetails',
      component: ChatsDetails
    },
    {
      path: '/fakechats',
      name: 'fakechats',
      component: FakeChatsView
    },
    {
      path: '/register', 
      name: 'register',
      component: RegisterUser
    },
    {
      path: '/login',
      name: 'login',
      component: LoginUser
    }
  ]
})

export default router
