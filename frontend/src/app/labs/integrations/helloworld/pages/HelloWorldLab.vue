<template>
    <div>
        <h1>Hello World Integration</h1>

        <tab-view>
            <tab-panel header="Hello World">
                <hello-world-integration/>
            </tab-panel>
            <tab-panel header="Doc">
                <hello-world-doc/>
            </tab-panel>
        </tab-view>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import HelloWorldDoc from './../components/HelloWorldDoc.vue'
import HelloWorldIntegration from './../components/HelloWorldIntegration.vue'

@Component({
  components: {
    HelloWorldIntegration,
    HelloWorldDoc
  }
})
export default class HelloWorldLab extends Vue {
}
</script>

<style scoped>

</style>
