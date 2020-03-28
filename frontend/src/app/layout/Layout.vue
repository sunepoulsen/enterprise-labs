<template>
    <div id="app">
        <div class="p-grid nested-grid">
            <div class="p-col-12">
                <layout-header/>
            </div>
            <div class="p-col-12">
                <router-view/>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
// @ is an alias to /src
import LayoutHeader from './components/LayoutHeader.vue'

import { Component, Vue } from 'vue-property-decorator'

@Component({
  components: {
    LayoutHeader
  }
})
export default class Layout extends Vue {
}
</script>

<style scoped>

</style>
