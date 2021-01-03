import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/authors',
    component: () => import('../views/AuthorSaveView.vue')
  },
  {
    path: '/books',
    component: () => import('../views/BookSaveView.vue')
  },
  {
    path: '/books/:bookId',
    component: () => import('../views/BookDetailView.vue'),
    name:'bookDetail'
  },
  {
    path: '/authors/:authorId',
    component: () => import('../views/AuthorDetailView.vue'),
    name:'authorDetail'
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
