<template>
    <div class="p-grid">
        <div class="p-col-12">
            <vue-store-state-form/>
        </div>
        <div class="p-col-12">
            <vue-store-state-result/>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import VueStoreStateForm from '@/app/labs/ui/store-states/components/VueStoreStateForm.vue'
import VueStoreStateResult from '@/app/labs/ui/store-states/components/VueStoreStateResult.vue'

@Component({
  components: {
    VueStoreStateForm,
    VueStoreStateResult
  }
})
export default class VueStoreState extends Vue {
}
</script>

<style scoped>
</style>
