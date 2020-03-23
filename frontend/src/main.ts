import Vue from 'vue'
import App from './app/App.vue'
import router from './app/layout/Layout-Router'
import store from './app/core/Store'

import 'primevue/resources/themes/rhea/theme.css'
import 'primevue/resources/primevue.min.css'
import 'primeicons/primeicons.css'
import 'primeflex/primeflex.css'

// Import PrimeVUE UI components
import Button from 'primevue/button'
import Card from 'primevue/card'
import Panel from 'primevue/panel'
import TabView from 'primevue/tabview'
import TabPanel from 'primevue/tabpanel'

Vue.component('Button', Button)
Vue.component('Card', Card)
Vue.component('Panel', Panel)
Vue.component('TabView', TabView)
Vue.component('TabPanel', TabPanel)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
