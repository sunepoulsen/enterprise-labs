import Vue from 'vue'
import Vuex from 'vuex'
import { StoreStatesModule } from '@/app/core/store/modules/store-states/StoreStatesModule'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    storeStates: StoreStatesModule
  }
})
