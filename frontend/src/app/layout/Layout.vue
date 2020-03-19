<template>
    <div id="app">
        <div class="p-grid nested-grid">
            <div class="p-col-12">
                <layout-header/>
            </div>
            <div class="p-col-12">
                <div class="p-grid">
                    <div class="p-col-2">
                        <layout-navigator/>
                    </div>
                    <div class="p-col-10">
                        <router-view/>
                    </div>
                </div>
            </div>
            <div class="p-col-12">
                <layout-footer/>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
// @ is an alias to /src
import LayoutHeader from './components/LayoutHeader.vue'
import LayoutNavigator from './components/LayoutNavigator.vue'
import LayoutFooter from './components/LayoutFooter.vue'

import { Component, Vue } from 'vue-property-decorator'

@Component({
  components: {
    LayoutHeader,
    LayoutNavigator,
    LayoutFooter
  }
})
export default class Layout extends Vue {
}
</script>

<style scoped>

</style>
