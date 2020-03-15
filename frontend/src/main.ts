import Vue from 'vue'
import App from './app/App.vue'
import router from './app/layout/Layout-Router'
import store from './app/core/Store'

import 'primevue/resources/themes/nova-light/theme.css'
import 'primevue/resources/primevue.min.css'
import 'primeicons/primeicons.css'

// Import PrimeVUE UI components
import Panel from 'primevue/panel'

Vue.component('Panel', Panel)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
