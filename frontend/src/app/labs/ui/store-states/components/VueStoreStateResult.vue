<template>
    <div>
        <Card>
            <template slot="title">
                Result
            </template>
            <template slot="content">
                This area will display the result of the form input controls:
                <p/>
                <label-grid label="Name" :width="formWidth">{{ getStoreStates().name }}</label-grid>
                <label-grid label="Address" :width="formWidth">{{ getStoreStates().address }}</label-grid>

            </template>
        </Card>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import { StoreStatesModel } from '@/app/core/store/modules/store-states/model/StoreStatesModel'
import LabelGrid from '@/app/shared/components/layouts/LabelGrid.vue'

@Component({
  components: {
    LabelGrid
  }
})
export default class VueStoreStateResult extends Vue {
  formWidth = '150px';

  getStoreStates (): StoreStatesModel {
    return this.$store.state.storeStates.storeStates
  }
}
</script>

<style scoped>
</style>
