<template>
    <div class="p-grid p-justify-center">
        <div class="p-col-5">
            <h1>VUE Component Rendering</h1>

            <tab-view>
                <tab-panel header="Lab">
                    <vue-component-render/>
                </tab-panel>
                <tab-panel header="Doc">
                    <vue-component-render-doc/>
                </tab-panel>
            </tab-view>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import VueComponentRender from '@/app/labs/ui/component-rendering/components/VueComponentRender.vue'
import VueComponentRenderDoc from '@/app/labs/ui/component-rendering/components/VueComponentRenderDoc.vue'

@Component({
  components: {
    VueComponentRender,
    VueComponentRenderDoc
  }
})
export default class VueComponentRenderLab extends Vue {
}
</script>

<style scoped>
</style>
