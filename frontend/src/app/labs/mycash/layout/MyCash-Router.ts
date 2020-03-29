import Vue from 'vue'
import VueRouter, { RouteConfig } from 'vue-router'
import MyCashHome from '@/app/labs/mycash/modules/home/pages/MyCashHome.vue'
import AccountingLayout from '@/app/labs/mycash/layout/AccountingLayout.vue'
import AccountingHome from '@/app/labs/mycash/modules/accounting/pages/AccountingHome.vue'
import MyCashLayout from '@/app/labs/mycash/layout/MyCashLayout.vue'

Vue.use(VueRouter)

const myCashRoute: RouteConfig = {
  path: '/labs/mycash',
  component: MyCashLayout,
  children: [
    {
      path: '',
      component: MyCashHome
    },
    {
      path: '/labs/mycash/:id',
      component: AccountingLayout,
      children: [
        {
          path: '',
          component: AccountingHome
        }
      ]
    }
  ]
}

export default myCashRoute
