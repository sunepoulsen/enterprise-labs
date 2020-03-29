import Vue from 'vue'
import VueRouter, { RouteConfig } from 'vue-router'
import MyCashHome from '@/app/labs/mycash/modules/home/pages/MyCashHome.vue'

Vue.use(VueRouter)

const myCashRoute: RouteConfig = {
  path: '/labs/mycash',
  component: MyCashHome
}

export default myCashRoute
