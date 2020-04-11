<template>
    <div class="p-grid p-justify-center">
        <div class="p-col-5">
            <h1>VUEx Store states</h1>

            <tab-view>
                <tab-panel header="Lab">
                    <vue-store-state/>
                </tab-panel>
                <tab-panel header="Doc">
                    <vue-store-state-doc/>
                </tab-panel>
            </tab-view>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import VueStoreState from '@/app/labs/ui/store-states/components/VueStoreState.vue'
import VueStoreStateDoc from '@/app/labs/ui/store-states/components/VueStoreStateDoc.vue'

@Component({
  components: {
    VueStoreState,
    VueStoreStateDoc
  }
})
export default class VueStoreStateLab extends Vue {
}
</script>

<style scoped>
</style>
