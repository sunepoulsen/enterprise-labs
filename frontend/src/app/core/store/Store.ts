import Vue from 'vue'
import Vuex from 'vuex'
import { StoreStatesModel } from '@/app/core/store/model/store-states/StoreStatesModel'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    storeStates: new StoreStatesModel()
  },
  mutations: {
    setStoreStates (state, model: StoreStatesModel) {
      state.storeStates = model
    }
  },
  actions: {
    setStoreStates (context, model: StoreStatesModel) {
      context.commit('setStoreStates', model.clone())
    }
  },
  modules: {

  }
})
