import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../modules/home/pages/Home.vue'
import About from '@/app/modules/about/pages/About.vue'
import VueComponentRenderPage from '@/app/labs/vue/component-rendering/pages/VueComponentRenderPage.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    component: About
  },
  {
    path: '/labs/vue/component-rendering',
    name: 'Component Rendering',
    component: VueComponentRenderPage
  }

  // {
  //   path: '/about',
  //   name: 'About',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  // }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
