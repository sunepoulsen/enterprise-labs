<template>
    <div>
        <Card>
            <template slot="title">
                Form
            </template>
            <template slot="content">
                <label-grid label="Name" :width="formWidth">
                    <InputText v-model="model.name"/>
                </label-grid>
                <label-grid label="Address" :width="formWidth">
                    <InputText v-model="model.address"/>
                </label-grid>
                <label-grid :width="formWidth">
                    <Button class="p-button-raised" label="Apply" @click="applyState" />
                </label-grid>
            </template>
        </Card>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import LabelGrid from '@/app/shared/components/layouts/LabelGrid.vue'
import { StoreStatesModel } from '@/app/core/store/modules/store-states/model/StoreStatesModel'

@Component({
  components: { LabelGrid }
})
export default class VueStoreStateForm extends Vue {
  formWidth = '150px';
  model: StoreStatesModel = new StoreStatesModel();

  applyState () {
    this.$store.dispatch('storeStates/setStoreStates', this.model)
  }
}
</script>

<style scoped>
</style>
