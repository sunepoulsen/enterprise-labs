import Vue from 'vue'
import App from './app/App.vue'
import router from './app/layout/Layout-Router'
import store from './app/core/store/Store'

import 'primevue/resources/themes/rhea/theme.css'
import 'primevue/resources/primevue.min.css'
import 'primeicons/primeicons.css'
import 'primeflex/primeflex.css'
// Import PrimeVUE UI components
import Button from 'primevue/button'
import Card from 'primevue/card'
import Column from 'primevue/column'
import ColumnGroup from 'primevue/columngroup'
import DataTable from 'primevue/datatable'
import InputText from 'primevue/inputtext'
import MegaMenu from 'primevue/megamenu'
import Panel from 'primevue/panel'
import OverlayPanel from 'primevue/overlaypanel'
import TabView from 'primevue/tabview'
import TabPanel from 'primevue/tabpanel'
import Toolbar from 'primevue/toolbar'

Vue.component('Button', Button)
Vue.component('Card', Card)
Vue.component('Column', Column)
Vue.component('ColumnGroup', ColumnGroup)
Vue.component('DataTable', DataTable)
Vue.component('InputText', InputText)
Vue.component('MegaMenu', MegaMenu)
Vue.component('Panel', Panel)
Vue.component('OverlayPanel', OverlayPanel)
Vue.component('TabView', TabView)
Vue.component('TabPanel', TabPanel)
Vue.component('Toolbar', Toolbar)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
