import { StoreStatesModel } from '@/app/core/store/modules/store-states/model/StoreStatesModel'
import { ActionContext } from 'vuex'

export const StoreStatesModule = {
  namespaced: true,

  state: {
    storeStates: new StoreStatesModel()
  },
  mutations: {
    setStoreStates (state: any, model: StoreStatesModel) {
      state.storeStates = model
    }
  },
  actions: {
    setStoreStates (context: ActionContext<any, StoreStatesModel>, model: StoreStatesModel) {
      context.commit('setStoreStates', model.clone())
    }
  }
}
