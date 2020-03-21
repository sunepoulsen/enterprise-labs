import Vue from 'vue'
import VueRouter, { RouteConfig } from 'vue-router'
import Home from '../modules/home/pages/Home.vue'
import About from '@/app/modules/about/pages/About.vue'
import { AppSettings } from '@/app/configs/AppSettings'

Vue.use(VueRouter)

const routes: Array<RouteConfig> = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
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

/**
 * Adds all labs from AppSettings to a RouteConfig list as a RouteConfig.
 *
 * @param routes The RouteConfig list to add the lab RouteConfig to.
 *
 * @returns The concatenated list of RouteConfig's.
 */
function addLabRoutes (routes: Array<RouteConfig>) {
  const labRoutes: Array<RouteConfig> = []
  const settings: AppSettings = new AppSettings()

  for (const group of settings.labs()) {
    for (const lab of group.labs) {
      labRoutes.push({
        path: lab.route.path,
        name: lab.name,
        component: lab.route.component
      })
    }
  }

  return routes.concat(labRoutes)
}

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: addLabRoutes(routes)
})

export default router
