import Vue from 'vue'
import VueRouter, { RouteConfig } from 'vue-router'
import Home from '../modules/home/pages/Home.vue'
import About from '@/app/modules/about/pages/About.vue'
import VueComponentRenderLab from '@/app/labs/ui/component-rendering/pages/VueComponentRenderLab.vue'
import VueStoreStateLab from '@/app/labs/ui/store-states/pages/VueStoreStateLab.vue'
import LogicCalendarLab from '@/app/labs/ui/calendar/pages/LogicCalendarLab.vue'
import HelloWorldLab from '@/app/labs/integrations/helloworld/pages/HelloWorldLab.vue'
import myCashRoute from '@/app/labs/mycash/layout/MyCash-Router'

Vue.use(VueRouter)

const routes: Array<RouteConfig> = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/labs/ui/component-rendering',
    component: VueComponentRenderLab
  },
  {
    path: '/labs/ui/store-states',
    component: VueStoreStateLab
  },
  {
    path: '/labs/ui/calendar',
    component: LogicCalendarLab
  },
  {
    path: '/labs/integrations/helloworld',
    component: HelloWorldLab
  },
  myCashRoute,
  {
    path: '/about',
    name: 'About',
    component: About
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
  routes: routes
})

export default router
